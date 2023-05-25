<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gga_plz</title>
<link rel="stylesheet" href="http://localhost:9000/gga_plz/css/gga.css"> <!-- gga.css -->
<script src ="http://localhost:9000/gga_plz/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/gga_plz/js/gga_jquery.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- 부트스트랩 -->
</head>
<body>
	<!-- header -->
	<header>
		<jsp:include page="../../header.jsp" />	
	</header>
	<!-- header -->

	<!-- content -->
	<div class="container text-center">
		<div class="board_title">
		<img src="http://localhost:9000/gga_plz/images/adminnoticetitle.png">
		</div>
		<section class="admin_notice">
			<form name="deleteForm" action="admin_notice_delete_proc.do" method="post">
			<input type = "text" name="nid" value = "${nid}">
				<table border=1>
					<tr>					
						<td>정말로 삭제 하시겠습니까?</td>
					</tr>				
					<tr>
						<td colspan="3">
							<button type="button" id="btnNoticeDelete">삭제완료</button>
							<a href="admin_notice_content.do">
								<button type="button">이전페이지</button></a>
							<a href="admin_notice_list.do">
								<button type="button">리스트</button></a>							
						</td>				
					</tr>
				</table>
			</form>
		</section>
	</div>
	
	<!-- footer -->
	<footer>
		<jsp:include page="../../footer.jsp" />
	</footer>
	<!-- footer -->
	
	<!-- footer -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script> <!-- 부트스트랩 -->
</body>
</html>