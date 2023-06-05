package com.gga.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	/*
	 * login_idFind - 아이디 찾기
	 */
	@RequestMapping(value="/login_idFind.do", method=RequestMethod.GET)
	public String login_idFind() {
		return "/login/login_idFind";
	}
	
	/*
	 * login_idFind_proc
	 */
	@RequestMapping(value="/login_idFind_proc.do", method=RequestMethod.GET)
	@ResponseBody
	public String login_idFind_proc(MemberVo memberVo) {
		return memberService.findId(memberVo);
	}
	
	/*
	 * login_pwFind - 비밀번호 찾기
	 */
	@RequestMapping(value="/login_pwFind.do", method=RequestMethod.GET)
	public String login_pwFind() {
		return "/login/login_pwFind";
	}
	
	/*
	 * login_pwFind_proc 비밀번호 찾기 후 수정
	 */
	@RequestMapping(value="/login_pwFind_proc.do", method=RequestMethod.GET)
	@ResponseBody
	public String login_pwFind_proc(MemberVo memberVo) {
		return memberService.findPw(memberVo);
	}
	
}
