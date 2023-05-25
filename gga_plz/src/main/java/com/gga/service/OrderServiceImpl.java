package com.gga.service;

import com.gga.dao.OrderDao;
import com.gga.vo.OrderVo;

public class OrderServiceImpl implements OrderService {
	OrderDao orderDao = new OrderDao();
	
	public void getSeatPrice(String seat, int price, String oid) {
		orderDao.insert(seat, price, oid);
	};
	
	public int insertOrderVo(OrderVo orderVo) {
		return orderDao.insert(orderVo);
	};
	public String getOid() {
		return orderDao.getOid();
	};
	
	
}
