package com.gga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gga.service.OrderService;
import com.gga.vo.OrderVo;
import com.gga.vo.OrderconVo;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	/**
	 *	orderconProc.do 
	 */
	@RequestMapping(value="/orderconProc.do", method=RequestMethod.POST)
	@ResponseBody
	public void orderconProc(String impuid, String merchantuid, String pgtype, String oid) {

		OrderVo orderVo = orderService.select(oid);
		orderService.getimp(impuid, merchantuid, pgtype,orderVo);

	}

	/**
	 *	seatProc.do 
	 */
	@RequestMapping(value="/seatProc.do", method=RequestMethod.POST)
	@ResponseBody
	public void seatProc(String seat, String price, String oid) {
		
		orderService.getSeatPrice(seat, price, oid);
	}
	/**
	 *	ordercon.do 
	 */
	@RequestMapping(value="/ordercon.do", method=RequestMethod.GET)
	public ModelAndView ordercon(String merchantuid) {
		ModelAndView model = new ModelAndView();
		OrderconVo orderconVo = new OrderconVo();
		orderconVo = orderService.selectOrdercon(merchantuid);
		model.addObject("orderconVo", orderconVo);
		model.setViewName("/order/ordercon");
		
		return model;
	}
	/**
	 *	seat.do 
	 */
	@RequestMapping(value="/seat.do", method=RequestMethod.GET)
	public String seat() {
		return "/order/seat";
	}
	/**
	 *	orderProc.do 
	 */
	@RequestMapping(value="/orderProc.do", method=RequestMethod.POST)
	public ModelAndView orderProc(OrderVo orderVo) {
		ModelAndView model = new ModelAndView();
		
		int result = orderService.insertOrderVo(orderVo);
		String oid = orderVo.getOid();
		if(result ==1){
			model.addObject("oid", oid);
			model.setViewName("/order/seat");
			/*out.write("location.href ='http://localhost:9000/gga_plz/order/seat.jsp?oid="+oid+"'");*/
		}
		
		return model;
	}
	/**
	 *	order.do 
	 */
	@RequestMapping(value="/order.do", method=RequestMethod.GET)
	public String order() {
		return "/order/order";
	}
	
	/**
	 * oidProc.do - header���� ���Ŵ����� �� oid�� ���� 
	 */
	@RequestMapping(value="/oidProc.do", method=RequestMethod.GET)
	@ResponseBody
	public String oidProc() {
		return orderService.getOid();
	}
}
