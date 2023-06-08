package com.gga.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gga.service.OrderService;
import com.gga.vo.OrderVo;
import com.gga.vo.OrderconVo;
import com.gga.vo.SeatVo;

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
	public String seatProc(String seat, String price, String oid) {
		//좌석이 가능한지 확인하기
		int realresult = 0;
		int result = orderService.searchSeat(seat);
		if(result ==1) {
			//좌석이 가능하면 넘기기
			orderService.getSeatPrice(seat, price, oid);
			realresult = 1;
			
		}else {
			//좌석이 불가능함
			System.out.println("ordercontroller 좌석 불가능함");
			realresult = 0;
		}
		return String.valueOf(realresult);

	}
//	/**
//	 *	getSeatproc.do 
//	 */
//	@RequestMapping(value="/getSeatProc.do", method=RequestMethod.POST)
//	@ResponseBody
//	public ModelAndView getSeat(){
//		ModelAndView model = new ModelAndView();
//		ArrayList<SeatVo> list = new ArrayList<SeatVo>();
//		list = orderService.getSeat();
//		model.addObject("list",list);
//		model.setViewName("/order/seat");
//		return model;
//	}
	
	/**
	 *	ordercon.do 
	 */
	@RequestMapping(value="/ordercon.do", method=RequestMethod.GET)
	public ModelAndView ordercon(String merchantuid) {
		ModelAndView model = new ModelAndView();
		OrderconVo orderconVo = new OrderconVo();
		orderconVo = orderService.selectOrdercon(merchantuid);
		int result = orderService.updateseatstatus(orderconVo.getSeat());
		if(result == 0) {
			System.out.println("오류가 발생했습니다.");
		}else if(result==1) {
			System.out.println("정상적으로 업데이트 됐습니다.");
		}
		model.addObject("orderconVo", orderconVo);
		model.setViewName("/order/ordercon");
		
		return model;
	}
	/**
	 *	seat.do 
	 */

	  @RequestMapping(value="/seat.do", method=RequestMethod.GET) 
	  public String seat() { 
		  return "/order/seat"; }

	/**
	 *	orderProc.do 
	 */
	@RequestMapping(value="/orderProc.do", method=RequestMethod.POST)
	public ModelAndView orderProc(OrderVo orderVo) {
		ModelAndView model = new ModelAndView();
		
		int result = orderService.insertOrderVo(orderVo);
		ArrayList<SeatVo> list = new ArrayList<SeatVo>();
		list = orderService.getSeat();
		String oid = orderVo.getOid();
		if(result ==1){
			model.addObject("list",list);
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
