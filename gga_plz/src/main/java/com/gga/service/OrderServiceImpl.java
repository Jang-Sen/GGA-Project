package com.gga.service;

import java.util.ArrayList;

import com.gga.dao.OrderDao;
import com.gga.vo.OrderVo;
import com.gga.vo.OrderconVo;
import com.gga.vo.SeatVo;

public class OrderServiceImpl implements OrderService {
	OrderDao orderDao = new OrderDao();
	
	public void getSeatPrice(String seat, String price, String oid) {
		orderDao.insert(seat, price, oid);
	}
	public OrderconVo selectOrderconlist(String oconid) {
	return orderDao.selectOrderconlist(oconid);
	};
	public void deleteOrdercon(String oconid) {
		orderDao.deleteOrdercon(oconid);
	}
	public int resetSeat(String seat) {
		return orderDao.resetSeat(seat);
		
	}
	public int updateseatstatus(String seat) {

		return orderDao.updateseatstatus(seat);
	}

	
	public int insertOrderVo(OrderVo orderVo) {
		return orderDao.insert(orderVo);
	}
	public String getOid() {
		return orderDao.getOid();
	}
	public OrderVo select(String oid) {
		return orderDao.select(oid);
	}
	public ArrayList<OrderconVo> selectOrdercon(){
		return orderDao.selectOrdercon();
	};
	
	public OrderconVo selectOrdercon(String merchantuid) {
	return orderDao.selectOrdercon(merchantuid);
	};
	
	public void getimp(String impuid, String merchantuid, String pgtype, OrderVo orderVo) {
		orderDao.insert(impuid, merchantuid, pgtype, orderVo);
	}
	public int searchSeat(String seat) {
		return orderDao.searchSeat(seat);
	}
	public ArrayList<SeatVo> getSeat(){
		return orderDao.getSeat();
	}
	
	
}
