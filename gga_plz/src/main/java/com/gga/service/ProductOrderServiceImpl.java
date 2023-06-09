package com.gga.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gga.dao.ProductOrderDao;
import com.gga.vo.ProductOrderVo;

@Service
public class ProductOrderServiceImpl implements ProductOrderService{

	@Autowired
	private ProductOrderDao productOrderDao;

	@Override
	public int getInsert(List<Map<String, String>> paramList) {
		return productOrderDao.insert(paramList);
	}

	@Override
	public ArrayList<ProductOrderVo> getList() {
		return productOrderDao.select();
	}

	@Override
	public int getDelete() {
		return productOrderDao.delete();
	}

	@Override
	public int getNowInsert(Map<String, String> param) {
		return productOrderDao.insert(param);
	}

	@Override
	public ArrayList<ProductOrderVo> selectProductOrderMypage(String id) {
		ArrayList<ProductOrderVo> plist = new ArrayList<ProductOrderVo>();
		
		List<Object> list = productOrderDao.select(id);
		
		for(Object obj : list) {
			ProductOrderVo productOrderVo = (ProductOrderVo) obj;
			
			plist.add(productOrderVo);
		}
		return plist;
	}


}
