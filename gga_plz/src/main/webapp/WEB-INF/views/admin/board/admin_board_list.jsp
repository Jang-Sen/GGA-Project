<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gga_plz</title>
<link rel="stylesheet" href="http://localhost:9000/gga_plz/css/gga.css"> <!-- gga.css -->
<link rel="stylesheet" href="http://localhost:9000/gga_plz/css/am-pagination.css"> <!-- am-pagination.css -->
<script src="http://localhost:9000/gga_plz/js/jquery-3.6.4.min.js"></script> <!-- gga_javascript.js -->
<script src="http://localhost:9000/gga_plz/js/gga_jquery.js"></script> <!-- gga_jquery.js -->
<script src="http://localhost:9000/mycgv_jsp/js/am-pagination.js"></script> <!-- am-pagination.js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
	<!-- 부트스트랩 -->
</head>
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
		margin:auto;
} 

table tr:first-child {
	border-top:1px solid white;
	border-right:1px solid white;
	border-left:1px solid white;
	text-align:right;
}

table tr:last-child {
	border:1px solid white;
}

table tr:last-child nav ul {
	margin-top:30px;
	justify-content:center;
}

table tr{
	text-align:center;
}

table td:nth-child(2){
	text-align:left;
}

img {
	width:95px;
	height:40px;
}
</style>

<script>
	$(document).ready(function(){
		var pager = jQuery('#ampaginationsm').pagination({
		
		    maxSize: "${pageCount}",	    		// max page size
		    totals: "${dbCount}",	// total pages	
		    page: "${page}",		// initial page		
		    pageSize: "${pageSize}",			// max number items per page
		
		    // custom labels		
		    lastText: '&raquo;&raquo;', 		
		    firstText: '&laquo;&laquo;',		
		    prevText: '&laquo;',		
		    nextText: '&raquo;',
				     
		    btnSize:'sm'	// 'sm'  or 'lg'		
		});
		
		jQuery('#ampaginationsm').on('am.pagination.change',function(e){
			   jQuery('.showlabelsm').text('The selected page no: '+e.page);
	           $(location).attr('href', "http://localhost:9000/gga_plz/admin_board_list.do?page="+e.page);         
	    });
		
 	});
</script> 

<body>
	<!-- header -->
	<header>
		<jsp:include page="../../header.jsp" />
	</header>
	<!-- header -->
	
	<!-- content -->
	<div class="container text-center">
	<div class="board_title">
		<img src="http://localhost:9000/gga_plz/images/adminreviewtitle.png">
		</div>
		<section class="board">
			<table class="table table-bordered" style="width: 90%;">
				<tr>
					<td colspan="5">
					</td>
				</tr>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>조회수</th>
					<th>작성자</th>
					<th>작성일자</th>
				</tr>
				<c:forEach var="boardVo" items="${list}">
				<tr>
					<td>${boardVo.rno }</td>
					<td><a href="board_content.do?bid=${boardVo.bid}">${boardVo.btitle }</a></td>
					<td>${boardVo.views }</td>
					<td>${boardVo.mid }</td>
					<td>${boardVo.bdate }</td>
				</tr>
				</c:forEach>
				
				<tr>
					<td colspan="5">
						<div id="ampaginationsm"></div>
					</td>
				</tr>
			</table>
		</section>
	</div>
	<!-- content -->


	<!-- footer -->
	<footer>
		<jsp:include page="../../footer.jsp" />
	</footer>
	<!-- footer -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK
	/7HAuoJl+0I4" crossorigin="anonymous"></script> <!-- 부트스트랩 -->
</body>
</html>