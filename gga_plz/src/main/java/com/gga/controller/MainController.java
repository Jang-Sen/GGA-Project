package com.gga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
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
