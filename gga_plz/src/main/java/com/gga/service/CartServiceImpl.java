package com.gga.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gga.dao.CartDao;
import com.gga.vo.CartVo;

@Service("CartService")
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cartDao;
	
	@Override
	public int getInsert(String pid) {
		return cartDao.insert(pid);
	}
	@Override
	public int getDelete(String pid) {
		return cartDao.delete(pid);
	}

	@Override
	public ArrayList<CartVo> getList() {
		ArrayList<CartVo> clist = new ArrayList<CartVo>();
		
		List<Object> list = cartDao.select();
		
		for(Object obj : list) {
			CartVo cartVo = (CartVo)obj;
			
			clist.add(cartVo);
		}
		return clist;
	}

	@Override
	public int getUpdate(int qty, String pid) {
		return cartDao.update(qty, pid);
	}

}
