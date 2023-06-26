<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
   <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>	
	
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
		<c:choose>
			<c:when test="${svo == null }">
				<div class="store_cart">
					    		<a href="http://localhost:9000/gga_plz/login.do">
									<img src="http://localhost:9000/gga_plz/images/cartimg.png">
								</a></div>
							</c:when>
			<c:otherwise>
				<div class="store_cart"><button type="button" id="store_cart" class="btn btn-success" data-toggle="modal" data-target="#cartModal">
				<img src="http://localhost:9000/gga_plz/images/cartimg.png"></button></div>
			</c:otherwise>
		</c:choose>
		<nav class="menu1">
			<div class="row">
				<div class="col">
					<div class="card">
					  <img src="http://localhost:9000/gga_plz/images/comboset.png">
					  <div class="card-body">
					    <h5 class="card-title">팝콘 콤보</h5>
					    <p class="card-text">가격 : 15,000<p>
					    <div class="storebtns">
					    <c:choose>
					    	<c:when test="${svo == null }">
					    		<a href="http://localhost:9000/gga_plz/login.do">
									<img class="cartbtnimg" style="width: 135px" src="http://localhost:9000/gga_plz/images/cartbtn.png">
								</a>
							</c:when>
							<c:otherwise>
						    <a class="cartbtn" data-id="P_0001" id="popcorncombobtn">
								<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${svo == null }">
					    		<a class="cartbtn2" href="http://localhost:9000/gga_plz/login.do">
									<img src="http://localhost:9000/gga_plz/images/buybtn.png">
								</a>
							</c:when>
							<c:otherwise>
							<a id="buybtn" class="cartbtn2" data-id="P_0001" data-price="15000" data-pname="팝콘 콤보"
								data-pfile="comboset.png">
	    						<img src="http://localhost:9000/gga_plz/images/buybtn.png"></a>
	    					</c:otherwise>
	    				</c:choose>
						    </div>
					  </div>
					</div>
				</div>
				
				
				<div class="col">
					<div class="card">
					  <img src="http://localhost:9000/gga_plz/images/popcorn.png">
					  <div class="card-body">
					    <h5 class="card-title">팝콘 단품</h5>
					    <p class="card-text">가격 : 5,000</p>
					    <div class="storebtns">
					    <c:choose>
					    	<c:when test="${svo == null }">
					    		<a href="http://localhost:9000/gga_plz/login.do">
									<img class="cartbtnimg" style="width: 135px" src="http://localhost:9000/gga_plz/images/cartbtn.png">
								</a>
							</c:when>
							<c:otherwise>
							   <a class="cartbtn" data-id="P_0002" id="popcorncombobtn">
									<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${svo == null }">
					    		<a class="cartbtn2" href="http://localhost:9000/gga_plz/login.do">
									<img src="http://localhost:9000/gga_plz/images/buybtn.png">
								</a>
							</c:when>
							<c:otherwise>
								<a id="buybtn" class="cartbtn2" data-id="P_0002" data-price="5000" data-pname="팝콘 단품"
								data-pfile="popcorn.png">
	    						<img src="http://localhost:9000/gga_plz/images/buybtn.png"></a>
    						</c:otherwise>
    					</c:choose>
					  </div>
					  </div>
					</div>
				</div>
				
				
				<div class="col">
					<div class="card">
					  <img src="http://localhost:9000/gga_plz/images/coke.png">
					  <div class="card-body">
					    <h5 class="card-title">콜라 단품</h5>
					    <p class="card-text">가격 : 3,000<p>
					    <div class="storebtns">
					    <c:choose>
					    	<c:when test="${svo == null }">
					    		<a href="http://localhost:9000/gga_plz/login.do">
									<img class="cartbtnimg" style="width: 135px" src="http://localhost:9000/gga_plz/images/cartbtn.png">
								</a>
							</c:when>
							<c:otherwise>
							    <a class="cartbtn" data-id="P_0003">
								<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${svo == null }">
					    		<a class="cartbtn2" href="http://localhost:9000/gga_plz/login.do">
									<img src="http://localhost:9000/gga_plz/images/buybtn.png">
								</a>
							</c:when>
							<c:otherwise>
								<a id="buybtn" class="cartbtn2" data-id="P_0003" data-price="3000" data-pname="콜라 단품"
								data-pfile="coke.png">
	    						<img src="http://localhost:9000/gga_plz/images/buybtn.png"></a>
    						</c:otherwise>
    					</c:choose>
					  </div>
					  </div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<div class="card">
					  <img src="http://localhost:9000/gga_plz/images/cottoncandy.png">
					  <div class="card-body">
					    <h5 class="card-title">솜사탕</h5>
					    <p class="card-text">가격 : 5,000<p>
					    <div class="storebtns">
					     <c:choose>
					    	<c:when test="${svo == null }">
					    		<a href="http://localhost:9000/gga_plz/login.do">
									<img class="cartbtnimg" style="width: 135px" src="http://localhost:9000/gga_plz/images/cartbtn.png">
								</a>
							</c:when>
							<c:otherwise>
							    <a class="cartbtn" data-id="P_0004">
								<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${svo == null }">
					    		<a class="cartbtn2" href="http://localhost:9000/gga_plz/login.do">
									<img src="http://localhost:9000/gga_plz/images/buybtn.png">
								</a>
							</c:when>
							<c:otherwise>
								<a id="buybtn" class="cartbtn2" data-id="P_0004" data-price="5000" data-pname="솜사탕"
							data-pfile="cottoncandy.png">
    						<img src="http://localhost:9000/gga_plz/images/buybtn.png"></a>
    						</c:otherwise>
    					</c:choose>
					  </div>
					  </div>
					</div>
				</div>
				
				
				<div class="col">
					<div class="card">
					  <img src="http://localhost:9000/gga_plz/images/ggagiftcard.png">
					  <div class="card-body">
					    <h5 class="card-title">GGA 기프트카드</h5>
					    <p class="card-text">가격 : 30,000<p>
					    <div class="storebtns">
					     <c:choose>
					    	<c:when test="${svo == null }">
					    		<a href="http://localhost:9000/gga_plz/login.do">
									<img class="cartbtnimg" style="width: 135px" src="http://localhost:9000/gga_plz/images/cartbtn.png">
								</a>
							</c:when>
							<c:otherwise>
							    <a class="cartbtn" data-id="P_0005">
							<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${svo == null }">
					    		<a class="cartbtn2" href="http://localhost:9000/gga_plz/login.do">
									<img src="http://localhost:9000/gga_plz/images/buybtn.png">
								</a>
							</c:when>
							<c:otherwise>
								<a id="buybtn" class="cartbtn2" data-id="P_0005" data-price="30000" data-pname="GGA 기프트카드"
								data-pfile="ggagiftcard.png">
	    						<img src="http://localhost:9000/gga_plz/images/buybtn.png"></a>
    						</c:otherwise>
    					</c:choose>
					  </div>
					  </div>
					</div>
				</div>
				<div class="col">
				<div class="card" >
				  <img src="http://localhost:9000/gga_plz/images/snack.png">
				  <div class="card-body">
				    <h5 class="card-title">버터구이 오징어</h5>
				    <p class="card-text">가격 : 5,000<p>
				    <div class="storebtns">
				    <c:choose>
					    	<c:when test="${svo == null }">
					    		<a href="http://localhost:9000/gga_plz/login.do">
									<img class="cartbtnimg" style="width: 135px" src="http://localhost:9000/gga_plz/images/cartbtn.png">
								</a>
							</c:when>
							<c:otherwise>
							    <a class="cartbtn" data-id="P_0006">
							<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${svo == null }">
					    		<a class="cartbtn2" href="http://localhost:9000/gga_plz/login.do">
									<img src="http://localhost:9000/gga_plz/images/buybtn.png">
								</a>
							</c:when>
							<c:otherwise>
									<a id="buybtn" class="cartbtn2" data-id="P_0006" data-price="5000" data-pname="GGA 기프트카드"
								data-pfile="snack.png">
    							<img src="http://localhost:9000/gga_plz/images/buybtn.png"></a>
    						</c:otherwise>
    					</c:choose>
				  </div>
				  </div>
				</div>
				</div>
			</div>
		</nav>
			</div>
			
	
