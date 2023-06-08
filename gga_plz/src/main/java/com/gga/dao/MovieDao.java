package com.gga.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gga.vo.MovieVo;

@Repository
public class MovieDao extends DBConn {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	/**
	 *  ������ movie_delete_proc -> ��ȭ����
	 */
	public int delete(String movieid) {
		return sqlSession.delete("mapper.movie.delete", movieid); 
	}
	
	/**
	 * ������ movie_update -> ��ȭ ���� update�κ�
	 */
	public int update(MovieVo movieVo) {
		return sqlSession.update("mapper.movie.update", movieVo);
	}
	
	/**
	 * ������movie_register -> ��ȭ ��� insert�κ�
	 */
	public int insert(MovieVo movieVo) {
		return sqlSession.insert("mapper.movie.insert", movieVo);
	}
	
	/**
	 * ��üī��Ʈ ��������
	 */
	public int totalRowCount() {
			int count = 0;
			String sql = "select count(*) from gga_movie";
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
	
	/* ��ü ����Ʈ */
	public List<Object> getResultList(int startCount, int endCount){
		Map<String, Integer> param = new HashMap<String, Integer>();
		
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList("mapper.movie.list", param);
	}
	
	/**
	 * admin -> movie_list ��ȭ��ü����Ʈ 
	 */
	
	
	/**
	 * header.jsp�� �˻���� seaselect()
	 */
	public MovieVo seaselect(String movietitle) {
		return sqlSession.selectOne("mapper.movie.titleselect", movietitle);
	}
	
/**
 * index.jsp���� ��ȭ������ Ŭ���� movieinfo�� �Ѿ�� mselect()
 */
	public MovieVo mselect(String movieid) {
		
		return sqlSession.selectOne("mapper.movie.movieidselect", movieid);
	}
}
