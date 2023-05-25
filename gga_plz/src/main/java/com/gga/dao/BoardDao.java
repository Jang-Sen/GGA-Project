package com.gga.dao;

import java.util.ArrayList;

import com.gga.vo.BoardVo;

public class BoardDao extends DBConn {
	
	public int totalRowCount() {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM GGA_BOARD";
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
	
	
	// 게시판 내용 수정
	public int update(BoardVo boardVo) {
		int result = 0;
		String sql = "UPDATE GGA_BOARD SET BTITLE=?, MOVIENAME=?, SCORE=?, BCONTENT=? WHERE BID=? ";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, boardVo.getBtitle());
			pstmt.setString(2, boardVo.getMovieName());
			pstmt.setInt(3, boardVo.getScore());
			pstmt.setString(4, boardVo.getBcontent());
			pstmt.setString(5, boardVo.getBid());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 게시판 내용 삭제
	public int delete(String bid) {
		int result = 0;
		String sql = "DELETE FROM GGA_BOARD WHERE BID=?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, bid);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 게시판 상세내용 조회
	
	public BoardVo select(String bid) {
		BoardVo boardVo = new BoardVo();
		String sql = "SELECT BID,BTITLE,SCORE,BCONTENT,VIEWS,MID,MOVIENAME,BDATE FROM GGA_BOARD WHERE BID=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				boardVo.setBid(rs.getString(1));
				boardVo.setBtitle(rs.getString(2));
				boardVo.setScore(rs.getInt(3));
				boardVo.setBcontent(rs.getString(4));
				boardVo.setViews(rs.getInt(5));
				boardVo.setMid(rs.getString(6));
				boardVo.setMovieName(rs.getString(7));
				boardVo.setBdate(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return boardVo;
	}
	
	
	// 게시물 쓰기
	public int insert(BoardVo boardVo) {
		int result = 0;
		String sql = "INSERT INTO GGA_BOARD(BID,BTITLE,SCORE,BCONTENT,VIEWS,MID,MOVIENAME,BDATE) "
				+ " VALUES('b_'||LTRIM(TO_CHAR(SEQU_GGA_BOARD_BID.NEXTVAL, '0000')),?,?,?,0,?,?,SYSDATE)";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, boardVo.getBtitle());
			pstmt.setInt(2, boardVo.getScore());
			pstmt.setString(3, boardVo.getBcontent());
			pstmt.setString(4, boardVo.getMid());
			pstmt.setString(5, boardVo.getMovieName());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	//게시물 전체 조회
	public ArrayList<BoardVo> select(){
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		String sql = "SELECT ROWNUM RNO, BID, BTITLE, BCONTENT, VIEWS, MID, MOVIENAME, TO_CHAR(BDATE, 'YYYY-MM-DD') BDATE FROM "
				+ " (SELECT BID, BTITLE, BCONTENT, VIEWS, MID, MOVIENAME, BDATE FROM GGA_BOARD ORDER BY BDATE DESC)";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVo boardVo = new BoardVo();
				boardVo.setRno(rs.getInt(1));
				boardVo.setBid(rs.getString(2));
				boardVo.setBtitle(rs.getString(3));
				boardVo.setBcontent(rs.getString(4));
				boardVo.setViews(rs.getInt(5));
				boardVo.setMid(rs.getString(6));
				boardVo.setMovieName(rs.getString(7));
				boardVo.setBdate(rs.getString(8));
				list.add(boardVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<BoardVo> select(int startCount, int endCount){
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		String sql = "SELECT RNO, BID, BTITLE, BCONTENT, VIEWS, MID, MOVIENAME, BDATE"
				+ " FROM (SELECT ROWNUM RNO, BID, BTITLE, BCONTENT, VIEWS, MID, MOVIENAME, TO_CHAR(BDATE, 'YYYY-MM-DD') BDATE FROM "
				+ " (SELECT BID, BTITLE, BCONTENT, VIEWS, MID, MOVIENAME, BDATE FROM GGA_BOARD ORDER BY BDATE DESC))"
				+ " WHERE RNO BETWEEN ? AND ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, startCount);
			pstmt.setInt(2, endCount);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVo boardVo = new BoardVo();
				boardVo.setRno(rs.getInt(1));
				boardVo.setBid(rs.getString(2));
				boardVo.setBtitle(rs.getString(3));
				boardVo.setBcontent(rs.getString(4));
				boardVo.setViews(rs.getInt(5));
				boardVo.setMid(rs.getString(6));
				boardVo.setMovieName(rs.getString(7));
				boardVo.setBdate(rs.getString(8));
				
				list.add(boardVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
