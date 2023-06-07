package com.gga.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDao extends DBConn{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int update(int qty, String pid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("qty", qty);
		param.put("pid", pid);
		
		return sqlSession.update("mapper.cart.update", param);
	}
	
	public List<Object> select(){
		return sqlSession.selectList("mapper.cart.list");
	}
	
	public int checkPid(String pid) {
		return sqlSession.selectOne("mapper.cart.pidselect", pid);
	}
	
	public int delete(String pid) {
		return sqlSession.delete("mapper.cart.delete", pid);
	}
	
	
	public int insert(String pid) {
		int result = 0;
		int check = checkPid(pid);
		
		if(check == 0) {
			result = sqlSession.insert("mapper.cart.insert", pid);
		}else {
			result = sqlSession.update("mapper.cart.pidupdate", pid);
		}
		
		return result;
	}
}
