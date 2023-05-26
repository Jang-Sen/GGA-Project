
package com.gga.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gga.service.MemberService;
import com.gga.service.NoticeService;
import com.gga.vo.MemberVo;
import com.gga.vo.NoticeVo;

@Controller
public class AdminController {
	
	
//	  @Autowired 
//	  private BoardService boardService;
	  
	  @Autowired 
	  private MemberService memberService;
	 
	  
	  @Autowired
	  private NoticeService noticeService;
	
	/*
	 * admin_board_content - 리뷰 상세보기
	 */
	@RequestMapping(value="/admin_board_content.do",method=RequestMethod.GET)
	public ModelAndView admin_board_content(String bid) {
		ModelAndView model = new ModelAndView();
		//BoardDao boardDao = new BoardDao();
//		BoardVo boardVo = boardService.getSelect(bid);
		
//		model.addObject("boardVo", boardVo);
		model.setViewName("/admin/board/admin_board_content");
		
		return model;
	}
	
	/*
	 * admin_board_list - 리뷰 목록
	 */
	@RequestMapping(value="/admin_board_list.do", method=RequestMethod.GET)
	public ModelAndView admin_board_list(String page) {
		ModelAndView model = new ModelAndView();
		//BoardDao boardDao = new BoardDao();

		//����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5;	//���������� �Խù� ��
		int reqPage = 1;	//��û������	
		int pageCount = 1;	//��ü ������ ��
//		int dbCount = boardService.getTotalRowCount();	//DB���� ������ ��ü ���
		
		//�� ������ �� ���
//		if(dbCount % pageSize == 0){
//			pageCount = dbCount/pageSize;
//		}else{
//			pageCount = dbCount/pageSize+1;
//		}

		//��û ������ ���
		if(page != null){
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = 5;
		}
		
//		ArrayList<BoardVo> list = boardService.getSelect(startCount, endCount);
	
//		model.addObject("list", list);
//		
//		model.addObject("dbCount", dbCount);
		model.addObject("pageSize", pageSize);
		model.addObject("pageCount", pageCount);
		model.addObject("page", reqPage);
		
		
		model.setViewName("/admin/board/admin_board_list");
		
		return model;
		
	}
	
	/*
	 * admin_member_list - 회원 목록
	 */
	@RequestMapping(value="/admin_member_list.do", method=RequestMethod.GET)
	public ModelAndView admin_member_list(String page) {
		ModelAndView model = new ModelAndView();
		
		// 페이징 처리 - startCount, endCount 구하기
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5;	// 한 페이지 당 게시물 수
		int reqPage = 1;	// 요청 페이지
		int pageCount = 1;	// 전체 페이지 수
		int dbCount = memberService.getTotalRowCount();	// DB에서 가져온 전체 행 수
		
		// 총 페이지 수 계산
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}

		// 요청 페이지 계산
		if(page != null){
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = 5;
		}
		
		ArrayList<MemberVo> list = memberService.getSelect(startCount, endCount);
	
		model.addObject("list", list);
		
		model.addObject("dbCount", dbCount);
		model.addObject("pageSize", pageSize);
		model.addObject("pageCount", pageCount);
		model.addObject("page", reqPage);
		
		model.setViewName("/admin/member/admin_member_list");
		
