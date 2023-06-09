$(document).ready(function(){

	$.ajax({
			url:"http://localhost:9000/gga_plz/indexSearch_json_data.do?searchContent="+$("#firstSearch").val(),
			success: function(result){
		     	let jdata = JSON.parse(result);
				        
			    var output = "";
				var mcount = 0;	var ncount = 0;	var bcount = 0;	var pcount = 0;
				let mindex = jdata.mlist.length-1;	let nindex = jdata.nlist.length;	let bindex = jdata.blist.length;
				let pindex = jdata.plist.length-1;
				var mlast = 0;	var nlast = 0;	var blast = 0;	var plast = 0;
				if(mindex != -1) mlast = jdata.mlist[mindex].mrno;
				if(pindex != -1) plast = jdata.plist[pindex].prno;
				        
				if(jdata.mlist[0] == null && jdata.nlist[0] == null){
					if(jdata.blist[0] == null && jdata.plist[0] == null) {
						output += "<div class='noneResult'>";
						output += "<img src='http://localhost:9000/gga_plz/images/indexSearchNoneResult.png'>";
						output += "<span class='result1'>"+"'"+$("#firstSearch").val()+"'"+"검색결과가 없습니다.</span><br>";
						output += "<span class='result2'>검색내용을 확인 후 다시 검색해주세요!!</span></div>";
						output += "<div class='noneResultGuide'>";
						output += "<span class='resultGuide'>Ex) 영화 제목, 선호 장르, 공지사항 제목, 리뷰 제목, 상품명</span></div>";
					 }
				}
				if(jdata.mlist[0] != null){
				    output += "<div class='movieSearch'>";
					output += "<div class='movieSearchTitle'>";
					output += "<a href='http://localhost:9000/gga_plz/movie_menu.do'><img src='http://localhost:9000/gga_plz/images/movietitle.png'></a></div>";
					output += "<div class='movieSearchResult'>";
				    for(obj of jdata.mlist){
				       	if(mcount < 3) {
						    output += "<div class='movieSearchInfo'>";
						    output += "<a href='http://localhost:9000/gga_plz/movieinfo.do?movieid="+obj.movieId+"'><img src='http://localhost:9000/gga_plz/images/"+obj.mainPoster+"'"+" class='movieSearchInfoImg' id='"+obj.movieId+"'"+"></a>";
						    if(obj.movieTitle == '귀멸의 칼날: 상현집결, 그리고 도공 마을로'){
						       	output += "<a id='movieTitle' href='http://localhost:9000/gga_plz/movieinfo.do?movieid=MOVIE_0006'>귀멸의칼날 : 상현집결</a>";
							}else{
						       	output += "<a id='movieTitle' href='http://localhost:9000/gga_plz/movieinfo.do?movieid="+obj.movieId+"'>"+obj.movieTitle+"</a>";
							}					       			
						    output += "<p>"+obj.genre+"</p></div>";
						    mcount++;
				       	}
				    }
				    if(mlast >= 4){
				       	output += "<a href='http://localhost:9000/gga_plz/movie_menu.do' id='moreResult'>더보기 ></a></div></div>";
				    }else{
				       	output += "</div></div>";
				    }
				       			
			    }
			    
				if(jdata.nlist[0] != null){
				    output += "<div class='noticeSearch'>";
				  	output += "<div class='noticeSearchResult'>";
			     	output += "<div class='noticeSearchTitle'>";
			     	output += "<a href='http://localhost:9000/gga_plz/notice_list.do'><img src='http://localhost:9000/gga_plz/images/noticetitle.png'></a><p>*최근 등록 순</p></div>";
			     	output += "<table>";
			     	output += "<tr><th>번호</th>";
			     	output += "<th>제목</th>";
			     	output += "<th>조회수</th>";
			     	output += "<th>작성일자</th></tr>";
			    for(obj of jdata.nlist){
			     	if(ncount < 5){
				     	output += "<tr><td>No."+obj.nrno+"</td>";
				     	output += "<td ><a href='notice_content.do?nid="+obj.nid+"'>📢 "+obj.ntitle+"</a></td>";
				     	output += "<td>"+obj.nhits+"</td>";
				     	output += "<td>"+obj.ndate+"</td></tr>";
				     	ncount++;
			     	}
			    }
			    output += "</table>";
			    if(nindex >= 6) {
				    output += "<span>총 '"+nindex+"'개의 게시물이 검색 되었습니다.<a href='http://localhost:9000/gga_plz/notice_list.do' id='moreResult2'>더보기 ></a></span></div></div>";
			    }else{
			     	output += "<span>총 '"+nindex+"'개의 게시물이 검색 되었습니다.</span></div></div>";
			    }
			     		  		
			}
			
			if(jdata.blist[0] != null){
				output += "<div class='boardSearch'>";
				output += "<div class='boardSearchResult'>";
			    output += "<div class='boardSearchTitle'>";
			    output += "<a href='http://localhost:9000/gga_plz/board_list.do'><img src='http://localhost:9000/gga_plz/images/comtitle.png'></a><p>*조회수 정렬</p></div>";
			    output += "<table>";
			    output += "<tr><th>번호</th>";
			    output += "<th>제목</th>";
			    output += "<th>조회수</th>";
			    output += "<th>작성자</th>";
			    output += "<th>작성일자</th></tr>";
			for(obj of jdata.blist){
			   if(bcount < 5){
				   output += "<tr><td>"+obj.brno+"</td>";
				   if(obj.movieName == "suzume"){
				  	   output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0002'>📝 [스즈매의 문단속]&nbsp</a>";
					}else if (obj.movieName == "darknight"){
						output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0001'>📝 [다크나이트]&nbsp</a>";
					}else if (obj.movieName == "dune"){
						output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0003'>📝 [듄]&nbsp</a>";
					}else if (obj.movieName == "slamdunk"){
						output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0009'>📝 [슬램덩크]&nbsp</a>";
					}else if (obj.movieName == "inception"){
						output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0004'>📝 [인셉션]&nbsp</a>";
					}else if (obj.movieName == "rings"){
						output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0007'>📝 [반지의제왕]&nbsp</a>";
					}
					if(obj.commentCount > 0){
						output += "<div class='maxSize'><a href="+"'"+"board_content.do?bid="+obj.bid+"'>"+obj.btitle+"</a>&nbsp("+obj.commentCount+")</td></div>";
					}else{
						output += "<div class='maxSize' id='boardSearchBox'><a href="+"'"+"board_content.do?bid="+obj.bid+"'>"+obj.btitle+"</a></td></div>";
					}
				    output += "<td>"+obj.bhits+"</td>";
				    output += "<td>"+obj.mid+"</td>";
				    output += "<td>"+obj.bdate+"</td></tr>"; 
				    bcount++;
			     	}
			    }
			    output += "</table>";
			    if(bindex >= 4){
			     	output += "<span>총'"+bindex+"'개의 게시물이 검색 되었습니다.<a href='http://localhost:9000/gga_plz/board_list.do' id='moreResult2'>더보기 ></a></span></div></div>";
			    }else{
			     	output += "<span>총'"+bindex+"'개의 게시물이 검색 되었습니다.</span></div></div>";
			    }
			}
			       		   
			if(jdata.plist[0] != null){
				output += "<div class='movieSearch'>";
				output += "<div class='movieSearchTitle' id='storeSearchTitle'>";
				output += "<a href='http://localhost:9000/gga_plz/store.do'><img src='http://localhost:9000/gga_plz/images/storetitle.png'></a></div>";
				output += "<div class='movieSearchResult'>";
			for(obj of jdata.plist){
				if(pcount < 3){
					output += "<div class='movieSearchInfo' id='storeSearchInfo'>";
					output += "<a href='http://localhost:9000/gga_plz/store.do'><img src='"+obj.pfile+"' class='movieSearchInfoImg' id='"+obj.pid+"'></a>";
					output += "<a href='http://localhost:9000/gga_plz/store.do' id='movieTitle'>"+obj.pname+"</a></div>";
					pcount++;
				}
			}
			output += "<a href='http://localhost:9000/gga_plz/store.do' id='moreResult'>상품 더보기 ></a></div></div>";
		}
								
		$(".noneResult").remove();
		$(".noneResultGuide").remove();
		$(".noneResult").remove();
		$(".movieSearch").remove();
		$(".noticeSearch").remove();
		$(".boardSearch").remove();
		$(".indexSearch").append(output);
			       		   
			       		   
	} //success
}); //ajax


	/***********************
		통합검색 - 송지웅 6월 13일
	***********************/
	$("#btnSearch").click(function(){
	var initFlag = $("#firstSearch").val();
	
		if($("#searchContent").val() =="" ){
			alert("검색 내용을 입력해주세요.");
			$("#searchContent").focus();
			return false;
		} else{
			if(initFlag == null) {
				let firstSearch = $("#searchContent").val();
				initFlag = true;
				location.href="http://localhost:9000/gga_plz/indexSearch.do?firstSearch="+firstSearch;
			}else{
				$.ajax({
				     url:"http://localhost:9000/gga_plz/indexSearch_json_data.do?searchContent="+$("#searchContent").val(),
			         success: function(result){
				     	let jdata = JSON.parse(result);
				        var output = "";
				        var mcount = 0;	var ncount = 0;	var bcount = 0;	var pcount = 0;
				        let mindex = jdata.mlist.length-1;	let nindex = jdata.nlist.length;	let bindex = jdata.blist.length;
				        let pindex = jdata.plist.length-1;
				        var mlast = 0;	var nlast = 0;	var blast = 0;	var plast = 0;
				        if(mindex != -1) mlast = jdata.mlist[mindex].mrno;
				        if(pindex != -1) plast = jdata.plist[pindex].prno;
				        
					 	   if(jdata.mlist[0] == null && jdata.nlist[0] == null){
					 			if(jdata.blist[0] == null && jdata.plist[0] == null) {
							   		output += "<div class='noneResult'>";
									output += "<img src='http://localhost:9000/gga_plz/images/indexSearchNoneResult.png'>";
									output += "<span class='result1'>"+"'"+$("#searchContent").val()+"'"+"검색결과가 없습니다.</span><br>";
									output += "<span class='result2'>검색내용을 확인 후 다시 검색해주세요!!</span></div>";
									output += "<div class='noneResultGuide'>";
									output += "<span class='resultGuide'>Ex) 영화 제목, 선호 장르, 공지사항 제목, 리뷰 제목, 상품명</span></div>";
					 			}
					       }
					       if(jdata.mlist[0] != null){
				       				output += "<div class='movieSearch'>";
					       			output += "<div class='movieSearchTitle'>";
					       			output += "<a href='http://localhost:9000/gga_plz/movie_menu.do'><img src='http://localhost:9000/gga_plz/images/movietitle.png'></a></div>";
					       			output += "<div class='movieSearchResult'>";
				       			for(obj of jdata.mlist){
				       				if(mcount < 3) {
						       			output += "<div class='movieSearchInfo'>";
						       			output += "<a href='http://localhost:9000/gga_plz/movieinfo.do?movieid="+obj.movieId+"'><img src='http://localhost:9000/gga_plz/images/"+obj.mainPoster+"'"+" class='movieSearchInfoImg' id='"+obj.movieId+"'"+"></a>";
						       			if(obj.movieTitle == '귀멸의 칼날: 상현집결, 그리고 도공 마을로'){
						       				output += "<a id='movieTitle' href='http://localhost:9000/gga_plz/movieinfo.do?movieid=MOVIE_0006'>귀멸의칼날 : 상현집결</a>";
										}else{
						       				output += "<a id='movieTitle' href='http://localhost:9000/gga_plz/movieinfo.do?movieid="+obj.movieId+"'>"+obj.movieTitle+"</a>";
										}					       			
						       				output += "<p>"+obj.genre+"</p></div>";
						       				mcount++;
				       				}
				       			}
				       			if(mlast >= 4){
				       				output += "<a href='http://localhost:9000/gga_plz/movie_menu.do' id='moreResult'>더보기 ></a></div></div>";
				       			}else{
				       				output += "</div></div>";
				       			}
				       			
			       		   }
				       		  
				   		   if(jdata.nlist[0] != null){
				         		output += "<div class='noticeSearch'>";
				  		  		output += "<div class='noticeSearchResult'>";
			     		  		output += "<div class='noticeSearchTitle'>";
			     		  		output += "<a href='http://localhost:9000/gga_plz/notice_list.do'><img src='http://localhost:9000/gga_plz/images/noticetitle.png'></a><p>*최근 등록 순</p></div>";
			     		  		output += "<table>";
			     		  		output += "<tr><th>번호</th>";
			     		  		output += "<th>제목</th>";
			     		  		output += "<th>조회수</th>";
			     		  		output += "<th>작성일자</th></tr>";
			     		  		for(obj of jdata.nlist){
			     		  			if(ncount < 5){
				     		  		output += "<tr><td>No."+obj.nrno+"</td>";
				     		  		output += "<td ><a href='notice_content.do?nid="+obj.nid+"'>📢 "+obj.ntitle+"</a></td>";
				     		  		output += "<td>"+obj.nhits+"</td>";
				     		  		output += "<td>"+obj.ndate+"</td></tr>";
				     		  		ncount++;
			     		  			}
			     		  		}
			     		  		output += "</table>";
			     		  		if(nindex >= 6) {
				     		  		output += "<span>총 '"+nindex+"'개의 게시물이 검색 되었습니다.<a href='http://localhost:9000/gga_plz/notice_list.do' id='moreResult2'>더보기 ></a></span></div></div>";
			     		  		}else{
			     		  			output += "<span>총 '"+nindex+"'개의 게시물이 검색 되었습니다.</span></div></div>";
			     		  		}
			     		  		
			       		   }
			       		   
				   		   if(jdata.blist[0] != null){
				         		output += "<div class='boardSearch'>";
				  		  		output += "<div class='boardSearchResult'>";
			     		  		output += "<div class='boardSearchTitle'>";
			     		  		output += "<a href='http://localhost:9000/gga_plz/board_list.do'><img src='http://localhost:9000/gga_plz/images/comtitle.png'></a><p>*조회수 정렬</p></div>";
			     		  		output += "<table>";
			     		  		output += "<tr><th>번호</th>";
			     		  		output += "<th>제목</th>";
			     		  		output += "<th>조회수</th>";
			     		  		output += "<th>작성자</th>";
			     		  		output += "<th>작성일자</th></tr>";
			     		  		for(obj of jdata.blist){
			     		  			if(bcount < 5){
				     		  		output += "<tr><td>"+obj.brno+"</td>";
				     		  		if(obj.movieName == "suzume"){
				  	       			 	output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0002'>📝 [스즈매의 문단속]&nbsp</a>";
						          	}else if (obj.movieName == "darknight"){
						  	        	output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0001'>📝 [다크나이트]&nbsp</a>";
						          	}else if (obj.movieName == "dune"){
						  	        	output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0003'>📝 [듄]&nbsp</a>";
						          	}else if (obj.movieName == "slamdunk"){
						  	        	output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0009'>📝 [슬램덩크]&nbsp</a>";
						          	}else if (obj.movieName == "inception"){
						  	        	output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0004'>📝 [인셉션]&nbsp</a>";
						          	}else if (obj.movieName == "rings"){
						  	        	output += "<td><a href="+"'"+"movieinfo.do?movieid=MOVIE_0007'>📝 [반지의제왕]&nbsp</a>";
						          	}
						          	if(obj.commentCount > 0){
						          		output += "<div class='maxSize'><a href="+"'"+"board_content.do?bid="+obj.bid+"'>"+obj.btitle+"</a>&nbsp("+obj.commentCount+")</td></div>";
						          	}else{
						          		output += "<div class='maxSize' id='boardSearchBox'><a href="+"'"+"board_content.do?bid="+obj.bid+"'>"+obj.btitle+"</a></td></div>";
						          	}
				     		  		output += "<td>"+obj.bhits+"</td>";
				     		  		output += "<td>"+obj.mid+"</td>";
				     		  		output += "<td>"+obj.bdate+"</td></tr>"; 
				     		  		bcount++;
			     		  			}
			     		  		}
			     		  		output += "</table>";
			     		  		if(bindex >= 4){
			     		  			output += "<span>총'"+bindex+"'개의 게시물이 검색 되었습니다.<a href='http://localhost:9000/gga_plz/board_list.do' id='moreResult2'>더보기 ></a></span></div></div>";
			     		  		}else{
			     		  			output += "<span>총'"+bindex+"'개의 게시물이 검색 되었습니다.</span></div></div>";
			     		  		}
			       		   }
			       		   
				   		   if(jdata.plist[0] != null){
				         		output += "<div class='movieSearch'>";
				  		  		output += "<div class='movieSearchTitle' id='storeSearchTitle'>";
				  		  		output += "<a href='http://localhost:9000/gga_plz/store.do'><img src='http://localhost:9000/gga_plz/images/storetitle.png'></a></div>";
				  		  		output += "<div class='movieSearchResult'>";
				  		  		for(obj of jdata.plist){
				  		  			if(pcount < 3){
						  		  		output += "<div class='movieSearchInfo' id='storeSearchInfo'>";
						  		  		output += "<a href='http://localhost:9000/gga_plz/store.do'><img src='"+obj.pfile+"' class='movieSearchInfoImg' id='"+obj.pid+"'></a>";
						  		  		output += "<a href='http://localhost:9000/gga_plz/store.do' id='movieTitle'>"+obj.pname+"</a></div>";
						  		  		pcount++;
				  		  			}
				  		  		}
					  		  		output += "<a href='http://localhost:9000/gga_plz/store.do' id='moreResult'>상품 더보기 ></a></div></div>";
			       		   }
								
			       		   		$(".noneResult").remove();
								$(".noneResultGuide").remove();
				  		  		$(".noneResult").remove();
				       			$(".movieSearch").remove();
				       			$(".noticeSearch").remove();
				       			$(".boardSearch").remove();
				       			$(".indexSearch").append(output);
			       		   
			       		   
		      	 	 } //success
				}); //ajax
			}
		} //if
	});	//click
}); //ready