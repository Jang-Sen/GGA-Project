package com.gga.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gga.service.ProductOrderService;
import com.gga.vo.ProductOrderVo;
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
	public String product_order_proc(@RequestBody String data) {
	    System.out.println(data);
	    Gson gson = new Gson();
	    String uuid = UUID.randomUUID().toString();

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
	        param.put("pid", pidArray.get(i).getAsString());
	        param.put("cid", cidArray.get(i).getAsString());
	        param.put("pname", pnameArray.get(i).getAsString());
	        param.put("pprice", ppriceArray.get(i).getAsString());
	        param.put("qty", qtyArray.get(i).getAsString());
	        param.put("pfile", pfileArray.get(i).getAsString());
	        paramList.add(param);
	    }

	    System.out.println(paramList);
	    return String.valueOf(productOrderService.getInsert(paramList));
	}




	/*
	@RequestMapping(value = "/product_order_proc.do", method = RequestMethod.GET)

	@ResponseBody
	public String product_order_proc(String cid, String pid, String pname, String pprice, String qty) {
		List<String> pidList = Arrays.asList(pid.split(","));
		List<String> cidList = Arrays.asList(cid.split(","));
		List<String> pnameList = Arrays.asList(pname.split(","));
		List<String> ppriceList = Arrays.asList(pprice.split(","));
		List<String> qtyList = Arrays.asList(qty.split(","));
		System.out.println(cidList);

		List<Map<String, String>> paramList = new ArrayList<>();

		String uuid = UUID.randomUUID().toString();

		if (pidList.size() == cidList.size()) {
			for (int i = 0; i < pidList.size(); i++) {
				Map<String, String> param = new HashMap<>();
				param.put("poid", uuid);
				param.put("pid", pidList.get(i));
				param.put("cid", cidList.get(i));
				param.put("pname", pnameList.get(i));
				param.put("pprice", ppriceList.get(i));
				param.put("qty", qtyList.get(i));
				paramList.add(param);
			}
		} else { // Handleerror: pid와 cid의 개수가 다를 경우 예외 처리

		}

		System.out.println(paramList);
		return String.valueOf(productOrderService.getInsert(paramList));
	}
	*/
	@RequestMapping(value = "/productordercon.do", method = RequestMethod.GET)
	public ModelAndView productordercon() {
		ModelAndView model = new ModelAndView();

		List<ProductOrderVo> list = productOrderService.getList();

		model.addObject("list", list);
		model.setViewName("/store/productordercon");

		return model;
	}
}
