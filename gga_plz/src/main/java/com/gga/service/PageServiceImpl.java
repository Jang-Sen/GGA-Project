package com.gga.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl {

	@Autowired
	private MovieService movieService;
	
//	@Autowired
//	private MemberService memberService;
//	
//	@Autowired
//	private BoardService boardService;
	
	@Autowired
	private NoticeService noticeService;
	
	
	public Map<String, Integer> getPageResult(String page, String serviceName) {
		
		Map<String, Integer> param = new HashMap<String, Integer>();
		
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5;	//한페이지당 게시물 수
		int reqPage = 1;	//요청페이지	
		int pageCount = 1;	//전체 페이지 수
		int dbCount = 0;	//DB에서 가져온 전체 행수
		
		if(serviceName.equals("movie")) {
			dbCount = movieService.getTotalRowCount();
		}
	//페이징 처리 - startCount, endCount 구하기
			//총 페이지 수 계산
			if(dbCount % pageSize == 0){
				pageCount = dbCount/pageSize;
			}else{
				pageCount = dbCount/pageSize+1;
			}

			//요청 페이지 계산
			if(page != null){
				reqPage = Integer.parseInt(page);
				startCount = (reqPage-1) * pageSize+1; 
				endCount = reqPage *pageSize;
			}else{
				startCount = 1;
				endCount = 5;
			}
			
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("pageSize", pageSize);
		param.put("page", reqPage);
		param.put("maxSize", pageCount);
		param.put("totals", dbCount);
			
		return param;
	}
}