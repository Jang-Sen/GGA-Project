<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gga_plz</title>
<link rel="stylesheet" href="http://localhost:9000/gga_plz/css/gga.css"> <!-- gga.css -->
<script src="http://localhost:9000/gga_plz/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/gga_plz/js/gga_jquery.js"></script>
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
section.moviemanager th {
	width:20%
}

section.moviemanager table {
		margin:auto;
		vertical-align:middle
} 
section.moviemanager table input {
		width:70%;
} 
section.moviemanager table button {
	border:1px solid black;
}
</style>

<body>
	<!-- header -->
	<header>
		<jsp:include page="../../header.jsp" />
	</header>
	<!-- header -->
	
	<!-- content -->
	<div class="container text-center">
	<div class="board_title">
		<h1>영화 등록</h1>
		</div>
		<section class="moviemanager">
			<form name="movieDelete" action="movie_delete_proc.do?movieid=${movieVo.movieid}" method="post">
			<table class="table table-bordered" style="width: 90%;">
				<tr>
					<th>영화제목</th>
					<td>${movieVo.movietitle}</td>
					
				</tr>
				<tr>
					<th>장르</th>
					<td>${movieVo.genre}</td>
				</tr>
				<tr>
					<th>상영날짜</th>
					<td>${movieVo.moviedday}</td>
				</tr>
				<tr>
					<th>상영시간</th>
					<td>${movieVo.runtime}</td>
				</tr>
				<tr>
					<th>줄거리</th>
					<td>${movieVo.movieinfo}</td>
				</tr>
				<tr>
					<th>감독</th>
					<td>${movieVo.director}</td>
				</tr>
				<tr>
					<th>배우</th>
					<td>${movieVo.actor}</td>
				</tr>
				<tr>
					<th>메인포스터</th>
					<td>${movieVo.mainposter}</td>
				</tr>
				<tr>
					<th>스틸컷1</th>
					<td>${movieVo.stillcut1}</td>
				</tr>
				<tr>
					<th>스틸컷2</th>
					<td>${movieVo.stillcut2}</td>
				</tr>
				<tr>
					<th>스틸컷3</th>
					<td>${movieVo.stillcut3}</td>
				</tr>
				<tr>
					<th>스틸컷4</th>
					<td>${movieVo.stillcut4}</td>
				</tr>
				<tr>
					<th>예고편</th>
					<td>${movieVo.youtube}</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="movie_update.do?movieid=${movieVo.movieid}">
							<button type="button" class="btn btn-outline-secondary">수정하기</button></a>
						<button type="button" id="btnMovieDelete" class="btn btn-outline-secondary">삭제하기</button>
						<a href="http://localhost:9000/gga_plz/movie_list.do">
						<button type="button" class="btn btn-outline-secondary">이전으로</button></a>
					</td>
				</tr>
			</table>
			</form>
		</section>
	</div>
	<!-- content -->


	<!-- footer -->
	<footer>
		<jsp:include page="../../footer.jsp" />
	</footer>
	<!-- footer -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK
	/7HAuoJl+0I4" crossorigin="anonymous"></script> <!-- 부트스트랩 -->
</body>
</html>