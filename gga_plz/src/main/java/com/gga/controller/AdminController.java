
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

import com.gga.service.MemberService;
import com.gga.service.NoticeService;
import com.gga.service.PageServiceImpl;
import com.gga.vo.MemberVo;
import com.gga.vo.NoticeVo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class AdminController {

//	  @Autowired 
//	  private BoardService boardService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private PageServiceImpl pageService;

	/*
	 * admin_board_content - 리뷰 상세보기
	 */
	@RequestMapping(value = "/admin_board_content.do", method = RequestMethod.GET)
	public ModelAndView admin_board_content(String bid) {
		ModelAndView model = new ModelAndView();
		// BoardDao boardDao = new BoardDao();
//		BoardVo boardVo = boardService.getSelect(bid);

//		model.addObject("boardVo", boardVo);
		model.setViewName("/admin/board/admin_board_content");

		return model;
	}

	/*
	 * admin_board_list - 리뷰 목록
	 */
	@RequestMapping(value = "/admin_board_list.do", method = RequestMethod.GET)
	public ModelAndView admin_board_list(String page) {
		ModelAndView model = new ModelAndView();
		// BoardDao boardDao = new BoardDao();

		// ����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5; // ���������� �Խù� ��
		int reqPage = 1; // ��û������
		int pageCount = 1; // ��ü ������ ��
//		int dbCount = boardService.getTotalRowCount();	//DB���� ������ ��ü ���

		// �� ������ �� ���
//		if(dbCount % pageSize == 0){
//			pageCount = dbCount/pageSize;
//		}else{
//			pageCount = dbCount/pageSize+1;
//		}

		// ��û ������ ���
		if (page != null) {
			reqPage = Integer.parseInt(page);
			startCount = (reqPage - 1) * pageSize + 1;
			endCount = reqPage * pageSize;
		} else {
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
	@RequestMapping(value = "/admin_member_list.do", method = RequestMethod.GET)
	public ModelAndView admin_member_list(String page) {
		ModelAndView model = new ModelAndView();

		// 페이징 처리 - startCount, endCount 구하기
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5; // 한 페이지 당 게시물 수
		int reqPage = 1; // 요청 페이지
		int pageCount = 1; // 전체 페이지 수
		int dbCount = memberService.getTotalRowCount(); // DB에서 가져온 전체 행 수

		// 총 페이지 수 계산
		if (dbCount % pageSize == 0) {
			pageCount = dbCount / pageSize;
		} else {
			pageCount = dbCount / pageSize + 1;
		}

		// 요청 페이지 계산
		if (page != null) {
			reqPage = Integer.parseInt(page);
			startCount = (reqPage - 1) * pageSize + 1;
			endCount = reqPage * pageSize;
		} else {
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
	@RequestMapping(value = "/admin_notice_delete_proc.do", method = RequestMethod.POST)
	public ModelAndView admin_notice_delete_proc(String nid) {
		ModelAndView model = new ModelAndView();
		int result = noticeService.getDelete(nid);
		if (result == 1) {
			model.setViewName("redirect:/admin_notice_list.do");
		}
		return model;
	}

	/*
	 * admin_notice_delete - 공지사항 삭제
	 */
	@RequestMapping(value = "/admin_notice_delete.do", method = RequestMethod.GET)
	public ModelAndView admin_notice_delete(String nid) {
		ModelAndView model = new ModelAndView();
		model.addObject("nid", nid);
		model.setViewName("/admin/notice/admin_notice_delete");

		return model;
	}

	/*
	 * admin_notice_write_proc.do - 공지사항 등록 처리
	 */
	@RequestMapping(value = "/admin_notice_write_proc.do", method = RequestMethod.POST)
	public String admin_notice_write_proc(NoticeVo noticeVo, HttpServletRequest request) throws Exception {
		String viewName = "";

		// nfile, nsfile
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";

		if (noticeVo.getFile1().getOriginalFilename() != null
				&& !noticeVo.getFile1().getOriginalFilename().equals("")) {

			UUID uuid = UUID.randomUUID();
			String nfile = noticeVo.getFile1().getOriginalFilename();
			String nsfile = uuid + "_" + nfile;

			System.out.println(root_path + attach_path);
			System.out.println("nfile--->" + nfile);
			System.out.println("nsfile--->" + nsfile);

			noticeVo.setNfile(nfile);
			noticeVo.setNsfile(nsfile);
		} else {
			System.out.println("없는 파일 입니다.");
		}

		int result = noticeService.getInsert(noticeVo);
		if (result == 1) {

			File saveFile = new File(root_path + attach_path + noticeVo.getNsfile());
			noticeVo.getFile1().transferTo(saveFile);

			viewName = "redirect:/admin_notice_list.do";
		} else {

		}
		return viewName;
	}

	/*
	 * admin_notice_write - 공지사항 등록
	 */
	@RequestMapping(value = "/admin_notice_write.do", method = RequestMethod.GET)
	public String admin_notice_write() {
		return "/admin/notice/admin_notice_write";
	}

	/*
	 * admin_notice_update_proc.do - 공지사항 수정 처리
	 */
	@RequestMapping(value = "/admin_notice_update_proc.do", method = RequestMethod.POST)
	public ModelAndView admin_notice_update_proc(NoticeVo noticeVo) {
		ModelAndView model = new ModelAndView();
		int result = noticeService.getUpdate(noticeVo);

		if (result == 1) {
			model.setViewName("redirect:/admin_notice_list.do");
		} else {

		}
		return model;
	}

	/*
	 * admin_notice_update.do - 공지사항 수정
	 */
	@RequestMapping(value = "/admin_notice_update.do", method = RequestMethod.GET)
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
	@RequestMapping(value = "/admin_notice_content.do", method = RequestMethod.GET)
	public ModelAndView admin_notice_content(String nid) {
		ModelAndView model = new ModelAndView();
		NoticeVo noticeVo = noticeService.getSelect(nid);
		if (noticeVo != null) {
			noticeService.getUpdateHits(nid);
		}
		model.addObject("noticeVo", noticeVo);
		model.setViewName("/admin/notice/admin_notice_content");
		return model;
	}

	/*
	 * admin_index.do - 관리자 메인 페이지
	 */
	@RequestMapping(value = "/admin_index.do", method = RequestMethod.GET)
	public String admin_index() {
		return "admin/admin_index";
	}
	
	/*
	 * admin_notice_list -> notice search
	 */
	@RequestMapping(value="/admin_notice_search_json_data.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String admin_notice_search_json_data(String ntitle, String page) {
		
		Map<String, Integer> param = pageService.getPageResult(page, "noticeSearch", noticeService, ntitle);
		ArrayList<NoticeVo> list = noticeService.getN_select(param.get("startCount"), param.get("endCount"), ntitle);
		
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();
		
		for(NoticeVo noticeVo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("rno", noticeVo.getRno());
			jobj.addProperty("nid", noticeVo.getNid());
			jobj.addProperty("ntitle", noticeVo.getNtitle());
			jobj.addProperty("nhits", noticeVo.getNhits());
			jobj.addProperty("ndate", noticeVo.getNdate());
			
			jarray.add(jobj);
		}
		
		jlist.add("jlist", jarray);
		jlist.addProperty("totals", param.get("totals"));
		jlist.addProperty("pageSize", param.get("pageSize"));
		jlist.addProperty("maxSize", param.get("maxSize"));
		jlist.addProperty("page", param.get("page"));
		
		return new Gson().toJson(jlist);
	
	}
	
	

	/*
	 * admin_notice__list_json_data.do
	 */
	@RequestMapping(value = "/admin_notice_list.do", method = RequestMethod.GET)
	public String admin_notice_list() {

		return "/admin/notice/admin_notice_list";
	}

	/*
	 * admin_notice_list.do - change into Json
	 */
	@RequestMapping(value = "/admin_notice_list_json_data.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String admin_notice_list_json_data(String page) {
		Map<String, Integer> param = pageService.getPageResult(page, "notice");
		ArrayList<NoticeVo> list = noticeService.getSelect(param.get("startCount"), param.get("endCount"));

		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();

		for (NoticeVo noticeVo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("rno", noticeVo.getRno());
			jobj.addProperty("nid", noticeVo.getNid());
			jobj.addProperty("ntitle", noticeVo.getNtitle());
			jobj.addProperty("nhits", noticeVo.getNhits());
			jobj.addProperty("ndate", noticeVo.getNdate());

			jarray.add(jobj);
		}

		jlist.add("jlist", jarray);
		jlist.addProperty("totals", param.get("totals"));
		jlist.addProperty("pageSize", param.get("pageSize"));
		jlist.addProperty("maxSize", param.get("maxSize"));
		jlist.addProperty("page", param.get("page"));

		return new Gson().toJson(jlist);
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
