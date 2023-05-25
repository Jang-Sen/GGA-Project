package com.gga.dao;

import java.util.ArrayList;

import com.gga.vo.MemberVo;

public class MemberDao extends DBConn {
	/* 전체 카운트 가져오기*/
	public int totalRowCount() {
			int count = 0;
			String sql = "SELECT COUNT(*) FROM GGA_MEMBER";
			getPreparedStatement(sql);
			
			try {
				rs = pstmt.executeQuery();
				while(rs.next()) {				
					count = rs.getInt(1);
				}			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return count;		
		}	
	
	/* 전체 리스트 */
	public ArrayList<MemberVo> select(int startCount, int endCount){
		
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		try{
			String sql = "SELECT RNO, ID, NAME, MDATE" + 
					" FROM (SELECT ROWNUM RNO, ID, NAME, TO_CHAR(MDATE,'YYYY-MM-DD') MDATE" + 
					" FROM (SELECT ID, NAME, MDATE FROM MYCGV_MEMBER" + 
					" ORDER BY MDATE DESC))" + 
					" WHERE RNO BETWEEN ? AND ? ";
			
			getPreparedStatement(sql);
			pstmt.setInt(1, startCount);
			pstmt.setInt(2, endCount);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				MemberVo memberVo = new MemberVo();
				memberVo.setRno(rs.getInt(1));
				memberVo.setId(rs.getString(2));
				memberVo.setName(rs.getString(3));
				memberVo.setMdate(rs.getString(4));
				
				list.add(memberVo);
			}
			
		}catch(Exception e){ e.printStackTrace();}
		return list;
	}
	
   /*
    * select - 愿�由ъ옄 �쉶�썝 愿�由�
    */
   public ArrayList<MemberVo> select(){
      ArrayList<MemberVo> list = new ArrayList<MemberVo>();
      String sql = "SELECT ROWNUM RNO, ID, NAME, CARNUM, TO_CHAR(MDATE, 'YYYY-MM-DD') MDATE"
            + " FROM (SELECT ID, NAME, CARNUM, MDATE"
            + " FROM GGA_MEMBER ORDER BY MDATE DESC)";
      getPreparedStatement(sql);
      
      try {
      rs = pstmt.executeQuery();
      while (rs.next()) {
         MemberVo memberVo = new MemberVo();
         memberVo.setRno(rs.getInt(1));
         memberVo.setId(rs.getString(2));
         memberVo.setName(rs.getString(3));
         memberVo.setCarnum(rs.getString(4));
         memberVo.setMdate(rs.getString(5));
         
         list.add(memberVo);
      }
      
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return list;
   }
   
   /*
    * idCheck - �븘�씠�뵒 以묐났 泥댄겕
    */
   public int idCheck(String id) {
      int result = 0;
      String sql = "SELECT COUNT(*) FROM GGA_MEMBER WHERE ID = ?";
      getPreparedStatement(sql);
      
      try {
         pstmt.setString(1, id);
         
         rs = pstmt.executeQuery();
         while (rs.next()) {
            result = rs.getInt(1);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return result;
   }
   
   /*
    * loginCheck - 濡쒓렇�씤 泥댄겕
    */
   public int loginCheck(MemberVo memberVo) {
      int result = 0;
      String sql = "SELECT COUNT(*) FROM GGA_MEMBER WHERE ID = ? AND PASS = ?";
      getPreparedStatement(sql);
      
      try {
         pstmt.setString(1, memberVo.getId());
         pstmt.setString(2, memberVo.getPass());
         
         rs = pstmt.executeQuery();
         while(rs.next()) {
            result = rs.getInt(1);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return result;
   }
   
   /*
    * update - �궡 �젙蹂� �닔�젙
    */
   public int update(MemberVo memberVo) {
      int result = 0;
      String sql = "UPDATE GGA_MEMBER SET PASS = ?, PHONE = ?, EMAIL = ?, CARNUM = ?"
            + " WHERE MID = ?";
      getPreparedStatement(sql);
      
      try {
         pstmt.setString(1, memberVo.getPass());
         pstmt.setString(2, memberVo.getPhone());
         pstmt.setString(3, memberVo.getEmail());
         pstmt.setString(4, memberVo.getCarnum());
         pstmt.setString(5, memberVo.getId());
         
         result = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return result;
   }
   
   /*
    * insert - �쉶�썝媛��엯
    */
   public int insert(MemberVo memberVo) {
      int result = 0;
      String sql = "INSERT INTO GGA_MEMBER(ID, PASS, NAME, BIRTH, GENDER, TEL, PHONE, EMAIL, CARNUM, GENRE, MDATE)"
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
      getPreparedStatement(sql);
      
      try {
         pstmt.setString(1, memberVo.getId());
         pstmt.setString(2, memberVo.getPass());
         pstmt.setString(3, memberVo.getName());
         pstmt.setString(4, memberVo.getBirth());
         pstmt.setString(5, memberVo.getGender());
         pstmt.setString(6, memberVo.getTel());
         pstmt.setString(7, memberVo.getPhone());
         pstmt.setString(8, memberVo.getEmail());
         pstmt.setString(9, memberVo.getCarnum());
         pstmt.setString(10, memberVo.getGenreList());
         
         result = pstmt.executeUpdate();
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return result;
   }
   
   /*
    * select(mid) - �쉶�썝 �젙蹂� �긽�꽭 蹂닿린
    */
   public MemberVo select(String mid) {
      MemberVo memberVo = new MemberVo();
      String sql = "SELECT ID, PASS, NAME, GENDER, PHONE, EMAIL, CARNUM FROM GGA_MEMBER"
            + " WHERE MID = ?";
      getPreparedStatement(sql);
      
      try {
         pstmt.setString(1, mid);
         
         rs = pstmt.executeQuery();
         while(rs.next()) {
            memberVo.setId(rs.getString(1));
            memberVo.setPass(rs.getString(2));
            memberVo.setName(rs.getString(3));
            memberVo.setGender(rs.getString(4));
            memberVo.setPhone(rs.getString(5));
            memberVo.setEmail(rs.getString(6));
            memberVo.setCarnum(rs.getString(7));
            
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return memberVo;
   }
}