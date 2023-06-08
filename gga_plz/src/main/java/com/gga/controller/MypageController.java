package com.gga.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gga.service.OrderService;
import com.gga.service.ProductOrderService;
import com.gga.vo.BoardVo;
import com.gga.vo.OrderconVo;
import com.gga.vo.ProductOrderVo;
import com.gga.vo.SessionVo;

@Controller
public class MypageController {
	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductOrderService productOrderService;
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
	public ModelAndView mypage(BoardVo boardVo, HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) {
		HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		ModelAndView model = new ModelAndView();
		ArrayList<OrderconVo> list = new ArrayList<OrderconVo>();
		ArrayList<ProductOrderVo> polist = new ArrayList<ProductOrderVo>();
		if(svo != null) {
		list = orderService.selectOrderconMypage(svo);
		polist = productOrderService.selectProductOrderMypage(svo.getId());
		model.addObject("ticketlist", list);
		model.addObject("polist", polist);
		}
		model.setViewName("/mypage/mypage");
		
		
		return model;
	}
	/**
	 *	mypage_allticekt.do
	 */
	@RequestMapping(value="/mypage_allticket.do", method=RequestMethod.GET)
	public ModelAndView mypage_allticket(BoardVo boardVo,HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		ArrayList<OrderconVo> list = new ArrayList<OrderconVo>();
		if(svo != null) {
		list = orderService.selectOrderconMypage(svo);
		model.addObject("ticketlist", list);
		}
		model.setViewName("/mypage/mypage_allticket");
		
		return model;
	}
	
	

}
