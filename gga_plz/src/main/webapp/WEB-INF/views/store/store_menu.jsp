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
		<div class="store_cart"><button type="button" id="store_cart" class="btn btn-success" data-toggle="modal" data-target="#cartModal">
		<img src="http://localhost:9000/gga_plz/images/cartimg.png">
		</button>
		</div>
		<nav class="menu1">
			<div class="row">
				<div class="col">
					<div class="card">
					  <img src="http://localhost:9000/gga_plz/images/comboset.png" class="mimg" id="MOVIE_0004">
					  <div class="card-body">
					    <h5 class="card-title">팝콘 콤보</h5>
					    <p class="card-text">가격 : 15,000<p>
					    <div class="storebtns">
					    <a class="cartbtn" id="cartaddbtn">
							<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
							<a id="buybtn" class="cartbtn">
    						<img src="http://localhost:9000/gga_plz/images/buybtn.png"></a>
					    </div>
					  </div>
					</div>
				</div>
				<div class="col">
					<div class="card">
					  <img src="http://localhost:9000/gga_plz/images/popcorn.png" class="mimg" id="MOVIE_0001">
					  <div class="card-body">
					    <h5 class="card-title">팝콘 단품</h5>
					    <p class="card-text">가격 : 5,000</p>
					    <div class="storebtns">
					   <a class="cartbtn" id="cartaddbtn">
							<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
							<a id="buybtn" class="cartbtn">
    						<img src="http://localhost:9000/gga_plz/images/buybtn.png"></a>
					  </div>
					  </div>
					</div>
				</div>
				<div class="col">
					<div class="card">
					  <img src="http://localhost:9000/gga_plz/images/coke.png" class="mimg" id="MOVIE_0002">
					  <div class="card-body">
					    <h5 class="card-title">콜라 단품</h5>
					    <p class="card-text">가격 : 3,000<p>
					    <div class="storebtns">
					    <a class="cartbtn" id="cartaddbtn">
							<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
							<a id="buybtn" class="cartbtn">
    						<img src="http://localhost:9000/gga_plz/images/buybtn.png"></a>
					  </div>
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
					    <div class="storebtns">
					   <a class="cartbtn" id="cartaddbtn">
							<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
							<a id="buybtn" class="cartbtn">
    						<img src="http://localhost:9000/gga_plz/images/buybtn.png"></a>
					  </div>
					  </div>
					</div>
				</div>
				<div class="col">
					<div class="card">
					  <img src="http://localhost:9000/gga_plz/images/ggagiftcard.png" class="mimg" id="MOVIE_0003">
					  <div class="card-body">
					    <h5 class="card-title">GGA 기프트카드</h5>
					    <p class="card-text">가격 : 30,000<p>
					    <div class="storebtns">
					    <a class="cartbtn" id="cartaddbtn">
							<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
							<a id="buybtn" class="cartbtn">
    						<img src="http://localhost:9000/gga_plz/images/buybtn.png"></a>
					  </div>
					  </div>
					</div>
				</div>
				<div class="col">
				<div class="card" >
				  <img src="http://localhost:9000/gga_plz/images/snack.png" class="mimg" id="MOVIE_0009">
				  <div class="card-body">
				    <h5 class="card-title">버터구이 오징어</h5>
				    <p class="card-text">가격 : 5,000<p>
				    <div class="storebtns">
				   			 <a class="cartbtn" id="cartaddbtn">
							<img class="cartbtnimg" src="http://localhost:9000/gga_plz/images/cartbtn.png"></a>
							<a id="buybtn" class="cartbtn">
    						<img src="http://localhost:9000/gga_plz/images/buybtn.png"></a>
				  </div>
				  </div>
				</div>
				</div>
			</div>
		</nav>
			</div>
			
			<div class="modal fade" id="cartModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header border-bottom-0">
        <h5 class="modal-title" id="exampleModalLabel">
          장바구니
        </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" id="cartclosebtn">
          <span aria-hidden="true">  X  </span>
        </button>
      </div>
      <div class="modal-body">
        <table class="table table-image">
          <thead>
            <tr>
              <th scope="col"></th>
              <th scope="col">상품명</th>
              <th scope="col">가격</th>
              <th scope="col">수량</th>
              <th scope="col">합계</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="w-25">
                <img src="http://localhost:9000/gga_plz/images/popcorn.png" class="img-fluid img-thumbnail" alt="Sheep">
              </td>
              <td>팝콘 단품</td>
              <td>5,000</td>
              <td class="qty"><input type="text" class="form-control" id="qtyinput" value="1"></td>
              <td>5,000</td>
              <td>
                <button type="button" class="cartitemdelete">삭제</button>
              </td>
            </tr>
          </tbody>
        </table> 
        <div class="carttotalprice justify-content-end">
          <h5>합계: <span class="price text-success">5,000</span></h5>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" id="cartkakaopay" class="btn btn-success" data-dismiss="modal">
    <img src="http://localhost:9000/gga_plz/images/kakaopay.png"></button>
        <button type="button" id="cartcardpay" class="btn btn-success" data-dismiss="modal">
    <img src="http://localhost:9000/gga_plz/images/cardpay.png"></button>
      </div>
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
        <div class="footer">
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