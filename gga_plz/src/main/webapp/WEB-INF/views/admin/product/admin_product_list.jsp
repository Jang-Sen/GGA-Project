<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gga_plz</title>
<link rel="stylesheet" href="http://localhost:9000/gga_plz/css/am-pagination.css">
<script src="http://localhost:9000/gga_plz/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/gga_plz/js/gga_jquery.js"></script>
<script src="http://localhost:9000/gga_plz/js/am-pagination.js"></script>
<link rel="stylesheet" href="http://localhost:9000/gga_plz/css/gga.css"> <!-- gga.css -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
	
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

.product_title img{
	width:500px;
	height:100px;
	float:left;
	
}

.product table{
	text-align: center;
	vertical-align: middle;
}

.product button{
	background-color:white;
	border:1px solid white;
	
}
.product table tr td a{
	text-decoration:none;
	color:gray;
}
.product .addproductbtn {
	float:right;
	
}
.product table td img{
	width:150px;
	
}
</style>


<body>
	<!-- header -->
	<header>
		<jsp:include page="../../header.jsp" />
	</header>
	<!-- header -->
	
	<!-- content -->
	<div class="container">
	<div class="product_title">
		<img src="http://localhost:9000/gga_plz/images/adminstoretitle.png">
		</div>
		<section class="product">
			<table class="table" style="width: 90%;">
				<tr>
					<td colspan="7">
						<a class="addproductbtn" href="http://localhost:9000/gga_plz/admin_product_register.do">
						<button type="button"><img src="http://localhost:9000/gga_plz/images/addstorebtn.png"></button></a>
						<br><br>
					</td>
				</tr>
				<tr>
					<th>번호</th>
					<th>상품ID</th>
					<th>상품 명</th>
					<th>가격</th>
					<th>이미지</th>
				</tr>
				<c:forEach var="productVo" items="${list}">
				<tr>
					<td>${productVo.rno}</td>
					<td>${productVo.pid}</td>
					<td><a href="admin_product_content.do?pid=${productVo.pid}">${productVo.pname}</a></td>
					<td>${productVo.pprice}</td>
					<td><c:if test="${productVo.psfile != null}"><img src="http://localhost:9000/gga_plz/images/${productVo.pfile}"></c:if></td>
				</tr>
				</c:forEach>
			</table>
		</section>
	</div>
	<!-- content -->


	<!-- footer -->
	<footer>
		<jsp:include page="../../footer.jsp" />
	</footer>
	<!-- footer -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK
	/7HAuoJl+0I4" crossorigin="anonymous"></script> 부트스트랩 -->
</body>
</html>