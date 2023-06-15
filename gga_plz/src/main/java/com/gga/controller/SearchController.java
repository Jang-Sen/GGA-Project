package com.gga.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gga.service.SearchService;
import com.gga.vo.IndexSearchVo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	/*
	 *  firstSearch.do - 첫검색
	 */
//	@RequestMapping(value="/firstSearch.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
//	public String firstSearch(String firstSearch) {
//		String firstJson = indexSearch_json_data(firstSearch);
//		return firstJson;
//	}
	/*
	 *  indexSearch.jsp - 통합검색
	 */
	@RequestMapping(value="/indexSearch.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public ModelAndView indexSearch(String firstSearch) {
		ModelAndView model = new ModelAndView();
		model.addObject("firstSearch", firstSearch);
		model.setViewName("/indexSearch");
		
		return model;
	}
	
	
	
	/**
	 * header.jsp -> 검색 창 json_data
	 */
	@RequestMapping(value="/indexSearch_json_data.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String indexSearch_json_data(String searchContent) {
		ArrayList<IndexSearchVo> mlist = searchService.getMovieSearch(searchContent);
		ArrayList<IndexSearchVo> nlist = searchService.getNoticeSearch(searchContent);
		ArrayList<IndexSearchVo> blist = searchService.getBoardSearch(searchContent);
		ArrayList<IndexSearchVo> plist = searchService.getProductSearch(searchContent);
		
		JsonObject jlist = new JsonObject();
		JsonArray marray = new JsonArray();
		JsonArray narray = new JsonArray();
		JsonArray barray = new JsonArray();
		JsonArray parray = new JsonArray();
		
		for(IndexSearchVo isVo : mlist) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("mrno", isVo.getMrno());
			jobj.addProperty("movieId", isVo.getMovieId());
			jobj.addProperty("movieTitle", isVo.getMovieTitle());
			jobj.addProperty("mainPoster", isVo.getMainPoster());
			jobj.addProperty("genre", isVo.getGenre());
			marray.add(jobj);
		}
		for(IndexSearchVo isVo : nlist) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("nrno", isVo.getNrno());
			jobj.addProperty("nid", isVo.getNid());
			jobj.addProperty("ntitle", isVo.getNtitle());
			jobj.addProperty("nhits", isVo.getNhits());
			jobj.addProperty("ndate", isVo.getNdate());
			narray.add(jobj);
		}
		for(IndexSearchVo isVo : blist) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("brno", isVo.getBrno());
			jobj.addProperty("bid", isVo.getBid());
			jobj.addProperty("btitle", isVo.getBtitle());
			jobj.addProperty("bhits", isVo.getBhits());
			jobj.addProperty("movieName", isVo.getMovieName());
			jobj.addProperty("mid", isVo.getMid());
			jobj.addProperty("bdate", isVo.getBdate());
			barray.add(jobj);
		}
		for(IndexSearchVo isVo : plist) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("prno", isVo.getPrno());
			jobj.addProperty("pid", isVo.getPid());
			jobj.addProperty("pname", isVo.getPname());
			jobj.addProperty("pfile", isVo.getPfile());
			parray.add(jobj);
		}
		jlist.add("mlist", marray);
		jlist.add("nlist", narray);
		jlist.add("blist", barray);
		jlist.add("plist", parray);
		
		return new Gson().toJson(jlist);
	}
	
	
}
