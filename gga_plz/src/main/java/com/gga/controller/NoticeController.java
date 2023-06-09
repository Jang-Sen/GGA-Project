package com.gga.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gga.service.NoticeService;
import com.gga.service.PageServiceImpl;
import com.gga.vo.NoticeVo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class NoticeController {
	
	@Autowired
	private PageServiceImpl pageService;
	
	@Autowired
	private NoticeService noticeService;
	
	/*
	 * notice_list -> notice search
	 */
	@RequestMapping(value="/notice_search_json_data.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String notice_search_json_data(String ntitle, String page) {
		
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
	 * notice_list_json_data.do
	 */
	@RequestMapping(value="/notice_list.do", method = RequestMethod.GET)
	public String notice_list() {
		
		return "/notice/notice_list";
	}
	
	
	/*
	 * notice_list.do - change into JSON 
	 */
	@RequestMapping(value = "/notice_list_json_data.do", method = RequestMethod.GET,
			produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String notice_list_json_data(String page) {
		Map<String, Integer> param = pageService.getPageResult(page, "notice");
		ArrayList<NoticeVo> list
			= noticeService.getSelect(param.get("startCount"), param.get("endCount"));
		
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
