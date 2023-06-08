package com.gga.service;

import java.util.ArrayList;

import com.gga.vo.OrderVo;
import com.gga.vo.OrderconVo;
import com.gga.vo.SeatVo;

public interface OrderService {

	
	public void getSeatPrice(String seat, String price, String oid);
	public int insertOrderVo(OrderVo orderVo);
	public String getOid();
	public void getimp(String impuid, String merchantuid, String pgtype, OrderVo orderVo);
	public OrderconVo selectOrdercon(String merchantuid);
	public ArrayList<OrderconVo> selectOrdercon();
	public OrderVo select(String oid);
	public OrderconVo selectOrderconlist(String oconid);
	public void deleteOrdercon(String oconid);
	public int searchSeat(String seat);
	public ArrayList<SeatVo> getSeat();
	public int updateseatstatus(String seat);
	public int resetSeat(String seat);
	
}
