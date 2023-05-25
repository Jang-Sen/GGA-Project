package com.gga.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gga.service.NoticeService;
import com.gga.vo.NoticeVo;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	/*
	 * notice_list -> �������� �Խñ� ���� �˻�
	 */
	@RequestMapping(value="/Searchnoticeproc.do", method=RequestMethod.GET)
	@ResponseBody
	public String Searchnoticeproc(String ntitle) {
		//NoticeDao noticeDao = new NoticeDao();
		NoticeVo noticeVo = noticeService.getN_select(ntitle);
		
		return noticeVo.getNid();
	}
	
	
	
	
	
	
	

	/*
	 * notice_list.do - �������� ��ü ����Ʈ(����¡ ó��)
	 */
	@RequestMapping(value = "/notice_list.do", method = RequestMethod.GET)
	public ModelAndView notice_list(String page) {
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

		model.setViewName("/notice/notice_list");

		return model;
	}

	/**
	 * notice_list.do
	 */
	/*
	 * @RequestMapping(value="/notice_list.do", method=RequestMethod.GET) public
	 * ModelAndView notice_list() { ModelAndView model = new ModelAndView();
	 * NoticeDao noticeDao = new NoticeDao();
	 * 
	 * ArrayList<NoticeVo> list = noticeDao.select(); model.addObject("list", list);
	 * model.setViewName("notice/notice_list");
	 * 
	 * return model; }
	 */
		 

	/*
	 * notice_content.do
	 */
	@RequestMapping(value = "/notice_content.do", method = RequestMethod.GET)
	public ModelAndView notice_content(String nid) {
		ModelAndView model = new ModelAndView();
		NoticeVo noticeVo = noticeService.getSelect(nid);
		if(noticeVo != null) {
			noticeService.getUpdateHits(nid);
		}
		model.addObject("noticeVo", noticeVo);
		model.setViewName("notice/notice_content");
		return model;
	}
}
