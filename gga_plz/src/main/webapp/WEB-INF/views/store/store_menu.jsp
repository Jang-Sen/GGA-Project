<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GGA-STORE</title>
<script src ="http://localhost:9000/gga_plz/js/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="http://localhost:9000/gga_plz/css/gga.css"> <!-- gga.css -->
<script src="http://localhost:9000/gga_plz/js/gga_jquery.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />	
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

		.buttons button:hover {
			  background-color: #e1bee7;
			}

		.card {
	        float:left;
	        margin:auto;
	        text-align:center;
	        width: 300px;
  			height: 300px;
	        display:inline-block;
	        }
	 

			card img {
			  height: 300px;
			  width: 100%;
			} 
			.orderbtn{
			/* margin-left:55px; */
			height:50px;
			width:160px;
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
		<div class="store_title">
		<img src="http://localhost:9000/gga_plz/images/storetitle.png">
		</div>
		<br>
		<div class="store_cart">
		<img src="http://localhost:9000/gga_plz/images/cartimg.png">
		</div>
		<nav class="menu1">
			<div class="row">
				<div class="col">
					<div class="card">
					  <img src="http://localhost:9000/gga_plz/images/comboset.png" class="mimg" id="MOVIE_0004">
					  <div class="card-body">
					    <h5 class="card-title">팝콘 콤보</h5>
					    <p class="card-text">가격 : 15,000<p>
					    <a class="cartbtn">
							<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
					  </div>
					</div>
				</div>
				<div class="col">
					<div class="card">
					  <img src="http://localhost:9000/gga_plz/images/popcorn.png" class="mimg" id="MOVIE_0001">
					  <div class="card-body">
					    <h5 class="card-title">팝콘 단품</h5>
					    <p class="card-text">가격 : 5,000</p>
					   <a class="cartbtn">
							<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
					  </div>
					</div>
				</div>
				<div class="col">
					<div class="card">
					  <img src="http://localhost:9000/gga_plz/images/coke.png" class="mimg" id="MOVIE_0002">
					  <div class="card-body">
					    <h5 class="card-title">콜라 단품</h5>
					    <p class="card-text">가격 : 3,000<p>
					    <a class="cartbtn">
							<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
					  </div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<div class="card">
					  <img src="http://localhost:9000/gga_plz/images/cottoncandy.png" class="mimg" id="MOVIE_0007">
					  <div class="card-body">
					    <h5 class="card-title">솜사탕</h5>
					    <p class="card-text">가격 : 5,000<p>
					   <a class="cartbtn">
							<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
					  </div>
					</div>
				</div>
				<div class="col">
					<div class="card">
					  <img src="http://localhost:9000/gga_plz/images/ggagiftcard.png" class="mimg" id="MOVIE_0003">
					  <div class="card-body">
					    <h5 class="card-title">GGA 기프트카드</h5>
					    <p class="card-text">가격 : 30,000<p>
					    <a class="cartbtn">
							<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
					  </div>
					</div>
				</div>
				<div class="col">
				<div class="card" >
				  <img src="http://localhost:9000/gga_plz/images/snack.png" class="mimg" id="MOVIE_0009">
				  <div class="card-body">
				    <h5 class="card-title">버터구이 오징어</h5>
				    <p class="card-text">가격 : 5,000<p>
				   			 <a class="cartbtn">
							<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
				  </div>
				</div>
				</div>
			</div>
		</nav>
			
			
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