<!-- Moa Modal-->
  <div class="modal fade" id="CartModal" tabindex="-1" role="dialog" aria-labelledby="historyModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl" role="document">
    <div class="modal-content">
    </div>
  </div>
</div>

<div id="buycartModal" class="modal" >
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">결제하기</h4>
          <button type="button" class="cartclosebtn2" id="cartclosebtn3">X</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
            <p>결제할 수단을 선택해 주세요.</p>
        </div>
        
        <!-- Modal footer -->
        <div class="buycartmodal_footer">
          <button type="button" id="cartkakaopay" class="cartkakaobtn"><img src="http://localhost:9000/gga_plz/images/kakaopay.png"></button>
          <button type="button" id="cartcardpay" class="cartcardbtn"><img src="http://localhost:9000/gga_plz/images/cardpay.png"></button>
        </div>
   </div>
    </div>
</div>

<div id="buyModal" class="modal" >
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">장바구니 추가</h4>
          <button type="button" class="cartclosebtn2" id="cartclosebtn2">X</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
            <p>장바구니에 추가되었습니다. 장바구니를 볼까요?</p>
        </div>
        
        <!-- Modal footer -->
        <div class="footer" id="keepshoppinggocart">
          <button type="button" class="shoppingbtn" id="shoppingbtn"><img src="http://localhost:9000/gga_plz/images/keepshoppingbtn.png"></button>
          <button type="button" class="gocartbtn" id="gocartbtn"><img src="http://localhost:9000/gga_plz/images/gocartbtn.png"></button>
        </div>
        
      </div>
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