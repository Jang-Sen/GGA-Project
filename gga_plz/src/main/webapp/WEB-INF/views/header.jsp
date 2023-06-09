<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gga_plz</title>
<link rel="stylesheet" href="http://localhost:9000/gga_plz/css/gga.css"> <!-- gga.css -->
<script src="http://localhost:9000/gga_plz/js/gga_searchContent.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- 부트스트랩 -->
</head>
<style>
#header_name{
	color: lightYellow;
}

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
		<div class="container">
			<div class="header_section1">
		      	
		      	<div class="header_logo">
		        	<a href="http://localhost:9000/gga_plz/index.do">
		        	<img src="http://localhost:9000/gga_plz/images/newlogo.png"></a>
		      	</div>
		      	
		      	<div class="header_menu">
		      	<c:choose>
		      	<c:when test="${ sessionScope.svo == null }">
			      	<ul>
				        <li>
				        	<a href="http://localhost:9000/gga_plz/login.do">로그인</a>
				        </li>
						<li>
							<a href="http://localhost:9000/gga_plz/join.do">회원가입</a>
						</li>
						<li>
							<a href="http://localhost:9000/gga_plz/mypage.do">마이페이지</a>
						</li>
					</ul>
		      	</c:when>
		      	<c:otherwise>
			      	<ul>
			      		<li id="header_name">
			      			${ sessionScope.svo.name } 님 환영합니다.
			      		</li>
						<li>
							<a href="http://localhost:9000/gga_plz/logout.do">로그아웃</a>
						</li>
						<li>
							<a href="http://localhost:9000/gga_plz/mypage.do">마이페이지</a>
						</li>
					<c:if test="${ sessionScope.svo.id == 'admin' }">
						<li>
							<a href="http://localhost:9000/gga_plz/admin_index.do">관리자</a>
						</li>
					</c:if>
			      	</ul>
		      	</c:otherwise>
		      	</c:choose>
		       </div>
		     </div>
			
			<div class="header_section2">
				<div class="header_menu2">
				<ul>
				      <li><a href="http://localhost:9000/gga_plz/movie_menu.do">
				     	영화</a></li>
				      <li><a class="headerorderbtn">예매</a></li>
			      	  <li class="dropdown">
			          <a class="dropdown-toggle-split" href="#" role="button" 
			         	 data-bs-toggle="dropdown" aria-expanded="false">
			         	 게시판</a>
				          <ul class="dropdown-menu">
				            <li><a class="dropdown-item" href="http://localhost:9000/gga_plz/notice_list.do"
				            	>공지사항</a></li>
				            <li><a class="dropdown-item" href="http://localhost:9000/gga_plz/board_list.do" 
				            	>커뮤니티</a></li>
				            <li><a class="dropdown-item" href="http://localhost:9000/gga_plz/faq.do"
				            	>FAQ</a></li>
				     </ul>
				     </li>
				      <li><a href="http://localhost:9000/gga_plz/coronation.do">
				      대관문의</a></li>
				      <li><a href="http://localhost:9000/gga_plz/store.do">
				      스토어</a></li>
				          </ul>
				 </div>
			</div>
				      <div class="mov_search">
				          <input type="text" placeholder="검색어를 입력해 주세요." id="searchContent">
				          <button type="submit" id="btnSearch"><p>검색</p></button>
				     </div>
			</div>
		</div>
	</header>
	<!-- header -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script> <!-- 부트스트랩 -->
</body>
</html>