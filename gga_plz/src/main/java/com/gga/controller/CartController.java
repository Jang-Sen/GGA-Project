package com.gga.controller;

import java.util.ArrayList;

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

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/cart_insert_proc.do", method=RequestMethod.GET)
	@ResponseBody
	public String cart_insert_proc(String pid) {
		int result =0;
		result = cartService.getInsert(pid);
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
	public ModelAndView cartModal() {
		ModelAndView model = new ModelAndView();
		ArrayList<CartVo> list = cartService.getList();
		model.addObject("list", list);
		model.setViewName("/store/cartModal");
		return model;
	}
}
