<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gga_plz</title>
<script src="http://localhost:9000/gga_plz/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/gga_plz/js/gga_jquery.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<!-- <link rel="stylesheet" href="http://localhost:9000/gga_plz/css/gga.css">  --><!-- gga.css -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<!-- <script src="http://localhost:9000/gga_plz/js/gga_javascript.js"></script> --> <!-- gga_javascript.js -->
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">  -->
	<!-- 부트스트랩 -->
<style>
@import url('https://fonts.googleapis.com/css?family=Lato&display=swap');

* {
  box-sizing: border-box;
}

/* body {
  background-color: #242333;
  display: flex;
  flex-direction: column;
  color: white;
  align-items: center;
  justify-content: center;
  height: 100vh;
  font-family: 'Lato', 'sans-serif';
} */

/* .movie-container {
  margin: 20px 0;
}

.movie-container select {
  background-color: #fff;
  border: 0;
  border-radius: 5px;
  font-size: 14px;
  margin-left: 10px;
  padding: 5px 15px 5px 15px;
  -moz-appearance: none;
  -webkit-appearance: none;
  appearance: none;
} */
.container{
 /* display: flex; */
    justify-content: center;
    align-content: center;

}
.container2 {
display:inline-block;
	
	background-color: #242333;
  perspective: 1000px;
  margin-bottom: 30px;
  padding:30px;
}

.seat {
  background-color: #444451;
  height: 15px;
  width: 20px;
  margin: 3px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}

.seat.selected {
  background-color: #6feaf6;
}

.seat.occupied {
  background-color: #fff;
}

.seat:nth-of-type(2) {
  margin-right: 18px;
}

.seat:nth-last-of-type(2) {
  margin-left: 18px;
}

.seat:not(.occupied):hover {
  cursor: pointer;
  transform: scale(1.2);
}

.showcase .seat:not(.occupied):hover {
  cursor: default;
  transform: scale(1);
}

.showcase {
/* display:inline-block; */
	width:350px;
  background-color: rgba(0, 0, 0, 0.1);
  padding: 5px 10px;
  border-radius: 5px;
  color: #777;
  list-style-type: none;
display: flex; 
  justify-content: space-between;
}

.showcase li {
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 0 10px;
}

.showcase li small {
  margin-left: 10px;
}

.seatrow {
  display: flex;
}

.screen {
  background-color: #fff;
  height: 70px;
  width: 200px;
  /* margin: 15px 0; */
  transform: rotateX(-45deg);
  box-shadow: 0 3px 10px rgba(255, 255, 255, 0.75); 
}

p.text {
  margin: 5px 0;
}

p.text span {
  color: #6feaf6;
}

.seatbtn{
	margin-top:20px;
	width:100px;
	padding:5px;
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
</head>

  <body>
  <!-- header -->
	<header>
		<jsp:include page="../header.jsp" />
	</header>
	<!-- header -->
  <!-- content -->
	<div class="container">


    <ul class="showcase">
      <li>
        <div class="seat"></div>
        <small>이용 가능</small>
      </li>

      <li>
        <div class="seat selected"></div>
        <small>선택</small>
      </li>

      <li>
        <div class="seat occupied"></div>
        <small>이용 불가</small>
      </li>
    </ul>

    <div class="container2">
      <div class="screen"></div>
      <div class="seatrow">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>
      <div class="seatrow">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat occupied"></div>
        <div class="seat occupied"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>

      <div class="seatrow">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat occupied"></div>
        <div class="seat occupied"></div>
      </div>

      <div class="seatrow">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>

      <div class="seatrow">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat occupied"></div>
        <div class="seat occupied"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>

      <div class="seatrow">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat occupied"></div>
        <div class="seat occupied"></div>
        <div class="seat occupied"></div>
        <div class="seat"></div>
      </div>
    </div>
	<div class="textandbtn">
		    <p class="text">
		    선택한 좌석 : 
		    <span id="seatcom"></span> 번
		    </p>
		    <p class="text">
		      <!-- 선택한 좌석은 총 <span id="count">0</span> 좌석이며,  -->
		      가격 : <span id="seattotal">0</span> 원 
		      <input type="hidden" name="oidinput" id="oidinput" value="${oid}">
		    </p>
    
		    <button type="submit" class="seatbtn" id="seatcardbtn" name="seatcardbtn">카드로 결제하기</button>
		    <button type="submit" class="seatbtn" id="seatkakaobtn" name="seatkakaobtn">카카오로 결제하기</button>
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
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK
	/7HAuoJl+0I4" crossorigin="anonymous"></script> <!-- 부트스트랩 -->
    
   <!--  <script src="script.js"></script> -->
    <script>
    const container = document.querySelector('.container2');
    const seats = document.querySelectorAll('.seatrow .seat:not(.occupied');
    const count = document.getElementById('count');
    const total = document.getElementById('seattotal');
    const seatcomcom = document.getElementById('seatcom');

   /*  const movieSelect = document.getElementById('movie'); */

    populateUI();
   let ticketPrice = 30000;
    /* let ticketPrice = +movieSelect.value; */

    // Save selected movie index and price
    function setMovieData(movieIndex, moviePrice) {
      localStorage.setItem('selectedMovieIndex', movieIndex);
     localStorage.setItem('selectedMoviePrice', moviePrice); 
    }

    // update total and count
    function updateSelectedCount() {
    	const selectedSeats = document.querySelectorAll('.seatrow .seat.selected');

    	const seatsIndex = [...selectedSeats].map((seat) => [...seats].indexOf(seat)); 

      localStorage.setItem('selectedSeats', JSON.stringify(seatsIndex));

      //copy selected seats into arr
      // map through array
      //return new array of indexes

      const selectedSeatsCount = selectedSeats.length;

      /* count.innerText = selectedSeatsCount; */
      total.innerText = selectedSeatsCount * ticketPrice; 
      seatcomcom.innerText = seatsIndex;
      
    }

    // get data from localstorage and populate ui
    function populateUI() {
      const selectedSeats = JSON.parse(localStorage.getItem('selectedSeats'));
      if (selectedSeats !== null && selectedSeats.length > 0) {
        seats.forEach((seat, index) => {
          if (selectedSeats.indexOf(index) > -1) {
            seat.classList.add('selected');
          }
        });
      }

      const selectedMovieIndex = localStorage.getItem('selectedMovieIndex');

  /*     if (selectedMovieIndex !== null) {
        movieSelect.selectedIndex = selectedMovieIndex;
      } */
    }

    // Movie select event
/*     movieSelect.addEventListener('change', (e) => {
      ticketPrice = +e.target.value;
      setMovieData(e.target.selectedIndex, e.target.value);
      updateSelectedCount();
    }); */

    // Seat click event
    container.addEventListener('click', (e) => {
      if (e.target.classList.contains('seat') && !e.target.classList.contains('occupied')) {
        e.target.classList.toggle('selected');

        updateSelectedCount();
      }
    });

    // intial count and total
    updateSelectedCount();
    </script>
  </body>
</html>