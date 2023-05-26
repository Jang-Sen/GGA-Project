package com.gga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gga.service.MemberService;
import com.gga.vo.MemberVo;

@Controller
public class JoinController {
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * join.do - 회원가입
	 */
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		return "/join/join";
	}
	
	/**
	 *  idCheckProc 아이디 중복체크
	 */
	@RequestMapping(value="/idCheckProc.do", method=RequestMethod.GET)
	@ResponseBody
	public String idCheckProc(String id) {
		return memberService.getIdCheck(id);
	}
	
	/**
	 * joinProc 회원가입 처리
	 */
	@RequestMapping(value="/joinProc.do", method=RequestMethod.POST)
	public ModelAndView joinProc(MemberVo memberVo) {
		ModelAndView model = new ModelAndView();
		
		int result = memberService.getJoin(memberVo);
		
		if(result == 1) {
			model.addObject("joinResult", "ok");
			model.setViewName("/login/login");
		} else {
			// 에러 메세지
		}
		return model;	
	}
}
