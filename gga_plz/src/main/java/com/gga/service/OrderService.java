package com.gga.service;

import com.gga.vo.OrderVo;
import com.gga.vo.OrderconVo;

public interface OrderService {

	
	public void getSeatPrice(String seat, int price, String oid);
	public int insertOrderVo(OrderVo orderVo);
	public String getOid();
	public void getimp(String impuid, String merchantuid, String pgtype, String oid);
	public OrderconVo selectOrdercon(String merchantuid);
	
}
