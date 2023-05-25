<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		
<%@ page import = "com.gga.vo.OrderVo" %>
<%@ page import = "com.gga.dao.OrderDao" %>

<%
	String oid = request.getParameter("oid");
	OrderDao orderDao = new OrderDao();
	OrderVo orderVo = orderDao.select(oid);	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gga_plz</title>

<script src ="http://localhost:9000/gga_plz/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/gga_plz/js/gga_jquery.js"></script>
<link rel="stylesheet" href="http://localhost:9000/gga_plz/css/gga.css"> <!-- gga.css -->
 <script src="http://localhost:9000/gga_plz/js/gga_javascript.js"></script> 
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
</style>

<body>
	<!-- header -->
	<header>
		<jsp:include page="../header.jsp" />
	</header>
	<!-- header -->
	
	
	<!-- content -->
	<div class="container">
		<div class="ordercon_title">
		<img src="http://localhost:9000/gga_plz/images/ordercontitle.png">
			<!-- <img src="http://localhost:9000/gga_plz/images/ticket2.png"> -->
		</div>
		
		<div class="ticketcon_bac1">
			<label>제목 :</label>
			<p class="ticketcon_title"><%= orderVo.getMovieid() %></p><br>
			<label>날짜 :</label>
			<p class="ticketcon_date"><%= orderVo.getOdate() %></p><br>
			<label>시간 :</label>
			<p class="ticketcon_time"><%= orderVo.getOtime() %></p><br>
			<label>가격 :</label>
			<p class="ticketcon_price"><%= orderVo.getPrice() %></p><br>
			<label>좌석 :</label>
			<p class="ticket_orderseat"><%= orderVo.getSeat() %></p>
			<label>예매번호 :</label>
			<p class="ticket_ordernum"><%= oid %></p><br>
		
		</div>
		
		<div class="ticketcon_bac2">
			<label>이름 :</label>
			<p class="ticketcon_name"><%= orderVo.getOname() %></p><br>
			<label>차량번호 :</label>
			<p class="ticketcon_carnum"><%= orderVo.getOcarnum() %></p><br>
			<label>Email :</label>
			<p class="ticketcon_email"><%= orderVo.getOemail() %></p><br>
			<label>전화번호 :</label>
			<p class="ticket_number"><%= orderVo.getOphone() %></p><br>
		
		</div>
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