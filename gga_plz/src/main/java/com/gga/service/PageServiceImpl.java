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
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private NoticeService noticeService;
	
	
	public Map<String, Integer> getPageResult(String page, String serviceName) {
		
		Map<String, Integer> param = new HashMap<String, Integer>();
		
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5;	//�븳�럹�씠吏��떦 寃뚯떆臾� �닔
		int reqPage = 1;	//�슂泥��럹�씠吏�	
		int pageCount = 1;	//�쟾泥� �럹�씠吏� �닔
		int dbCount = 0;	//DB�뿉�꽌 媛��졇�삩 �쟾泥� �뻾�닔
		
		if(serviceName.equals("movie")) {
			dbCount = movieService.getTotalRowCount();
		}
	//�럹�씠吏� 泥섎━ - startCount, endCount 援ы븯湲�
			//珥� �럹�씠吏� �닔 怨꾩궛
			if(dbCount % pageSize == 0){
				pageCount = dbCount/pageSize;
			}else{
				pageCount = dbCount/pageSize+1;
			}

			//�슂泥� �럹�씠吏� 怨꾩궛
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
	
	public Map<String, Integer> getPageResult(String page, String serviceName, Object serviceType, String btitle) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		
		//����¡ ó��
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5;
		int pageCount = 1;
		int reqPage = 1;
		int dbCount = 0;
			
		if(serviceName.equals("board")) {
			boardService = (BoardServiceImpl)serviceType;
			dbCount = boardService.getTotalRowCount();
		}else if(serviceName.equals("boardSearch")) {
			boardService = (BoardServiceImpl)serviceType;
			dbCount = boardService.getSearchRowCount(btitle);
		}else if(serviceName.equals("boardComment")) {
			dbCount = boardService.getCommentRowCount(btitle); // 
		}
		
		if(dbCount % pageSize == 0) {
			pageCount = dbCount/pageSize;
		}else {
			pageCount = dbCount/pageSize+1;
		}
				
		if(page != null) {
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1;
			endCount = reqPage * pageSize;
		}else {
			startCount = 1;
			endCount = pageSize;
		}
		
		param.put("totals", dbCount);
		param.put("maxSize", pageCount);
		param.put("pageSize", pageSize);
		param.put("page", reqPage);
		param.put("startCount", startCount);
		param.put("endCount", endCount);
			
		return param;	
		
	}
	
	public Map<String, Integer> getPageResult(String page, String serviceName, Object serviceType) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		
		//����¡ ó��
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5;
		int pageCount = 1;
		int reqPage = 1;
		int dbCount = 0;
		
		if(serviceName.equals("board")) {
			boardService = (BoardServiceImpl)serviceType;
			dbCount = boardService.getTotalRowCount();
		}
		
		if(dbCount % pageSize == 0) {
			pageCount = dbCount/pageSize;
		}else {
			pageCount = dbCount/pageSize+1;
		}
		
		if(page != null) {
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1;
			endCount = reqPage * pageSize;
		}else {
			startCount = 1;
			endCount = pageSize;
		}
		
		param.put("totals", dbCount);
		param.put("maxSize", pageCount);
		param.put("pageSize", pageSize);
		param.put("page", reqPage);
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		
		return param;	
		
	}
}