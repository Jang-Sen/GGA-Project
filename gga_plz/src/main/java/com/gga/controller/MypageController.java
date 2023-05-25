package com.gga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gga.vo.BoardVo;

@Controller
public class MypageController {
	
	/**
	 *	mypage.do
	 */
	@RequestMapping(value="/mypage.do", method=RequestMethod.GET)
	public String mypage(BoardVo boardVo) {
		return "/mypage/mypage";
	}

}
