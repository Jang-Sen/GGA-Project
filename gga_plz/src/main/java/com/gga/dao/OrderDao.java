package com.gga.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gga.vo.OrderVo;
import com.gga.vo.OrderconVo;
import com.gga.vo.SeatVo;

@Repository
public class OrderDao extends DBConn{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public ArrayList<SeatVo> getSeat(){
		List<SeatVo> list = sqlSession.selectList("mapper.order.seatlist");
		return (ArrayList<SeatVo>)list;
	}
	
	public int resetSeat(String seat) {
		String[] seatList = seat.split(",");
		String sql = "";
		int result = 0;
		for(int i=0;i<seatList.length;i++) {
			sql = "update gga_seat set status = 'seat' where snumber=?";
			getPreparedStatement(sql);
			try {
				pstmt.setString(1, seatList[i]);
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	public void deleteOrdercon(String oconid) {
		sqlSession.delete("mapper.order.deleteorder", oconid);
		
	}
	
	public OrderconVo selectOrderconlist(String oconid) {
		return (OrderconVo)sqlSession.selectOne("mapper.order.orderconlist", oconid);
	}
	
	
	public OrderconVo selectOrdercon(String merchantuid) {
		return (OrderconVo)sqlSession.selectOne("mapper.order.orderconlistfrommid", merchantuid);
	}
	
	
	public ArrayList<OrderconVo> selectOrdercon() {
		List<OrderconVo> list = sqlSession.selectList("mapper.order.selectordercon");
		
		return (ArrayList<OrderconVo>)list;
	}
	public ArrayList<OrderconVo> selectOrderconMypage(String id) {
		List<OrderconVo> list = sqlSession.selectList("mapper.order.selectorderconmypage",id);
		
		return (ArrayList<OrderconVo>)list;
	}
	
	
	//추후에 아이디 추가
	public void insert(String impuid, String merchantuid, String pgtype, OrderVo orderVo) {
		Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("movieid", orderVo.getMovieid());
	    paramMap.put("movieordertitle", orderVo.getMovieordertitle());
	    paramMap.put("price", orderVo.getPrice());
	    paramMap.put("seat", orderVo.getSeat());
	    paramMap.put("otime", orderVo.getOtime());
	    paramMap.put("odate", orderVo.getOdate());
	    paramMap.put("oname", orderVo.getOname());
	    paramMap.put("ocarnum", orderVo.getOcarnum());
	    paramMap.put("oemail", orderVo.getOemail());
	    paramMap.put("ophone", orderVo.getOphone());
	    paramMap.put("orderdate", orderVo.getOrderdate());
	    paramMap.put("impuid", impuid);
	    paramMap.put("merchantuid", merchantuid);
	    paramMap.put("pgtype", pgtype);
	    paramMap.put("movieorderposter", orderVo.getMovieorderposter());
	    paramMap.put("id", orderVo.getId());
	    
			
		sqlSession.insert("mapper.order.insertocon", paramMap);
	
	}
	
	public int updateseatstatus(String seat) {
		String[] seatList = seat.split(",");
		String sql = "";
		int result = 0;
		for(int i=0;i<seatList.length;i++) {
			sql = "update gga_seat set status = 'seat occupied' where snumber=?";
			getPreparedStatement(sql);
			try {
				pstmt.setString(1, seatList[i]);
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	public OrderVo select(String oid) {
		
		return (OrderVo)sqlSession.selectOne("mapper.order.selectordervo", oid);

	}
	public int searchSeat(String seat) {
		int result = 0;
		String[] seatList = seat.split(",");
		// 각 좌석 번호를 하나씩 가져와서 비교
		for (String seatNumber : seatList) {
		    // 해당 좌석 번호와 비교하여 일치하는 좌석을 찾는 쿼리 작성
		    String sql = "select sid, snumber, status from gga_seat where snumber =?";

		    getPreparedStatement(sql);
		    
		    try {
		    pstmt.setString(1, seatNumber);
		    rs = pstmt.executeQuery();

		    if (rs.next()) {
		        String seatStatus = rs.getString(3);
		        
		        if ("seat".equals(seatStatus)) {
		          result =1;
		        } else {
		        	//좌석이 사용 불가능한 경우
		            result=0;
		            break;
		        }
		    } else {
		        // 일치하는 좌석을 찾지 못했을 때의 처리 로직
		    	System.out.println("좌석을 찾지 못했습니다.");
		    	break;
		    }
		    
		    // ResultSet, PreparedStatement 닫기
		    rs.close();
		    pstmt.close();
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		}

		return result;
	}
	
	
	public int insert(String seat, String price, String oid) {
		
		Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("seat", seat);
	    paramMap.put("price", price);
	    paramMap.put("oid", oid);
	
		return sqlSession.insert("mapper.order.insertpriceseat", paramMap);
	}
	
	public String getOid() {
		String result="";
		String sql="select 'o_'||ltrim(to_char(sysdate,'yymmdd'))||ltrim(to_char(sequ_gga_order_oid.nextval,'0000')) oid from dual";
		getPreparedStatement(sql);
		try {
			rs= pstmt.executeQuery();
			while(rs.next()) {
				
				result = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int insert(OrderVo orderVo) {
		
		return sqlSession.insert("mapper.order.insertOrder", orderVo);
		
	}

}
