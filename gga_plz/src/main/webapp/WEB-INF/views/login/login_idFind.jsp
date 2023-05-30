<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gga_plz</title>

<script src ="http://localhost:9000/gga_plz/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/gga_plz/js/gga_jquery.js"></script> <!-- gga_jquery.js -->
<script src="http://localhost:9000/gga_plz/js/jangwon.js"></script> <!-- gga_jquery.js -->
<link rel="stylesheet" href="http://localhost:9000/gga_plz/css/gga.css"> <!-- gga.css -->
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
.findbts{
	width:100px;
	height:100px;
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
		<div class="login_title">
			<h1>아이디 찾기</h1>
		</div>
		<p>회원 정보에 등록된 이름과 휴대전화를 입력해주세요.</p>
		<section class="login">
			<form name="findIdForm" action="#" method="post" class="loginForm">
				<ul>
					<li>
						<label>이름</label>
						<input type="text" name="name" id="name" class="imput1">
					</li>
					<li>
						<label>생년월일</label>
						<input type="text" name="birth" id="birth" maxlength="6" class="input1" numberOnly placeholder="주민등록번호 앞 6자리">
					</li>
					<li>
						<label>휴대전화</label>
						<input type="text" name="phone" id="phone" numberOnly placeholder="'-'없이 모두 입력">
					</li>
				</ul>
					<div class="findbtn">
						<button type="submit" id="btnFindId" class="btnfindproc">찾기</button>
					</div>
			</form>
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