package com.gga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gga.service.MemberService;
import com.gga.vo.MemberVo;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * login.do - 로그인
	 */
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "/login/login";
	}
	
	/**
	 * login_fail.do - 로그인 실패
	 */
	@RequestMapping(value="/login_fail.do", method=RequestMethod.GET)
	public String login_fail() {
		return "/login/login_fail";
	}
	
	/**
	 * loginProc - 로그인 처리
	 */
	@RequestMapping(value="/loginProc.do", method=RequestMethod.POST)
	public ModelAndView loginProc(MemberVo memberVo) {
		ModelAndView model = new ModelAndView();
		
		int result = memberService.getLogin(memberVo);
		
		if(result ==1) {
			model.addObject("loginResult", "ok");
			model.setViewName("index");
		} else {
			model.setViewName("redirect:/login_fail.do");
		}
		
		return model; 
	}
}
