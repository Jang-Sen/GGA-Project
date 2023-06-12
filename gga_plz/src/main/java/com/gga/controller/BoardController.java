
package com.gga.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gga.service.BoardService;
import com.gga.service.PageServiceImpl;
import com.gga.vo.BoardCommentVo;
import com.gga.vo.BoardVo;
import com.gga.vo.SessionVo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private PageServiceImpl pageService;
	
	// board_master_json_data.do - 마이페이지 보드 뎃글
	@ResponseBody
	@RequestMapping(value="/board_master_json_data.do", method=RequestMethod.GET)
	public String board_master_json_data(String page, String id) {
		Map<String, Integer> param = pageService.getPageResult(page, "boardMaster", boardService, id);
		ArrayList<BoardVo> list = boardService.getCommentMaster(param.get("startCount"), param.get("endCount"), id);
		
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();
		
		for(BoardVo boardVo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("rno", boardVo.getRno());
			jobj.addProperty("btitle", boardVo.getBtitle());
			jobj.addProperty("bhits", boardVo.getBhits());
			jobj.addProperty("bdate", boardVo.getBdate());
			jobj.addProperty("movieName", boardVo.getMovieName());
			jobj.addProperty("bid", boardVo.getBid());
			jarray.add(jobj);
		}
		jlist.add("jlist", jarray);
		jlist.addProperty("totals", param.get("totals"));
		jlist.addProperty("pageSize", param.get("pageSize"));
		jlist.addProperty("maxSize", param.get("maxSize"));
		jlist.addProperty("page", param.get("page"));
		
		return new Gson().toJson(jlist);
	}
	
//	 board_comment_update.do - 보드 뎃글 업데이트
	@ResponseBody
	@RequestMapping(value="/board_comment_update.do", method=RequestMethod.GET)
	public String board_comment_update(String bcid, String updateComment) {
		String bid = "";
		String saveBid = boardService.getCommentSelect(bcid);
		int result = boardService.getCommentUpdateResult(bcid, updateComment);
		if(result == 1) bid = saveBid;
		return bid;
	}
	
	// board_comment_delete.do - 보드 뎃글삭제
	@ResponseBody
	@RequestMapping(value="/board_comment_delete.do", method=RequestMethod.GET)
	public String board_comment_delete(String bcid) {
		String bid = "";
		String saveBid = boardService.getCommentSelect(bcid);
		int result = boardService.getCommentDeleteResult(bcid);
		if(result == 1) bid = saveBid;
		return bid;
	}
	
	// board_comment_proc.do - 蹂대뱶 �럠湲� Form
	@RequestMapping(value="/board_comment_proc.do", method=RequestMethod.POST)
	public String board_comment_proc(BoardCommentVo commentVo) {
		String viewName = "";
		int result = boardService.getCommentWriteResult(commentVo);
		
		if(result == 1) {
			viewName = "redirect:/board_content.do?bid="+commentVo.getBid();
		}else {
			//�떎�뙣 �럹�씠吏� �씠�룞
		}
		return viewName;
	}
	
	// file_upload_proc.do - �뙆�씪 �뾽濡쒕뱶
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
			//�뙆�씪 �뾾�쓬
		}
		int result = boardService.getWriteResult(boardVo);
		if(result == 1) {
			File file = new File(root_path + attach_path + boardVo.getBsfile());
			boardVo.getFile1().transferTo(file);
			viewName = "redirect:/board_list.do";
		}
		return viewName;
	}
	
	// 蹂대뱶 寃��깋 湲곕뒫 
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
			jobj.addProperty("commentCount", boardService.getCommentRowCount(boardVo.getBid()));
			jarray.add(jobj);
		}
		jlist.add("jlist", jarray);
		jlist.addProperty("totals", param.get("totals"));
		jlist.addProperty("pageSize", param.get("pageSize"));
		jlist.addProperty("maxSize", param.get("maxSize"));
		jlist.addProperty("page", param.get("page"));
		
		return new Gson().toJson(jlist);
	}
	
	// Json�슜 留ㅽ븨
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
			jobj.addProperty("commentCount", boardService.getCommentRowCount(boardVo.getBid()));
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
		
		// board_write.do - 寃뚯떆湲� 湲��벐湲� 
		@RequestMapping(value="/board_write.do", method=RequestMethod.GET)
		public String board_write() {
			return "/board/board_write";
		}
		
		
		// board_delete - �궘�젣
		@RequestMapping(value="/board_delete_proc.do", method=RequestMethod.POST)
		public String board_delete_proc(String bid) {
			String viewName = "";
			if(boardService.getDeleteResult(bid) == 1) {
				viewName = "redirect:/board_list.do";
			}else {
				//�떎�뙣 �럹�씠吏��씠�룞
			}
			return viewName;
		}
		
		// board_update - �뾽�뜲�씠�듃 濡쒖쭅
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
//				//�뙆�씪 �뾾�쓬
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
				//�떎�뙣 �럹�씠吏� �씠�룞
			}
			return viewName;
		}
		
		// board_update.do - 怨좊Ⅸ content 媛� Default
		@RequestMapping(value="/board_update.do",method=RequestMethod.GET)
		public ModelAndView board_update(String bid) {
			ModelAndView model = new ModelAndView();
			BoardVo boardVo = boardService.getUpdatePage(bid);
			model.addObject("bvo", boardVo);
			model.setViewName("/board/board_update");
			return model;
		}

		@RequestMapping(value="/board_content.do",method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
		public ModelAndView board_content(String bid, String page, HttpSession session) {
			ModelAndView model = new ModelAndView();
			Map<String, Integer> param = pageService.getPageResult(page, "boardComment", boardService, bid);
			
			BoardVo boardVo = boardService.getContentPage(bid);
			ArrayList<BoardCommentVo> bcVo = boardService.getCommentList(param.get("startCount"),param.get("endCount"),bid);
			
			int authCheck = 0;
			SessionVo svo = (SessionVo)session.getAttribute("svo");
			if(svo != null) {
				if(boardVo.getMid().equals(svo.getId())) {
					authCheck = 1;
				}else if(svo.getId().equals("admin")) {
					authCheck = 1;
				}
			}
			model.addObject("boardVo", boardVo);
			model.addObject("bcVo", bcVo);
			model.addObject("authCheck", authCheck);
			model.addObject("totals", param.get("totals"));
			model.addObject("maxSize", param.get("maxSize"));
			model.addObject("pageSize", param.get("pageSize"));
			model.addObject("page", param.get("page"));
			
			model.setViewName("/board/board_content");
			return model;
		}
}
