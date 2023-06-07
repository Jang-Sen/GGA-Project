package com.gga.service;

import java.util.ArrayList;

import com.gga.vo.CartVo;

public interface CartService {
	public int getInsert(String pid);
	public int getUpdate(int qty, String pid);
	public ArrayList<CartVo> getList();
	public int getDelete(String pid);
}