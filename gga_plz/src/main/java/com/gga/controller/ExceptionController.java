package com.gga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExceptionController {
	
	@RequestMapping(value = "/error/{statusCode}", method = RequestMethod.POST)
	public String getErrorPage(@PathVariable String statusCode) {
		return "errorpage";
	}
}
