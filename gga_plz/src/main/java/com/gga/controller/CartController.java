package com.gga.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gga.dao.BoardDao;
import com.gga.service.CartService;
import com.gga.vo.BoardVo;
import com.gga.vo.CartVo;
import com.gga.vo.SessionVo;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/cart_insert_proc.do", method=RequestMethod.GET)
	@ResponseBody
	public String cart_insert_proc(String pid, HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) {
		int result =0;
		HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		result = cartService.getInsert(pid, svo.getId());
		return String.valueOf(result);
	}
	@RequestMapping(value="/cart_delete_proc.do", method=RequestMethod.GET)
	@ResponseBody
	public String cart_delete_proc(String pid) {
		int result =0;
		result = cartService.getDelete(pid);
		return String.valueOf(result);
	}
	
	@RequestMapping(value="/cart_order_proc.do",method=RequestMethod.POST)
	public String cart_order_proc(String price) {
		String viewName ="redirect:/store.do";
		return viewName;
	}
	
	@RequestMapping(value="/cartModal.do", method=RequestMethod.GET)
	public ModelAndView cartModal(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		ArrayList<CartVo> list = cartService.getList(svo.getId());
		
		model.addObject("list", list);
		model.setViewName("/store/cartModal");
		return model;
	}
	
	@RequestMapping(value="/cart_update_proc.do", method=RequestMethod.GET)
	@ResponseBody
	public String cart_update_proc(int qty, String pid){
		return String.valueOf(cartService.getUpdate(qty, pid));
	}
}
