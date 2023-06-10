<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>	

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
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>	
	
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
			<p class="ticketcon_title">${orderconVo.movieordertitle}</p><br>
			<label>날짜 :</label>
			<p class="ticketcon_date">${orderconVo.odate}</p><br>
			<label>시간 :</label>
			<p class="ticketcon_time">${orderconVo.otime}</p><br>
			<label>가격 :</label>
			<p class="ticketcon_price">${orderconVo.price}</p><br>
			<label>좌석 :</label>
			<p class="ticket_orderseat">${orderconVo.seat}</p>
			<label>예매번호 :</label>
			<p class="ticket_ordernum">${orderconVo.oconid}</p><br>
			<input type="hidden" class="ticket_impuid" data-id="${orderconVo.impuid}">
		
		</div>
		
		<div class="ticketcon_bac2">
			<label>이름 :</label>
			<p class="ticketcon_name">${orderconVo.oname}</p><br>
			<label>차량번호 :</label>
			<p class="ticketcon_carnum">${orderconVo.ocarnum}</p><br>
			<label>Email :</label>
			<p class="ticketcon_email">${orderconVo.oemail}</p><br>
			<label>전화번호 :</label>
			<p class="ticket_number">${orderconVo.ophone}</p><br>
		
		</div>
	
		<button type="button" class="openallticket"><img src="http://localhost:9000/gga_plz/images/backbtn.png"></button>
		<button type="button" class="refundticket"><img src="http://localhost:9000/gga_plz/images/refundticketbtn.png"></button>

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