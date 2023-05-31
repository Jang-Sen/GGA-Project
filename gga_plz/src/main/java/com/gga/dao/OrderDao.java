package com.gga.dao;

import com.gga.vo.OrderVo;
import com.gga.vo.OrderconVo;

public class OrderDao extends DBConn{
	
	public OrderconVo selectOrdercon(String merchantuid) {
		OrderconVo orderconVo = new OrderconVo();
		String sql = "select oconid, movieid, movieordertitle, price,seat, otime, odate," +
				" oname, ocarnum,  oemail, ophone, orderdate, impuid, merchantuid, pgtype"+
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
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return orderconVo;
	}
	
	
	//추후에 아이디 추가
	public int insert(String impuid, String merchantuid, String pgtype, String oid) {
		int result = 0;
		String sql = "INSERT INTO GGA_ordercon(oconid, movieid, movieordertitle, price,seat, otime, odate," +
				" oname, ocarnum,  oemail, ophone, orderdate, impuid, merchantuid, pgtype)"+
				" VALUES('oc_'|| RTRIM(REGEXP_REPLACE(trunc(dbms_random.value(100000000000,999999999999)),"+
				" '(.{4})(.+)(.{4})','\1-\2-\3')), ?,?,?,?,?,?,"+
				"?,?,?,?,?,?,?,?"+
				" )";
		getPreparedStatement(sql);
		try {
			OrderVo orderVo = select(oid);
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
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public OrderVo select(String oid) {
		OrderVo orderVo = new OrderVo();
		String sql = "select oid, movieid, price, seat, otime, odate, id, oname, ocarnum, oemail, ophone, orderdate, movieordertitle from gga_order where oid =?";
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
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderVo;
	}
	
	
	
	public int insert(String seat, int price, String oid) {
		int result = 0;
		String sql = "update gga_order set price = ?, seat= ? " + 
				" where oid = ?";
		getPreparedStatement(sql);
		try {
			pstmt.setInt(1, price);
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
				+ " (movieid, otime, odate, oname, ocarnum, oemail, ophone, orderdate, oid, movieordertitle) "
				+ " values(?, ?, ?, ?, ?, ?, ?, sysdate, ?,?)";
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
			
			/* pstmt.setString(5, orderVo.getMid()); */
			result = pstmt.executeUpdate();
	
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
