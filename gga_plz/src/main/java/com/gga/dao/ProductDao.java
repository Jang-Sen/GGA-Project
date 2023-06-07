package com.gga.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gga.vo.ProductVo;

@Repository
public class ProductDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Object> selectAll() {
		return sqlSession.selectList("mapper.product.list");
	}

	public ProductVo select(String pid) {
		return sqlSession.selectOne("mapper.product.content", pid);
	}

	public int update(ProductVo productVo) {
		return sqlSession.update("mapper.product.update", productVo);
	}

	public int insert(ProductVo productVo) {
		return sqlSession.insert("mapper.product.insert", productVo);
	}
	
	public int delete(String pid) {
		return sqlSession.delete("mapper.product.delete", pid);
	}

}
