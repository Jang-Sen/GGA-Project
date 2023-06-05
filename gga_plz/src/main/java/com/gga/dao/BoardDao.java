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
	
	// 뎃글 작성 저장
	public int commentInsert(BoardCommentVo commentVo) {
		System.out.println(commentVo.getBid());
		System.out.println(commentVo.getBccontent());
		return sqlSession.insert("mapper.board.commentInsert", commentVo);
	}
	
	// 뎃글 갯수 조회
	public int commentRowCount(String bid) {
		return sqlSession.selectOne("mapper.board.commentCount", bid);
	}
	
	// 뎃글 조회
	public ArrayList<BoardCommentVo> commentSelect(int startCount, int endCount, String bid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("bid", bid);
		List<BoardCommentVo> list = sqlSession.selectList("mapper.board.comment", param);
		return (ArrayList<BoardCommentVo>)list;
	}
	
	// 조회수 증가
	public void updateHits(String bid) {
		sqlSession.selectOne("mapper.board.updateHits", bid);
	}
	
	public int searchRowCount(String btitle)	{
		return sqlSession.selectOne("mapper.board.searchRowCount", btitle);
	}
	
	public int totalRowCount() {
		return sqlSession.selectOne("mapper.board.totalRowCount");
	}
	
	
	// 게시판 내용 수정
	public int update(BoardVo boardVo) {
		return sqlSession.update("mapper.board.update", boardVo);
	}
	
	// 게시판 내용 삭제
	public int delete(String bid) {
		return sqlSession.delete("mapper.board.delete", bid);
	}
	
	// 게시판 상세내용 조회
	
	public BoardVo select(String bid) {
		return sqlSession.selectOne("mapper.board.content", bid);
	}
	
	// 게시물 쓰기
	public int insert(BoardVo boardVo) {
		return sqlSession.insert("mapper.board.insert", boardVo);
	}
	
	// board_list_json 검색 결과 조회
	public ArrayList<BoardVo> select(int startCount, int endCount, String btitle){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("btitle", btitle);
		List<BoardVo> list = sqlSession.selectList("mapper.board.searchList", param);
		return (ArrayList<BoardVo>)list;

	}
	
	// board_list 최초 전체 조회
	public ArrayList<BoardVo> select(int startCount, int endCount){
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		List<BoardVo> list = sqlSession.selectList("mapper.board.list", param);
		return (ArrayList<BoardVo>)list;
	}
	
	
	
	
	
	
	
	
	
	
	
}
