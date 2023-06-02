package com.gga.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.gga.dao.CartDao;
import com.gga.vo.CartVo;

@Service
public class CartServiceImpl implements CartService{

	private CartDao cartDao = new CartDao();
	
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
		return cartDao.select();
	}

	@Override
	public int getUpdate(int qty) {
		return cartDao.update(qty);
	}

}
