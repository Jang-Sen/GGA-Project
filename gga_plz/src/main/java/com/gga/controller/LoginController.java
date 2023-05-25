package com.gga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gga.dao.MemberDao;
import com.gga.vo.MemberVo;

@Controller
public class LoginController {
	/**
	 * login.do
	 */
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "/login/login";
	}
	
	/**
	 * login_fail.do
	 */
	@RequestMapping(value="/login_fail.do", method=RequestMethod.GET)
	public String login_fail() {
		return "/login/login_fail";
	}
	
	/**
	 * loginProc - 로그인하기 버튼
	 */
	@RequestMapping(value="/loginProc.do", method=RequestMethod.POST)
	public ModelAndView loginProc(MemberVo memberVo) {
		ModelAndView model = new ModelAndView();
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.loginCheck(memberVo);
		
		if(result ==1) {
			model.addObject("loginResult", "ok");
			model.setViewName("index");
		} else {
			model.setViewName("redirect:/login_fail.do");
		}
		
		return model; 
	}
}
