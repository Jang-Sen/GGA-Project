package com.gga.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gga.service.FileServiceImpl;
import com.gga.service.ProductService;
import com.gga.vo.ProductVo;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private FileServiceImpl fileService;
	
	@RequestMapping(value="/admin_product_list.do", method=RequestMethod.GET)
	public ModelAndView admin_product_list(){
		ModelAndView model = new ModelAndView();
		ArrayList<ProductVo> list = productService.getList();
		
		model.addObject("list", list);
		model.setViewName("/admin/product/admin_product_list");
		
		return model;
	}
	
	@RequestMapping(value="/admin_product_content.do", method=RequestMethod.GET)
	public ModelAndView admin_product_content(String pid) {
		ModelAndView model = new ModelAndView();
		ProductVo productVo = productService.getSelect(pid);
		
		model.addObject("productVo", productVo);
		model.setViewName("/admin/product/admin_product_content");
		return model;
	}
	
	@RequestMapping(value="/admin_product_update.do", method=RequestMethod.POST)
	public String admin_product_update(ProductVo productVo, RedirectAttributes redirectAttributes) {
	    String pid = productVo.getPid();
	    productService.getUpdate(productVo);
	    redirectAttributes.addAttribute("pid", pid);
	    redirectAttributes.addFlashAttribute("status", true);
	    return "redirect:/admin_product_content.do";
	}
	
	@RequestMapping(value="/admin_product_update.do", method=RequestMethod.GET)
	public ModelAndView admin_product_update(String pid) {
		ModelAndView model = new ModelAndView();
		ProductVo productVo = productService.getSelect(pid);
		
		model.addObject("productVo", productVo);
		model.setViewName("/admin/product/admin_product_update");
		
		return model;
	}
	
	@RequestMapping(value="/admin_product_register.do", method=RequestMethod.POST)
	public ModelAndView admin_product_register(ProductVo productVo, HttpServletRequest request)
				throws Exception{
		ModelAndView model = new ModelAndView();
		int register_result = productService.getInsert(fileService.fileCheck(productVo));
		if(register_result == 1) {
			if(productVo.getPfile() != null && !productVo.getPfile().equals("")) {
				fileService.fileSave(productVo, request);
			}
		}
		
		model.addObject("register_result", register_result);
		model.setViewName("redirect:/admin_product_list.do");
		
		return model;
	}
	
	@RequestMapping(value="/admin_product_register.do", method=RequestMethod.GET)
	public String admin_product_register() {
		return "/admin/product/admin_product_register";
	}
	
	@RequestMapping(value="/admin_product_delete.do", method=RequestMethod.POST)
	public String admin_product_delete(String pid) {
		productService.getDelete(pid);
		
		return "redirect:/admin_product_list.do";
	}
}
