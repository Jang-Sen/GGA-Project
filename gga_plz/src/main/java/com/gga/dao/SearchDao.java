package com.gga.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gga.vo.IndexSearchVo;

@Repository
public class SearchDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public ArrayList<IndexSearchVo> movieSearch(String searchContent) {
		List<IndexSearchVo> list = sqlSession.selectList("mapper.search.movieList", searchContent);
		return (ArrayList<IndexSearchVo>)list;
	}
	
	public ArrayList<IndexSearchVo> noticeSearch(String searchContent) {
		List<IndexSearchVo> list = sqlSession.selectList("mapper.search.noticeList", searchContent);
		return (ArrayList<IndexSearchVo>)list;
	}
	
	public ArrayList<IndexSearchVo> boardSearch(String searchContent) {
		List<IndexSearchVo> list = sqlSession.selectList("mapper.search.boardList", searchContent);
		return (ArrayList<IndexSearchVo>)list;
	}
	
	public ArrayList<IndexSearchVo> productSearch(String searchContent) {
		List<IndexSearchVo> list = sqlSession.selectList("mapper.search.productList", searchContent);
		return (ArrayList<IndexSearchVo>)list;
	}
	
	
	
	
}
