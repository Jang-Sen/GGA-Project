<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gga_plz</title>
<script src ="http://localhost:9000/gga_plz/js/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="http://localhost:9000/gga_plz/css/gga.css"> <!-- gga.css -->
<script src="http://localhost:9000/gga_plz/js/gga_jquery.js"></script> <!-- gga_jquery.js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
	

</head>

<script>
	let loginFail = "${loginFail}";
	if (loginFail == 'nope'){
		alert("존재하지 않는 아이디 혹은 비밀번호 입니다.");
	}
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
		<img src="http://localhost:9000/gga_plz/images/logintitle.png">
		</div>
		<section class="login">
			<img src="http://localhost:9000/gga_plz/images/newlogo.png">
			<a href= "http://localhost:9000/gga_plz/login.do">
			<img src="http://localhost:9000/gga_plz/images/loginbtn.png"></a>
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