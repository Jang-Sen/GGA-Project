package com.gga.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gga.service.ProductOrderService;
import com.gga.vo.ProductOrderVo;
import com.gga.vo.SessionVo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class ProductOrderController {

	@Autowired
	private ProductOrderService productOrderService;

	@RequestMapping(value = "/product_delete_proc.do", method = RequestMethod.GET)
	@ResponseBody
	public String product_delete_proc() {
		return String.valueOf(productOrderService.getDelete());
	}

	@RequestMapping(value = "/product_order_proc.do", method = RequestMethod.POST)
	@ResponseBody
	public String product_order_proc(@RequestBody String data, HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) {
	    Gson gson = new Gson();
	    String uuid = UUID.randomUUID().toString();
	    HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
	    JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
	    JsonArray cidArray = jsonObject.getAsJsonArray("cidArray");
	    JsonArray pidArray = jsonObject.getAsJsonArray("pidArray");
	    JsonArray pnameArray = jsonObject.getAsJsonArray("pnameArray");
	    JsonArray ppriceArray = jsonObject.getAsJsonArray("ppriceArray");
	    JsonArray qtyArray = jsonObject.getAsJsonArray("qtyArray");
	    JsonArray pfileArray = jsonObject.getAsJsonArray("pfileArray");

	    List<Map<String, String>> paramList = new ArrayList<Map<String, String>>();

	    for (int i = 0; i < cidArray.size(); i++) {
	        Map<String, String> param = new HashMap<String, String>();
	        param.put("poid", uuid);
	        param.put("id", svo.getId());
	        param.put("pid", pidArray.get(i).getAsString());
	        param.put("cid", cidArray.get(i).getAsString());
	        param.put("pname", pnameArray.get(i).getAsString());
	        param.put("pprice", ppriceArray.get(i).getAsString());
	        param.put("qty", qtyArray.get(i).getAsString());
	        param.put("pfile", pfileArray.get(i).getAsString());
	        paramList.add(param);
	    }

	    return String.valueOf(productOrderService.getInsert(paramList));
	}

	@RequestMapping(value = "/product_order_proc.do", method = RequestMethod.GET)
	@ResponseBody
	public String product_order_proc(String pprice, String pid, String pname, String pfile, HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) {
		HttpSession session = request.getSession();
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		Map<String, String> param = new HashMap<String, String>();
		String uuid = UUID.randomUUID().toString();
		
		param.put("pprice", pprice);
		param.put("pid", pid);
		param.put("pname", pname);
		param.put("pfile", pfile);
		param.put("poid", uuid);
		param.put("id", svo.getId());
		
		return String.valueOf(productOrderService.getNowInsert(param));
	}

	@RequestMapping(value = "/productordercon.do", method = RequestMethod.GET)
	public ModelAndView productordercon() {
		ModelAndView model = new ModelAndView();

		List<ProductOrderVo> list = productOrderService.getList();

		model.addObject("list", list);
		model.setViewName("/store/productordercon");

		return model;
	}
}
