package com.gga.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gga.vo.BoardCommentVo;
import com.gga.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// ���� �ۼ� ����
	public int commentInsert(BoardCommentVo commentVo) {
		System.out.println(commentVo.getBid());
		System.out.println(commentVo.getBccontent());
		return sqlSession.insert("mapper.board.commentInsert", commentVo);
	}
	
	// ���� ���� ��ȸ
	public int commentRowCount(String bid) {
		return sqlSession.selectOne("mapper.board.commentCount", bid);
	}
	
	// ���� ��ȸ
	public ArrayList<BoardCommentVo> commentSelect(int startCount, int endCount, String bid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("bid", bid);
		List<BoardCommentVo> list = sqlSession.selectList("mapper.board.comment", param);
		return (ArrayList<BoardCommentVo>)list;
	}
	
	// ��ȸ�� ����
	public void updateHits(String bid) {
		sqlSession.selectOne("mapper.board.updateHits", bid);
	}
	
	public int searchRowCount(String btitle)	{
		return sqlSession.selectOne("mapper.board.searchRowCount", btitle);
	}
	
	public int totalRowCount() {
		return sqlSession.selectOne("mapper.board.totalRowCount");
	}
	
	
	// �Խ��� ���� ����
	public int update(BoardVo boardVo) {
		return sqlSession.update("mapper.board.update", boardVo);
	}
	
	// �Խ��� ���� ����
	public int delete(String bid) {
		return sqlSession.delete("mapper.board.delete", bid);
	}
	
	// �Խ��� �󼼳��� ��ȸ
	
	public BoardVo select(String bid) {
		return sqlSession.selectOne("mapper.board.content", bid);
	}
	
	// �Խù� ����
	public int insert(BoardVo boardVo) {
		return sqlSession.insert("mapper.board.insert", boardVo);
	}
	
	// board_list_json �˻� ��� ��ȸ
	public ArrayList<BoardVo> select(int startCount, int endCount, String btitle){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("btitle", btitle);
		List<BoardVo> list = sqlSession.selectList("mapper.board.searchList", param);
		return (ArrayList<BoardVo>)list;

	}
	
	// board_list ���� ��ü ��ȸ
	public ArrayList<BoardVo> select(int startCount, int endCount){
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		List<BoardVo> list = sqlSession.selectList("mapper.board.list", param);
		return (ArrayList<BoardVo>)list;
	}
	
	
	
	
	
	
	
	
	
	
	
}
