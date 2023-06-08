package com.gga.service;

import java.util.ArrayList;

import com.gga.vo.CartVo;

public interface CartService {
	public int getInsert(String pid, String id);
	public int getUpdate(int qty, String pid);
	public ArrayList<CartVo> getList(String id);
	public int getDelete(String pid);
}