package com.gga.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gga.service.OrderService;
import com.gga.vo.BoardVo;
import com.gga.vo.OrderconVo;

@Controller
public class MypageController {
	@Autowired
	OrderService orderService;
	
	/**
	 *	mypage_poster_proc.do
	 */
	@RequestMapping(value="/mypage_ticket.do", method=RequestMethod.GET)
	public ModelAndView mypage_ticket(String oconid) {
		ModelAndView model = new ModelAndView();
		OrderconVo orderconVo = orderService.selectOrderconlist(oconid);
		model.addObject("orderconVo", orderconVo);
		model.setViewName("/mypage/mypage_ticket");
		
		return model;
	}
	@RequestMapping(value="/mypage_ticket2.do", method=RequestMethod.GET)
	public ModelAndView mypage_ticket2(String oconid) {
		ModelAndView model = new ModelAndView();
		OrderconVo orderconVo = orderService.selectOrderconlist(oconid);
		model.addObject("orderconVo", orderconVo);
		model.setViewName("/mypage/mypage_ticket2");
		
		return model;
	}
	
	@RequestMapping(value="/mypage_ticket_refund.do", method=RequestMethod.GET)
	public String mypage_ticket_refund(String oconid) {
		OrderconVo orderconVo = orderService.selectOrderconlist(oconid);
		orderService.resetSeat(orderconVo.getSeat());
		orderService.deleteOrdercon(oconid);
		return "/mypage/mypage";

	}
	
	
	
	/**
	 *	mypage.do
	 */
	@RequestMapping(value="/mypage.do", method=RequestMethod.GET)
	public ModelAndView mypage(BoardVo boardVo) {
		ModelAndView model = new ModelAndView();
		ArrayList<OrderconVo> list = new ArrayList<OrderconVo>();
		list = orderService.selectOrdercon();
		model.addObject("ticketlist", list);
		model.setViewName("/mypage/mypage");
		
		
		return model;
	}
	/**
	 *	mypage_allticekt.do
	 */
	@RequestMapping(value="/mypage_allticket.do", method=RequestMethod.GET)
	public ModelAndView mypage_allticket(BoardVo boardVo) {
		ModelAndView model = new ModelAndView();
		ArrayList<OrderconVo> list = new ArrayList<OrderconVo>();
		list = orderService.selectOrdercon();
		model.addObject("ticketlist", list);
		model.setViewName("/mypage/mypage_allticket");
		
		return model;
	}
	
	

}
