package com.gga.service;

import com.gga.vo.OrderVo;

public interface OrderService {

	
	public void getSeatPrice(String seat, int price, String oid);
	public int insertOrderVo(OrderVo orderVo);
	public String getOid();
	
}
