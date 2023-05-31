package com.gga.service;

import com.gga.dao.OrderDao;
import com.gga.vo.OrderVo;
import com.gga.vo.OrderconVo;

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
	
	public OrderconVo selectOrdercon(String merchantuid) {
	return orderDao.selectOrdercon(merchantuid);
	};
	
	public void getimp(String impuid, String merchantuid, String pgtype, String oid) {
		orderDao.insert(impuid, merchantuid, pgtype, oid);
	}
	
	
}
