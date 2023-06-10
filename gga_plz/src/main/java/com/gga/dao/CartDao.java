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
	
	public List<Object> select(String id){
		return sqlSession.selectList("mapper.cart.list", id);
	}
	
	public int checkPid(String pid) {
		return sqlSession.selectOne("mapper.cart.pidselect", pid);
	}
	
	public int delete(String pid) {
		return sqlSession.delete("mapper.cart.delete", pid);
	}
	
	
	public int insert(String pid, String id) {
		int result = 0;
		int check = checkPid(pid);
		Map<String, String> param = new HashMap<String, String>();
		param.put("pid", pid);
		param.put("id", id);
		if(check == 0) {
			result = sqlSession.insert("mapper.cart.insert", param);
		}else {
			result = sqlSession.update("mapper.cart.pidupdate", pid);
		}
		
		return result;
	}
}
