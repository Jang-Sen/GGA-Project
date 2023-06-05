<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gga_plz</title>
<link rel="stylesheet" href="http://localhost:9000/gga_plz/css/gga.css"> <!-- gga.css -->
<link rel="stylesheet" href="http://localhost:9000/gga_plz/css/am-pagination.css">
<script src="http://localhost:9000/gga_plz/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/gga_plz/js/gga_jquery.js"></script>
<script src="http://localhost:9000/gga_plz/js/gga_javascript.js"></script>
<script src="http://localhost:9000/gga_plz/js/am-pagination.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
	<!-- 부트스트랩 -->
</head>
<script>
$(document).ready(function(){
	var pager = jQuery('#ampaginationsm').pagination({
	
	    maxSize: '${maxSize}',	    		// max page size
	    totals: '${totals}',	// total pages	
	    page: '${page}',		// initial page 현제 페이지 reqpage
	    pageSize: '${pageSize}',			// max number items per page
	
	    // custom labels		
	    lastText: '&raquo;&raquo;', 		
	    firstText: '&laquo;&laquo;',		
	    prevText: '&laquo;',		
	    nextText: '&raquo;',
			     
	    btnSize:'sm'	// 'sm'  or 'lg'		
	});
	
	jQuery('#ampaginationsm').on('am.pagination.change',function(e){
		   jQuery('.showlabelsm').text('The selected page no: '+e.page);
           $(location).attr('href', "http://localhost:9000/mycgv_jsp/board_list.do?page="+e.page);       
    });
	
	});
</script>
<style>
@media (min-width: 768px) {
  .container {
    width: 750px;
  }
}

@media (min-width: 992px) {
  .container {
    width: 1000px;
  }
}
section.board table {
	text-align:center;
	margin:auto;
}
.binput{
	width:95%;
	border-color:#ddd;
}
.btextarea{
	width:95%;
	border-color:#ddd;
}
.table td {
text-align:left;
}
.table tr:last-child td {
text-align:center;
}

section.board form table img#boardUpdate,
section.board form table img#boardList,
section.board form table img#boardDelete{ /* 버튼이미지 */
	height:50px;
	width:117px;
	cursor:pointer;
}

section.board form table.comment_box {
	border:1px solid red;
}


</style>
<body>
	<!-- header -->
	<header>
		<jsp:include page="/header.do" />
	</header>
	<!-- header -->
	
	<!-- content -->
	<div class="container text-center">
		<section class="board">
			<h1>게시판</h1>
			<form name="contentForm" action="board_delete_proc.do?bid=${boardVo.bid}"  method="post">
				<table class="table table-bordered" style="width: 90%;">
					<tr>
						<th>제목</th>
						<td>${boardVo.btitle}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							${boardVo.bcontent}<br><br><br><br>
							<c:set var="imgName" value="${boardVo.bsfile}"></c:set>
							<c:set var="imgLength" value="${fn:length(imgName)}"></c:set>
							<c:if test="${imgLength != 37}">
								<img id="content_img"src="http://localhost:9000/gga_plz/upload/${boardVo.bsfile }">
							</c:if>
						</td>
					</tr>
					<tr>
						<th>평점</th>
						<td>${boardVo.score }</td>
						
					</tr>
					<tr>
						<th>조회수</th>
						<td>${boardVo.bhits }</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${boardVo.mid }</td>
					</tr>
					<tr>
						<th>작성일자</th>
						<td>${boardVo.bdate }</td>
					</tr>					
					<tr>
						<td colspan="4">
						<a href ="board_update.do?bid=${boardVo.bid}">
							<img id="boardUpdate" src="http://localhost:9000/gga_plz/images/editbtn.png"></a>
							<img id="boardDelete" src="http://localhost:9000/gga_plz/images/deletebtn.png">
							<a href="board_list.do">
								<img id="boardList"src="http://localhost:9000/gga_plz/images/listbtn.png"></a>
						</td>				
					</tr>
				</table>
			</form>
			
			<%-- <c:choose> --%>
			<%-- <c:when test="${sessionScope.sid == null}"> --%>
				<img id="commentSample"src="http://localhost:9000/gga_plz/images/commentSample.png">
				<div id="commentLogin"><a href="http://localhost:9000/gga_plz/login.do">댓글 확인 및 작성은 로그인이 필요합니다.</a></div>
			<%-- </c:when> --%>
			<%-- <c:otherwise> --%>
			<%-- </c:choose> --%>
			<form id="commentForm" name="commentForm" action="board_comment_proc.do"  method="post">
				<input type="hidden" name="sid" value="sid">
				<input type="hidden" name="bid" value="${boardVo.bid }">
				<table border="3" class="comment_box">
					<tr>
						<th colspan="3">뎃글 창</th>
					</tr>
					<c:if test="${totals == 0}">
					<tr>
						<td><input type="text" name="sid" value="sid" disabled></td>
						<td><textarea id="bccontent" name="bccontent" placeholder="*200자 이내로 작성해주세요"></textarea></td>
						<td>
							<script>
								date = new Date().toLocaleDateString();
								document.write(date);
							</script>
						</td>
					</tr>
					</c:if>
					<c:if test="${totals > 0 }">
					<c:forEach var="commentList" items="${bcVo}">
					<tr>
						<td>${commentList.sid }</td>
						<td>${commentList.bccontent }</td>
						<td>${commentList.bcdate }</td>
					</tr>
					</c:forEach>
					<tr>
						<td><input type="text" name="commentSid" value="sid" disabled></td>
						<td><textarea id="bccontent" name="bccontent" placeholder="*200자 이내로 작성해주세요"></textarea></td>
						<td>
							<script>
								date = new Date().toLocaleDateString();
								document.write(date);
							</script>
						</td>
					</tr>
					</c:if>
					<tr id="conetentPage">
						<td colspan="5"><div id="ampaginationsm"></div></td>
					</tr>
				</table>
					<button class="btn btn-outline-secondary" type="button" id="btnBoardComment">등록완료</button>
					<button class="btn btn-outline-secondary" type="reset">다시쓰기</button>
			</form>
			<%-- </c:otherwise> --%>
		</section>
	</div>
	<!-- content -->


	<!-- footer -->
	<footer>
		<jsp:include page="../footer.jsp" />
	</footer>
	<!-- footer -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK
	/7HAuoJl+0I4" crossorigin="anonymous"></script> <!-- 부트스트랩 -->
</body>
</html>