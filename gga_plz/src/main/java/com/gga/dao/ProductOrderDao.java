package com.gga.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gga.vo.ProductOrderVo;

@Repository
public class ProductOrderDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Object> select(String id){
		return sqlSession.selectList("mapper.productorder.myselect", id);
	}
	public int delete() {
		return sqlSession.delete("mapper.productorder.delete");
	}
	
	public int insert(List<Map<String, String>> paramList) {
		return sqlSession.insert("mapper.productorder.insert", paramList);
	}
	
	public ArrayList<ProductOrderVo> select(){
		List<ProductOrderVo> list = sqlSession.selectList("mapper.productorder.list");
		return (ArrayList<ProductOrderVo>) list;
	}
	
	public int insert(Map<String, String> param) {
		return sqlSession.insert("mapper.productorder.oneInsert", param);
	}
}
