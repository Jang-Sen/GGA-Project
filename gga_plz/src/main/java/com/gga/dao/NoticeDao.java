package com.gga.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gga.vo.NoticeVo;
@Repository
public class NoticeDao extends DBConn{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	/*
	 * admin_notice_search total row count
	 */
	public int antotalRowCount() {
		return sqlSession.selectOne("mapper.notice.antotalRowCount");
	}
	
	
	/*
	 * notice_search total row count
	 */
	public int ntotalRowCount() {
		return sqlSession.selectOne("mapper.notice.ntotalRowcount");
	}
	
	
	/*
	 * notice total row count
	 */
	public int totalRowCount() {
		return sqlSession.selectOne("mapper.notice.totalRowCount");
		/*
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
		*/
	}
	
	/*
	 * notice update hits
	 */
	public void updateHits(String nid) {
		sqlSession.update("mapper.notice.updateHits", nid);
		/*
		String sql = "update gga_notice set nhits = nhits+1 where nid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, nid);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
	
	
	
	/*
	 * delete
	 */
	public int delete(String nid) {
		return sqlSession.delete("mapper.notice.delete", nid);
		/*
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
		*/
	}
	
	/**
	 * update
	 */
	public int update(NoticeVo noticeVo) {
		return sqlSession.update("mapper.notice.update", noticeVo);
		/*
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
		*/
	}
	
	/**
	 * select - detailed information about notice(content)
	 */
	public NoticeVo select(String nid) {
		return sqlSession.selectOne("mapper.notice.content", nid);
		/*
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
		*/
		}
	
	
	
	
	/**
	 * select - notice, whole list
	 */
	public ArrayList<NoticeVo> select(){
		List<NoticeVo> list = sqlSession.selectList("mapper.notice.list2");
				
		return (ArrayList<NoticeVo>)list;
		/*
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
		*/
	}
	
	/*
	 * select - notice, whole list (paging)
	 */
	public ArrayList<NoticeVo> select(int startCount, int endCount){	
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		
		List<NoticeVo> list = sqlSession.selectList("mapper.notice.list", param);
		
		return (ArrayList<NoticeVo>)list;
		
		/*
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
		*/
	}
	
	
	/**
	 * insert - enroll notice
	 */
	public int insert(NoticeVo noticeVo) {
		return sqlSession.insert("mapper.notice.insert", noticeVo);
		/*
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
		*/
		
		
	}
	
	
	/*
	 * notice_list (about Search)-> n_select
	 */
	public ArrayList<NoticeVo> n_select(int startCount, int endCount, String ntitle) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("ntitle", ntitle);
		List<NoticeVo> list = sqlSession.selectList("mapper.notice.n_select", param);
		return (ArrayList<NoticeVo>)list;

		
		
		
		
		
		/*
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
		*/
	}
	
	
	
}