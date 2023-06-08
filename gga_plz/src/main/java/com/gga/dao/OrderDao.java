package com.gga.dao;

import java.util.ArrayList;

import com.gga.vo.OrderVo;
import com.gga.vo.OrderconVo;
import com.gga.vo.SeatVo;

public class OrderDao extends DBConn{
	
	public ArrayList<SeatVo> getSeat(){
		ArrayList<SeatVo> list = new ArrayList<SeatVo>();
		String sql = "select sid, snumber, status from gga_seat";
		getPreparedStatement(sql);
		try {
			rs=pstmt.executeQuery();
			while(rs.next()) {
				SeatVo seatVo = new SeatVo();
				seatVo.setSid(rs.getString(1));
				seatVo.setSnumber(rs.getString(2));
				seatVo.setStatus(rs.getString(3));
				list.add(seatVo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
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
		String sql = "delete from gga_ordercon "+ 
				" where oconid = ?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1,oconid);
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();		
			}
		
	}
	
	public OrderconVo selectOrderconlist(String oconid) {
		OrderconVo orderconVo = new OrderconVo();
		String sql = "select oconid, movieid, movieordertitle, price,seat, otime, odate," +
				" oname, ocarnum,  oemail, ophone, orderdate, impuid, merchantuid, pgtype, movieorderposter"+
				" from GGA_ordercon where oconid = ?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, oconid);
			rs=pstmt.executeQuery();
			while(rs.next()) {
			orderconVo.setOconid(rs.getString(1));	
			orderconVo.setMovieid(rs.getString(2));
			orderconVo.setMovieordertitle(rs.getString(3));
			orderconVo.setPrice(rs.getInt(4));
			orderconVo.setSeat(rs.getString(5));
			orderconVo.setOtime(rs.getString(6));
			orderconVo.setOdate(rs.getString(7));
			orderconVo.setOname(rs.getString(8));
			orderconVo.setOcarnum(rs.getString(9));
			orderconVo.setOemail(rs.getString(10));
			orderconVo.setOphone(rs.getString(11));
			orderconVo.setOrderdate(rs.getString(12));
			orderconVo.setImpuid(rs.getString(13));
			orderconVo.setMerchantuid(rs.getString(14));
			orderconVo.setPgtype(rs.getString(15));
			orderconVo.setMovieorderposter(rs.getString(16));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return orderconVo;
	}
	
	
	
	public OrderconVo selectOrdercon(String merchantuid) {
		OrderconVo orderconVo = new OrderconVo();
		String sql = "select oconid, movieid, movieordertitle, price,seat, otime, odate," +
				" oname, ocarnum,  oemail, ophone, orderdate, impuid, merchantuid, pgtype, movieorderposter"+
				" from GGA_ordercon where merchantuid = ?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, merchantuid);
			rs=pstmt.executeQuery();
			while(rs.next()) {
			orderconVo.setOconid(rs.getString(1));	
			orderconVo.setMovieid(rs.getString(2));
			orderconVo.setMovieordertitle(rs.getString(3));
			orderconVo.setPrice(rs.getInt(4));
			orderconVo.setSeat(rs.getString(5));
			orderconVo.setOtime(rs.getString(6));
			orderconVo.setOdate(rs.getString(7));
			orderconVo.setOname(rs.getString(8));
			orderconVo.setOcarnum(rs.getString(9));
			orderconVo.setOemail(rs.getString(10));
			orderconVo.setOphone(rs.getString(11));
			orderconVo.setOrderdate(rs.getString(12));
			orderconVo.setImpuid(rs.getString(13));
			orderconVo.setMerchantuid(rs.getString(14));
			orderconVo.setPgtype(rs.getString(15));
			orderconVo.setMovieorderposter(rs.getString(16));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return orderconVo;
	}
	public ArrayList<OrderconVo> selectOrdercon() {
		ArrayList<OrderconVo> list = new ArrayList<OrderconVo>();
		String sql = "select oconid, movieid, movieordertitle, price,seat, otime, odate," +
				" oname, ocarnum,  oemail, ophone, orderdate, impuid, merchantuid, pgtype, movieorderposter"+
				" from GGA_ordercon";
		getPreparedStatement(sql);
		try {
			rs=pstmt.executeQuery();
			while(rs.next()) {
				OrderconVo orderconVo = new OrderconVo();
				orderconVo.setOconid(rs.getString(1));	
				orderconVo.setMovieid(rs.getString(2));
				orderconVo.setMovieordertitle(rs.getString(3));
				orderconVo.setPrice(rs.getInt(4));
				orderconVo.setSeat(rs.getString(5));
				orderconVo.setOtime(rs.getString(6));
				orderconVo.setOdate(rs.getString(7));
				orderconVo.setOname(rs.getString(8));
				orderconVo.setOcarnum(rs.getString(9));
				orderconVo.setOemail(rs.getString(10));
				orderconVo.setOphone(rs.getString(11));
				orderconVo.setOrderdate(rs.getString(12));
				orderconVo.setImpuid(rs.getString(13));
				orderconVo.setMerchantuid(rs.getString(14));
				orderconVo.setPgtype(rs.getString(15));
				orderconVo.setMovieorderposter(rs.getString(16));
				
				list.add(orderconVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	//추후에 아이디 추가
	public void insert(String impuid, String merchantuid, String pgtype, OrderVo orderVo) {
		String sql = "INSERT INTO GGA_ordercon(oconid, movieid, movieordertitle, price,seat, otime, odate," +
				" oname, ocarnum, oemail, ophone, orderdate, impuid, merchantuid, pgtype, movieorderposter)"+
				" VALUES('OC_'|| DBMS_RANDOM.STRING('X', 15), "
				+ "?,?,?,?,?,?,"+
				"?,?,?,?,?,?,?,?,?"+
				" )";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, orderVo.getMovieid());
			pstmt.setString(2, orderVo.getMovieordertitle());
			pstmt.setInt(3, orderVo.getPrice());
			pstmt.setString(4, orderVo.getSeat());
			pstmt.setString(5, orderVo.getOtime());
			pstmt.setString(6, orderVo.getOdate());
			pstmt.setString(7, orderVo.getOname());
			pstmt.setString(8, orderVo.getOcarnum());
			pstmt.setString(9, orderVo.getOemail());
			pstmt.setString(10, orderVo.getOphone());
			pstmt.setString(11, orderVo.getOrderdate());
			pstmt.setString(12, impuid);
			pstmt.setString(13, merchantuid);
			pstmt.setString(14, pgtype);
			pstmt.setString(15, orderVo.getMovieorderposter());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		OrderVo orderVo = new OrderVo();
		String sql = "select oid, movieid, price, seat, otime, odate, id, oname, ocarnum, oemail, ophone, orderdate, movieordertitle, movieorderposter from gga_order where oid =?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, oid);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				orderVo.setOid(oid);
				orderVo.setMovieid(rs.getString(2));
				orderVo.setPrice(rs.getInt(3));
				orderVo.setSeat(rs.getString(4));
				orderVo.setOtime(rs.getString(5));
				orderVo.setOdate(rs.getString(6));
				orderVo.setId(rs.getString(7));
				orderVo.setOname(rs.getString(8));
				orderVo.setOcarnum(rs.getString(9));
				orderVo.setOemail(rs.getString(10));
				orderVo.setOphone(rs.getString(11));
				orderVo.setOrderdate(rs.getString(12));
				orderVo.setMovieordertitle(rs.getString(13));
				orderVo.setMovieorderposter(rs.getString(14));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderVo;
	}
	public int searchSeat(String seat) {
		int result = 0;
		String[] seatList = seat.split(",");
		// 각 좌석 번호를 하나씩 가져와서 비교
		for (String seatNumber : seatList) {
		    // 해당 좌석 번호와 비교하여 일치하는 좌석을 찾는 쿼리 작성
		    String sql = "select sid, snumber, status from gga_seat where snumber =?";
		    
		    // 쿼리 실행을 위해 PreparedStatement 객체 생성
		    getPreparedStatement(sql);
		    
		    try {
				
		    // 쿼리 매개변수 설정
		    pstmt.setString(1, seatNumber);
		    
		    // 쿼리 실행 및 결과 가져오기
		    rs = pstmt.executeQuery();
		    
		    // 결과 처리
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
		
		int result = 0;
		String sql = "update gga_order set price = ?, seat= ? " + 
				" where oid = ?";
		getPreparedStatement(sql);
		try {
			pstmt.setInt(1, Integer.parseInt(price));
			pstmt.setString(2, seat);
			pstmt.setString(3, oid);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
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
		int result = 0;
		
		String sql=" insert into gga_order"
				+ " (movieid, otime, odate, oname, ocarnum, oemail, ophone, orderdate, oid, movieordertitle, movieorderposter) "
				+ " values(?, ?, ?, ?, ?, ?, ?, sysdate, ?,?,?)";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, orderVo.getMovieid());
			pstmt.setString(2, orderVo.getOtime());
			pstmt.setString(3, orderVo.getOdate());
			pstmt.setString(4, orderVo.getOname());
			pstmt.setString(5, orderVo.getOcarnum());
			pstmt.setString(6, orderVo.getOemail());
			pstmt.setString(7, orderVo.getOphone());
			pstmt.setString(8, orderVo.getOid());
			pstmt.setString(9, orderVo.getMovieordertitle());
			pstmt.setString(10, orderVo.getMovieorderposter());
			
			/* pstmt.setString(5, orderVo.getMid()); */
			result = pstmt.executeUpdate();
	
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
