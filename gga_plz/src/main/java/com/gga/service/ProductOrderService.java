package com.gga.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gga.vo.ProductOrderVo;

public interface ProductOrderService {
	int getInsert(List<Map<String, String>> paramList);
	ArrayList<ProductOrderVo> getList();
	int getDelete();
	int getNowInsert(Map<String, String> param);
	ArrayList<ProductOrderVo> selectProductOrderMypage(String id);
}