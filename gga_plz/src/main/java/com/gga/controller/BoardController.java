package com.gga.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gga.service.BoardService;
import com.gga.service.PageServiceImpl;
import com.gga.vo.BoardVo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private PageServiceImpl pageService;
	
	
	// file_upload_proc.do - 파일 업로드
	@RequestMapping(value="/board_write_proc.do", method=RequestMethod.POST)
	public String board_write_proc(BoardVo boardVo, HttpServletRequest request) throws Exception{
		String viewName = "";
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		if(boardVo.getFile1().getOriginalFilename() != null) {
			UUID uuid = UUID.randomUUID();
			String bfile = boardVo.getFile1().getOriginalFilename();
			String bsfile = uuid + "_" + bfile;
			
			boardVo.setBsfile(bsfile);
		}else {
			//파일 없음
		}
		int result = boardService.getWriteResult(boardVo);
		if(result == 1) {
			File file = new File(root_path + attach_path + boardVo.getBsfile());
			boardVo.getFile1().transferTo(file);
			viewName = "redirect:/board_list.do";
		}
		return viewName;
	}
	
	// 보드 검색 기능 
	@RequestMapping(value="/board_search_json_data.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String board_search_json_data(String btitle,String page) {
		
		Map<String, Integer> param = pageService.getPageResult(page, "boardSearch", boardService, btitle);
		ArrayList<BoardVo> list = boardService.getList(param.get("startCount"), param.get("endCount") , btitle);
		
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();
		
		for(BoardVo boardVo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("rno", boardVo.getRno());
			jobj.addProperty("btitle", boardVo.getBtitle());
			jobj.addProperty("bhits", boardVo.getBhits());
			jobj.addProperty("bid", boardVo.getBid());
			jobj.addProperty("movieName", boardVo.getMovieName());
			jobj.addProperty("mid", boardVo.getMid());
			jobj.addProperty("bdate", boardVo.getBdate());
			jarray.add(jobj);
		}
		jlist.add("jlist", jarray);
		jlist.addProperty("totals", param.get("totals"));
		jlist.addProperty("pageSize", param.get("pageSize"));
		jlist.addProperty("maxSize", param.get("maxSize"));
		jlist.addProperty("page", param.get("page"));
		
		return new Gson().toJson(jlist);
	}
	
	// Json용 매핑
	@RequestMapping(value="/board_list.do", method=RequestMethod.GET)
	public String board_list() {
		return "board/board_list";
	}
	
	@RequestMapping(value="/board_list_json_data.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String board_list_json_data(String page) {
		Map<String, Integer> param = pageService.getPageResult(page, "board", boardService);
		ArrayList<BoardVo> list = boardService.getList(param.get("startCount"), param.get("endCount"));
		
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();
		for(BoardVo boardVo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("rno", boardVo.getRno());
			jobj.addProperty("btitle", boardVo.getBtitle());
			jobj.addProperty("bhits", boardVo.getBhits());
			jobj.addProperty("mid", boardVo.getMid());
			jobj.addProperty("bid", boardVo.getBid());
			jobj.addProperty("bdate", boardVo.getBdate());
			jobj.addProperty("movieName", boardVo.getMovieName());
			jarray.add(jobj);
		}
		jlist.add("jlist", jarray);
		jlist.addProperty("totals", param.get("totals"));
		jlist.addProperty("pageSize", param.get("pageSize"));
		jlist.addProperty("maxSize", param.get("maxSize"));
		jlist.addProperty("page", param.get("page"));
		
		return new Gson().toJson(jlist);
	}
	
		//FAQ
		@RequestMapping(value="/faq.do", method=RequestMethod.GET)
		public String faq() {
			return "/board/faq";
		}
		
		// board_write.do - 게시글 글쓰기 
		@RequestMapping(value="/board_write.do", method=RequestMethod.GET)
		public String board_write() {
			return "/board/board_write";
		}
		
		
		// board_delete - 삭제
		@RequestMapping(value="/board_delete_proc.do", method=RequestMethod.POST)
		public String board_delete_proc(String bid) {
			String viewName = "";
			if(boardService.getDeleteResult(bid) == 1) {
				viewName = "redirect:/board_list.do";
			}else {
				//실패 페이지이동
			}
			return viewName;
		}
		
		// board_update - 업데이트 로직
		@RequestMapping(value="/board_update_proc.do", method=RequestMethod.POST)
		public String board_update_proc(BoardVo boardVo, HttpServletRequest request) throws Exception {
//			String viewName = "";
//			String root_path = request.getSession().getServletContext().getRealPath("/");
//			String attach_path = "\\resources\\upload\\";
//			if(boardVo.getFile1().getOriginalFilename() != null) {
//				UUID uuid = UUID.randomUUID();
//				String bfile = boardVo.getFile1().getOriginalFilename();
//				String bsfile = uuid + "_" + bfile;
//				
//				boardVo.setBsfile(bsfile);
//			}else {
//				//파일 없음
//			}
//			int result = boardService.getUpdateResult(boardVo);
//			if(result == 1) {
//				File file = new File(root_path + attach_path + boardVo.getBsfile());
//				boardVo.getFile1().transferTo(file);
//				viewName = "redirect:/board_list.do";
//			}
//			return viewName;
			String viewName = "";
			if(boardService.getUpdateResult(boardVo) == 1) {
				viewName = "redirect:/board_list.do";
			}else {
				//실패 페이지 이동
			}
			return viewName;
		}
		
		// board_update.do - 고른 content 값 Default
		@RequestMapping(value="/board_update.do",method=RequestMethod.GET)
		public ModelAndView board_update(String bid) {
			ModelAndView model = new ModelAndView();
			BoardVo boardVo = boardService.getUpdatePage(bid);
			model.addObject("bvo", boardVo);
			model.setViewName("/board/board_update");
			return model;
		}

		@RequestMapping(value="/board_content.do",method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
		public ModelAndView board_content(String bid) {
			ModelAndView model = new ModelAndView();
			BoardVo boardVo = boardService.getContentPage(bid);
			model.addObject("boardVo", boardVo);
			model.setViewName("/board/board_content");
			return model;
		}
}
