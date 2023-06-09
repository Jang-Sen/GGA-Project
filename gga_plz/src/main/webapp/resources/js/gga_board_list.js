$(document).ready(function(){

	/**********************************
		보드 리스트 ajax	 - 첫 화면
	**********************************/
	initAjax(1);
		function initAjax(page) {
			$.ajax({
				url:"board_list_json_data.do?page="+page,
				success : function(result) {
				let jdata = JSON.parse(result);
		          	let output = "<table class='table table-bordered' id='board_table'style='width: 90%;'>";
		          	output += "<tr>";
		          	output += "<th>번호</th>";
		          	output += "<th>제목</th>";
		         	output += "<th>조회수</th>";
		        	output += "<th>작성자</th>";
		         	output += "<th>작성일자</th>";
		          	output += "</tr>";
		          	for(obj of jdata.jlist) {
			          	output += "<tr>";
			          	output += "<td>"+obj.rno+"</td>";
			          	if(obj.movieName == "suzume"){
			  	        	output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0002'>[스즈매의 문단속]&nbsp</a>";
			          	}else if (obj.movieName == "darknight"){
			  	        	output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0001'>[다크나이트]&nbsp</a>";
			          	}else if (obj.movieName == "dune"){
			  	        	output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0003'>[듄]&nbsp</a>";
			          	}else if (obj.movieName == "slamdunk"){
			  	        	output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0009'>[슬램덩크]&nbsp</a>";
			          	}else if (obj.movieName == "inception"){
			  	        	output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0004'>[인셉션]&nbsp</a>";
			          	}else if (obj.movieName == "rings"){
			  	        	output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0007'>[반지의제왕]&nbsp</a>";
			          	}
			          	if(obj.commentCount > 0){
			          		output += "<div class='maxSize'><a href="+"'"+"board_content.do?bid="+obj.bid+"'>"+obj.btitle+"</a>&nbsp("+obj.commentCount+")</td></div>";
			          	}else{
			          		output += "<div class='maxSize'><a href="+"'"+"board_content.do?bid="+obj.bid+"'>"+obj.btitle+"</a></td></div>";
			          	}
			          	output += "<td>"+obj.bhits+"</td>";
			          	output += "<td>"+obj.mid+"</td>";
			          	output += "<td>"+obj.bdate+"</td>";
			          	output += "</tr>";
			          	}
		          	output += "<tr>";
		         	output += "<td colspan='5'><div id='ampaginationsm'></div></td>";
		          	output += "</tr></table>";
				
					$("#board_table").remove();
					$("div.board_choose").after(output);
					
					pager(jdata.totals, jdata.maxSize, jdata.pageSize, jdata.page);
			
					jQuery('#ampaginationsm').on('am.pagination.change',function(e){
							jQuery('.showlabelsm').text('The selected page no: '+e.page);
					    	initAjax(e.page);
			         	});
		        } //success
			});// ajax
		}//init
	
	
	
	/**********************************
		보드검색 ajax
	**********************************/
	
	
	$("#btnBoardSearch").click(function(){
		if($("#btitle").val() =="" ){
			alert("게시물 명을 입력해주세요.");
			//$(location).attr('href', "http://localhost:9000/gga_plz/board_list.do?page=1");       
			$("#btitle").focus();
			return false;
		} else{
		$("#board_table_init").remove();
		initAjax(1);
			function initAjax(page){
			
				$.ajax({
			          url:"http://localhost:9000/gga_plz/board_search_json_data.do?btitle="+$("#btitle").val()+"&page="+page,
			          success: function(result){
			          let jdata = JSON.parse(result);
			          	let output = "<table class='table table-bordered' id='board_table'style='width: 90%;'>";
			          	output += "<tr>";
			          	output += "<th>번호</th>";
			          	output += "<th>제목</th>";
			          	output += "<th>조회수</th>";
			          	output += "<th>작성자</th>";
			          	output += "<th>작성일자</th>";
			          	output += "</tr>";
			          	for(obj of jdata.jlist) {
			          	output += "<tr>";
			          	output += "<td>"+obj.rno+"</td>";
			          	if(obj.movieName == "suzume"){
			  	        	output += "<td><a href="+"'"+"board_content.do?bid="+obj.bid+"'>[스즈매의 문단속]</a>";
			          	}else if (obj.movieName == "darknight"){
			  	        	output += "<td><a href="+"'"+"board_content.do?bid="+obj.bid+"'>[다크나이트]</a>";
			          	}else if (obj.movieName == "dune"){
			  	        	output += "<td><a href="+"'"+"board_content.do?bid="+obj.bid+"'>[듄]</a>";
			          	}else if (obj.movieName == "slamdunk"){
			  	        	output += "<td><a href="+"'"+"board_content.do?bid="+obj.bid+"'>[슬램덩크]</a>";
			          	}else if (obj.movieName == "inception"){
			  	        	output += "<td><a href="+"'"+"board_content.do?bid="+obj.bid+"'>[인셉션]</a>";
			          	}else if (obj.movieName == "rings"){
			  	        	output += "<td><a href="+"'"+"board_content.do?bid="+obj.bid+"'>[반지의제왕]</a>";
			          	}
			          	if(obj.commentCount > 0){
			          		output += "<div class='maxSize'><a href="+"'"+"board_content.do?bid="+obj.bid+"'>"+obj.btitle+"</a>&nbsp("+obj.commentCount+")</td></div>";
			          	}else{
			          		output += "<div class='maxSize'><a href="+"'"+"board_content.do?bid="+obj.bid+"'>"+obj.btitle+"</a></td></div>";
			          	}
			          	output += "<td>"+obj.bhits+"</td>";
			          	output += "<td>"+obj.mid+"</td>";
			          	output += "<td>"+obj.bdate+"</td>";
			          	output += "</tr>";
			          	}
			          	output += "<tr>";
			          	output += "<td colspan='5'><div id='ampaginationsm'></div></td>";
			          	output += "</tr></table>";
			          		
						$("#board_table").remove();
			          	$("div.board_choose").after(output);
			          	
			          	pager(jdata.totals, jdata.maxSize, jdata.pageSize, jdata.page);
				
						jQuery('#ampaginationsm').on('am.pagination.change',function(e){
							jQuery('.showlabelsm').text('The selected page no: '+e.page);
					    	initAjax(e.page);
			         	});
			          	}
				}); //ajax
			} //init
		} // if
	}); //click
	function pager(totals, maxSize, pageSize, page) {
		var pager = jQuery('#ampaginationsm').pagination({
		
		    maxSize: maxSize,	    		// max page size
		    totals: totals,	// total pages	
		    page: page,		// initial page 현제 페이지 reqpage
		    pageSize: pageSize,			// max number items per page
		
		    // custom labels		
		    lastText: '&raquo;&raquo;', 		
		    firstText: '&laquo;&laquo;',		
		    prevText: '&laquo;',		
		    nextText: '&raquo;',
				     
		    btnSize:'sm'	// 'sm'  or 'lg'		
		});
	}



});