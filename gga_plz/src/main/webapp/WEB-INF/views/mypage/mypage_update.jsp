<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 - 내 정보 수정</title>
<link rel="stylesheet" href="http://localhost:9000/gga_test2/css/gga.css">
<script src="http://localhost:9000/gga_test2/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/gga_test2/js/gga_javascript.js"></script> <!-- gga_javascript.js -->
<script src="http://localhost:9000/gga_test2/js/gga_jquery.js"></script>
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
	<header>
		<jsp:include page="../header.jsp" />	
	</header>
	
	<!-- Content -->
	<div class= "container">
		<section class= "mp_update">
			<h1 class= "mypage_title">내 정보 수정</h1>
			<form name= "mp_updateForm" action="#" method= "get">
				<ul>
					<li>
						<label>아이디</label>
						<input type="text" name="id" class="input1" id="id" placeholder="저장값" disabled>
					</li>
					<li>
						<label>비밀번호</label>
						<input type="password" name="pass" class="input1" id="pass" placeholder="8자 이상 영문(대소문자 구분), 특수문자 포함">
					</li>
					<li>
						<label>비밀번호 확인</label>
						<input type="password" name="cpass" class="input1" id="cpass" placeholder="8자 이상 영문(대소문자 구분), 특수문자 포함">
						<span id="cmsg"></span>
					</li>
					<li>
						<label>이름</label>
						<input type="text" name="name" class="input1" id="name" placeholder="저장값" disabled>
					</li>
					<li>
						<label>생년월일</label>
						<input type="text" name="birth" class="input1" id="birth" numberOnly placeholder="저장값" disabled>
					</li>
					<li>
						<label>성별</label>
						<input type="radio" name="gender" value="m"><span>남자</span> 
						<input type="radio" name="gender" value="f"><span>여자</span>
					</li>
					<li>
						<label>휴대폰</label>
						<input type="radio" name="tel" value="skt"><span>SKT</span>
						<input type="radio" name="tel" value="kt"><span>KT</span>
						<input type="radio" name="tel" value="lgu+"><span>LG U+</span>
						<input type="text" name="phone" id="phone" numberOnly>				
					</li>
					<li>
						<label>이메일</label>
						<input type="text" name="email1" id="email1" > @
						<input type="text" name="email2" id="email2" >
						<select id="email3">
							<option value="default">직접입력</option>
							<option value="naver.com">네이버</option>
							<option value="nate.com">네이트</option>
							<option value="google.com">구글</option>
							<option value="daum.net">다음</option>
						</select>
					</li>
					<li>
						<label>차량번호</label>
						<input type="text" name="car1" id="car1" class="input1" placeholder= "예) 00가">
						<input type="text" name="car2" id="car2" class="input1" numberOnly placeholder= "예) 0000">
					</li>
					<li>
					<li>
						<label>영화 장르</label>
						11
						<input type="checkbox" name="genre" value="범죄/스릴러"><span>범죄/스릴러</span>
						<input type="checkbox" name="genre" value="멜로/로맨스"><span>멜로/로맨스</span>
						<input type="checkbox" name="genre" value="판타지/코미디"><span>판타지/코미디</span>
						<input type="checkbox" name="genre" value="액션/SF"><span>액션/SF</span><br>
						<input type="checkbox" name="genre" value="전쟁/재난"><span>전쟁/재난</span>
						<input type="checkbox" name="genre" value="느와르/첩보"><span>느와르/첩보</span>
						<input type="checkbox" name="genre" value="애니메이션"><span>애니메이션</span>
						<input type="checkbox" name="genre" value="가족/음악"><span>가족/음악</span>
						
					</li>
				</ul>
					<button type="submit" class= "btn_style">저장</button>
			</form>
		</section>
	</div>
	
	<!-- Footer -->
	<jsp:include page="../footer.jsp" />
	<!-- Footer -->
</body>
</html>