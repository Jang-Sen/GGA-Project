package com.gga.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gga.dao.BoardDao;
import com.gga.vo.BoardVo;

@Controller
public class BoardController {
	@RequestMapping(value="/faq.do", method=RequestMethod.GET)
	public String faq() {
		return "/board/faq";
	}
	// board_wirte.do - 게시글 저장
		@RequestMapping(value="/board_write_proc.do",method=RequestMethod.POST)
		public String board_write_proc(BoardVo boardVo) {
			String viewName ="";
			BoardDao boardDao = new BoardDao();
			int result = boardDao.insert(boardVo);
			if(result == 1) {
				viewName = "redirect:/board_list.do";
			}else {
				//실패 페이지 이동
			}	
			return viewName;
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
			BoardDao boardDao = new BoardDao();
			int result = boardDao.delete(bid);
			if(result == 1) {
				viewName = "redirect:/board_list.do";
			}else {
				//실패 페이지이동
			}
			return viewName;
		}
		
		// board_update - 업데이트 로직
		@RequestMapping(value="/board_update_proc.do", method=RequestMethod.POST)
		public String board_update_proc(BoardVo boardVo) {
			String viewName = "";
			BoardDao boardDao = new BoardDao();
			int result = boardDao.update(boardVo);
			if(result == 1) {
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
			BoardDao boardDao = new BoardDao();
			BoardVo boardVo = boardDao.select(bid);
			model.addObject("bvo", boardVo);
			model.setViewName("/board/board_update");
			return model;
		}
		
		// board_content.do
		@RequestMapping(value="/board_content.do",method=RequestMethod.GET)
		public ModelAndView board_content(String bid) {
			ModelAndView model = new ModelAndView();
			BoardDao boardDao = new BoardDao();
			BoardVo boardVo = boardDao.select(bid);
			model.addObject("boardVo", boardVo);
			model.setViewName("/board/board_content");
			return model;
		}
		
		// board_list.do

		@RequestMapping(value="/board_list.do", method=RequestMethod.GET)
		public ModelAndView board_list() {
			ModelAndView model = new ModelAndView();
			BoardDao boardDao = new BoardDao();
			ArrayList<BoardVo> list = boardDao.select();
			model.addObject("list", list);
			model.setViewName("/board/board_list");
			
			return model;
		}
}
