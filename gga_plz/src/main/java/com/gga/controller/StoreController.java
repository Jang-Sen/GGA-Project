package com.gga.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gga.vo.SessionVo;

@Controller
public class StoreController {
	/**
	 *	order.do 
	 */
	@RequestMapping(value="/store.do", method=RequestMethod.GET)
	public String order(HttpServletRequest request) {
		HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		return "/store/store_menu";
	}
	
}