		return model;
	}
	
	
	
	/*
	 * admin_notice_delete_proc - 공지사항 삭제 처리
	 */
	@RequestMapping(value="/admin_notice_delete_proc.do", method=RequestMethod.POST)
	public ModelAndView admin_notice_delete_proc(String nid) {
		ModelAndView model = new ModelAndView();
		int result = noticeService.getDelete(nid);
		if(result == 1) {
			model.setViewName("redirect:/admin_notice_list.do");
		}
		return model;
	}
	
	
	/*
	 * admin_notice_delete - 공지사항 삭제
	 */
	@RequestMapping(value="/admin_notice_delete.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_delete(String nid) {
		ModelAndView model = new ModelAndView();
		model.addObject("nid", nid);
		model.setViewName("/admin/notice/admin_notice_delete");
		
		return model;
	}
	
	
	/*
	 * admin_notice_write_proc.do - 공지사항 등록 처리
	 */
	@RequestMapping(value="/admin_notice_write_proc.do", method=RequestMethod.POST)
	public String admin_notice_write_proc(NoticeVo noticeVo) {
		String viewName = "";
		int result = noticeService.getInsert(noticeVo);
		if(result == 1) {
			viewName = "redirect:/admin_notice_list.do";
		}else {
			
		}
		return viewName;
	}
	
	
	/*
	 * admin_notice_write - 공지사항 등록
	 */
	@RequestMapping(value="/admin_notice_write.do", method = RequestMethod.GET)
	public String admin_notice_write() {
		return "/admin/notice/admin_notice_write";
	}
	
	
	/*
	 * admin_notice_update_proc.do - 공지사항 수정 처리
	 */
	@RequestMapping(value="/admin_notice_update_proc.do", method=RequestMethod.POST)
	public ModelAndView admin_notice_update_proc(NoticeVo noticeVo) {
		ModelAndView model = new ModelAndView();
		int result = noticeService.getUpdate(noticeVo);
		
		if(result == 1) {
			model.setViewName("redirect:/admin_notice_list.do");
		}else {
			
		}
		return model;
	}
	
	
	/*
	 * admin_notice_update.do - 공지사항 수정
	 */
	@RequestMapping(value="/admin_notice_update.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_update(String nid) {
		ModelAndView model = new ModelAndView();
		NoticeVo noticeVo = noticeService.getSelect(nid);
		model.addObject("noticeVo", noticeVo);
		model.setViewName("/admin/notice/admin_notice_update");
		
		return model;
	}
	
	
	
	/*
	 * admin_notice_content.do - 공지사항 상세보기
	 */
	@RequestMapping(value="/admin_notice_content.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_content(String nid) {
		ModelAndView model = new ModelAndView();
		NoticeVo noticeVo = noticeService.getSelect(nid);
		if(noticeVo != null) {
			noticeService.getUpdateHits(nid);
		}
		model.addObject("noticeVo", noticeVo);
		model.setViewName("/admin/notice/admin_notice_content");
		return model;
	}
	
	
	/*
	 * admin_index.do - 관리자 메인 페이지
	 */
	@RequestMapping(value="/admin_index.do", method=RequestMethod.GET)
	public String admin_index() {
		return "admin/admin_index";
	}
	
	
	@RequestMapping(value = "/admin_notice_list.do", method = RequestMethod.GET)
	public ModelAndView admin_notice_list(String page) {
		ModelAndView model = new ModelAndView();

		int startCount = 0;
		int endCount = 0;
		int pageSize = 10;
		int reqPage = 1;
		int pageCount = 1;
		int dbCount = noticeService.getTotalRowCount();

		if (dbCount % pageSize == 0) {
			pageCount = dbCount / pageSize;
		} else {
			pageCount = dbCount / pageSize + 1;
		}

		if (page != null) {
			reqPage = Integer.parseInt(page);
			startCount = (reqPage - 1) * pageSize + 1;
			endCount = reqPage * pageSize;
		} else {
			startCount = 1;
			endCount = pageSize;
		}

		ArrayList<NoticeVo> list = noticeService.getSelect(startCount, endCount);

		model.addObject("list", list);
		model.addObject("totals", dbCount);
		model.addObject("pageSize", pageSize);
		model.addObject("maxSize", pageCount);
		model.addObject("page", reqPage);

		model.setViewName("admin/notice/admin_notice_list");

		return model;
	}
}



/*
 * admin_notice_list.do
 */
/*
 * @RequestMapping(value="/admin_notice_list.do", method=RequestMethod.GET)
 * public ModelAndView admin_notice_list() { ModelAndView model = new
 * ModelAndView(); NoticeDao noticeDao = new NoticeDao();
 * 
 * ArrayList<NoticeVo> list = noticeDao.select(); model.addObject("list", list);
 * model.setViewName("admin/notice/admin_notice_list");
 * 
 * return model; }
 */
