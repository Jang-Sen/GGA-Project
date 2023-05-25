package com.gga.dao;

import java.util.ArrayList;

import com.gga.vo.MovieVo;
import com.gga.vo.NoticeVo;

public class NoticeDao extends DBConn{
	
	/*전체 로우 카운트 (페이징 처리)*/
	public int totalRowCount() {
		int count = 0;
		String sql = "select count(*) from gga_notice";
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
	
	/*
	 * 공지사항 조회수 업데이트
	 */
	public void updateHits(String nid) {
		String sql = "update gga_notice set nhits = nhits+1 where nid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, nid);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/*
	 * delete
	 */
	public int delete(String nid) {
		int result = 0;
		String sql = "delete from gga_notice where nid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, nid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * update
	 */
	public int update(NoticeVo noticeVo) {
		int result = 0;
		String sql = "update gga_notice set ntitle=?, ncontent=? where nid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, noticeVo.getNtitle());
			pstmt.setString(2, noticeVo.getNcontent());
			pstmt.setString(3, noticeVo.getNid());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * select- 
	 */
	public NoticeVo select(String nid) {
		NoticeVo noticeVo = new NoticeVo();
		String sql = "SELECT NID,NTITLE,NCONTENT,NHITS,NDATE FROM GGA_NOTICE WHERE NID=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, nid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				noticeVo.setNid(rs.getString(1));
				noticeVo.setNtitle(rs.getString(2));
				noticeVo.setNcontent(rs.getString(3));
				noticeVo.setNhits(rs.getInt(4));
				noticeVo.setNdate(rs.getString(5));
			}
			
			} catch(Exception e) {
				e.printStackTrace();
			}
		return noticeVo;
		}
	
	
	
	
	/**
	 * select - 관리자 공지사항 게시글 전체 리스트
	 */
	public ArrayList<NoticeVo> select(){
		ArrayList<NoticeVo> list = new ArrayList<NoticeVo>();
		String sql = "select rownum rno, ntitle, nhits, ndate, nid "
				+ " from (select ntitle, nhits, ndate, nid from gga_notice order by ndate desc)";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVo noticeVo = new NoticeVo();
				noticeVo.setRno(rs.getInt(1));
				noticeVo.setNtitle(rs.getString(2));
				noticeVo.setNhits(rs.getInt(3));
				noticeVo.setNdate(rs.getString(4));
				noticeVo.setNid(rs.getString(5));
				list.add(noticeVo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	//notice list 페이징 처리 오버로딩
	public ArrayList<NoticeVo> select(int startCount, int endCount){
		ArrayList<NoticeVo> list = new ArrayList<NoticeVo>();
		String sql = "select rno, nid, ntitle, nhits, ndate " 
				+ " from (select rownum rno, nid, ntitle, nhits, ndate"
				+ " from (select nid, ntitle, nhits, ndate from gga_notice order by ndate desc))" 
				+ " where rno between ? and ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, startCount);
			pstmt.setInt(2, endCount);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVo noticeVo = new NoticeVo();
				noticeVo.setRno(rs.getInt(1));
				noticeVo.setNid(rs.getString(2));
				noticeVo.setNtitle(rs.getString(3));
				noticeVo.setNhits(rs.getInt(4));
				noticeVo.setNdate(rs.getString(5));
				list.add(noticeVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * insert - 게시글 등록
	 */
	public int insert(NoticeVo noticeVo) {
		int result = 0;
		String sql=" insert into gga_notice(nid, ntitle, ncontent, nhits, ndate) values('n_'||ltrim(to_char(sequ_gga_notice.nextval,'0000')), ?, ?, 0, sysdate)";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, noticeVo.getNtitle());
			pstmt.setString(2, noticeVo.getNcontent());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result; 
		
		
		
	}
	
	
	/*
	 * notice_list 검색 기능 n_select
	 */
	public NoticeVo n_select(String ntitle) {
		NoticeVo noticeVo = new NoticeVo();
		
		String sql="select nid, ntitle, ncontent, nhits, ndate from gga_notice where ntitle like ?";
	getPreparedStatement(sql);
	
		try {
			pstmt.setString(1, "%" + ntitle + "%");
			
			rs = pstmt.executeQuery();		
			while(rs.next()) {
				noticeVo.setNid(rs.getString(1));
				noticeVo.setNtitle(rs.getString(2));
				noticeVo.setNcontent(rs.getString(3));
				noticeVo.setNhits(rs.getInt(4));
				noticeVo.setNdate(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeVo;
	}
	
	
	
}