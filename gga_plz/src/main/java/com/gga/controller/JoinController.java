package com.gga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gga.dao.MemberDao;
import com.gga.vo.MemberVo;

@Controller
public class JoinController {
	/**
	 * join.do
	 */
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		return "/join/join";
	}
	/**
	 *  idCheckProc 중복검사
	 */
	@RequestMapping(value="/idCheckProc.do", method=RequestMethod.GET)
	@ResponseBody
	public String idCheckProc(String id) {
		MemberDao memberDao = new MemberDao();
		int result = memberDao.idCheck(id);
		
		return String.valueOf(result);
		
	}
	/**
	 * joinProc 가입하기 
	 */
	@RequestMapping(value="/joinProc.do", method=RequestMethod.POST)
	public ModelAndView joinProc(MemberVo memberVo) {
		ModelAndView model = new ModelAndView();
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.insert(memberVo);
		
		if(result == 1) {
			model.addObject("joinResult", "ok");
			model.setViewName("/login/login");
		} else {
			//회원가입 실패시!
		}
		return model;	
	}
}
