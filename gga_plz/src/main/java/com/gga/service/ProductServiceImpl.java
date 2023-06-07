package com.gga.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gga.dao.ProductDao;
import com.gga.vo.ProductVo;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public ArrayList<ProductVo> getList() {
		ArrayList<ProductVo> plist = new ArrayList<ProductVo>();
		
		List<Object> list =  productDao.selectAll();
		
		for(Object obj : list) {
			ProductVo productVo = (ProductVo)obj;
			
			plist.add(productVo);
		}
		return plist;
	}

	@Override
	public ProductVo getSelect(String pid) {
		return productDao.select(pid);
	}

	@Override
	public int getUpdate(ProductVo productVo) {
		return productDao.update(productVo);
	}

	@Override
	public int getInsert(ProductVo productVo) {
		return productDao.insert(productVo);
	}

	@Override
	public int getDelete(String pid) {
		return productDao.delete(pid);
	}

	

}
