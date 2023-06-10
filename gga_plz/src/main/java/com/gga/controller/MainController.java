package com.gga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gga.service.MovieService;
import com.gga.vo.MovieVo;

@Controller
public class MainController {
	
	@Autowired
	private MovieService movieService;
	/**
	 * header.jsp -> ��ȭ ���� �˻�
	 */
	@RequestMapping(value="/searchproc.do", method=RequestMethod.GET)
	@ResponseBody
	public String searchproc(String movietitle) {
		MovieVo movieVo = movieService.getMovieSearchSelect(movietitle);
		return movieVo.getMovieid();
	}
	/**
	 * index.do
	 */
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	/**
	 * footer.do
	 */
	@RequestMapping(value="/footer.do", method=RequestMethod.GET)
	public String footer() {
		return "footer";
	}
	/**
	 * header.do
	 */
	@RequestMapping(value="/header.do", method=RequestMethod.GET)
	public String header() {
		return "header";
	}
	/**
	 * error.do
	 */
	
	@RequestMapping(value="/error.do", method=RequestMethod.GET)
	public String error() {
		return "errorpage";
	}
	
}
