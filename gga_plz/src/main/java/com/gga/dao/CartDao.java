package com.gga.dao;

import java.util.ArrayList;

import com.gga.vo.CartVo;

public class CartDao extends DBConn{
	
	public int update(int qty) {
		int result = 0;
		String sql = "update gga_cart set qty=?";
		getPreparedStatement(sql);
		try {
			pstmt.setInt(1, qty);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<CartVo> select(){
		ArrayList<CartVo> list = new ArrayList<CartVo>();
		
		String sql ="select p.pid, pname, pprice, qty, pprice*qty, p.pfile from gga_cart c, gga_product p where c.pid=p.pid";
		getPreparedStatement(sql);
		try {
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CartVo cartVo = new CartVo();
				
				cartVo.setPid(rs.getString(1));
				cartVo.setPname(rs.getString(2));
				cartVo.setPprice(rs.getInt(3));
				cartVo.setQty(rs.getInt(4));
				cartVo.setTotalprice(rs.getInt(5));
				cartVo.setPfile(rs.getString(6));
				
				list.add(cartVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int checkPid(String pid) {
		int result = 0;
		
		String sql = "select count(*) from gga_cart where pid= ?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, pid);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int delete(String pid) {
		int result=0;
		String sql = "delete from gga_cart where pid =?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, pid);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public int insert(String pid) {
		int result = 0;
		int check = checkPid(pid);
		String sql ="";
		
		if(check == 0) {
			sql = "insert into gga_cart(cid, qty, pid, id) values"
					+ " ('C_'||to_char(sequ_gga_cart_cid.nextval, 'fm0000'), 1, ?, null)";
		}else {
			sql = "update gga_cart set qty=qty+1 where pid= ?";
		}
		
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, pid);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
