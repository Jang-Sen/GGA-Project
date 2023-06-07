package com.gga.service;

import java.util.ArrayList;

import com.gga.vo.ProductVo;

public interface ProductService {
	ArrayList<ProductVo> getList();
	ProductVo getSelect(String pid);
	int getUpdate(ProductVo productVo);
	int getInsert(ProductVo productVo);
	int getDelete(String pid);
}
