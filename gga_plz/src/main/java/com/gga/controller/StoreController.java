package com.gga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StoreController {
	/**
	 *	order.do 
	 */
	@RequestMapping(value="/store.do", method=RequestMethod.GET)
	public String order() {
		return "/store/store_menu";
	}
	
}
