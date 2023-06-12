
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
	
	public int commentMasterRowCount(String id) {
		return sqlSession.selectOne("mapper.board.commentMasterRowCount", id);
	}
	
	// 마이페이지 뎃글 조회
	public List<BoardVo> commentMaster(int startCount, int endCount, String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("id", id);
		return sqlSession.selectList("mapper.board.commentMaster", param);
	}
	
	// 뎃글 업데이트 결과
	public int commentUpdateResult(String bcid, String updateComment) {
		Map<String, String> param = new HashMap<String,String>();
		param.put("bcid", bcid);
		param.put("updateComment", updateComment);
		return sqlSession.update("mapper.board.commentUpdate", param);
	}
	
	// 뎃글 삭제 결과
	public int commentDeleteResult(String bcid) {
		return sqlSession.delete("mapper.board.commentDelete", bcid);
	}
	
	// 뎃글 삭제 전 Bid 추출
	public String commentSelect(String bcid) {
		return sqlSession.selectOne("mapper.board.commentSelect", bcid);
	}
	
	// �럠湲� �옉�꽦 ���옣
	public int commentInsert(BoardCommentVo commentVo) {
		return sqlSession.insert("mapper.board.commentInsert", commentVo);
	}
	
	// �럠湲� 媛��닔 議고쉶
	public int commentRowCount(String bid) {
		return sqlSession.selectOne("mapper.board.commentCount", bid);
	}
	
	// �럠湲� 議고쉶
	public ArrayList<BoardCommentVo> commentSelect(int startCount, int endCount, String bid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("bid", bid);
		List<BoardCommentVo> list = sqlSession.selectList("mapper.board.comment", param);
		return (ArrayList<BoardCommentVo>)list;
	}
	
	// 議고쉶�닔 利앷�
	public void updateHits(String bid) {
		sqlSession.selectOne("mapper.board.updateHits", bid);
	}
	
	public int searchRowCount(String btitle)	{
		return sqlSession.selectOne("mapper.board.searchRowCount", btitle);
	}
	
	public int totalRowCount() {
		return sqlSession.selectOne("mapper.board.totalRowCount");
	}
	
	
	// 寃뚯떆�뙋 �궡�슜 �닔�젙
	public int update(BoardVo boardVo) {
		return sqlSession.update("mapper.board.update", boardVo);
	}
	
	// 寃뚯떆�뙋 �궡�슜 �궘�젣
	public int delete(String bid) {
		return sqlSession.delete("mapper.board.delete", bid);
	}
	
	// 寃뚯떆�뙋 �긽�꽭�궡�슜 議고쉶
	
	public BoardVo select(String bid) {
		return sqlSession.selectOne("mapper.board.content", bid);
	}
	
	// 寃뚯떆臾� �벐湲�
	public int insert(BoardVo boardVo) {
		return sqlSession.insert("mapper.board.insert", boardVo);
	}
	
	// board_list_json 寃��깋 寃곌낵 議고쉶
	public ArrayList<BoardVo> select(int startCount, int endCount, String btitle){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("btitle", btitle);
		List<BoardVo> list = sqlSession.selectList("mapper.board.searchList", param);
		return (ArrayList<BoardVo>)list;

	}
	
	// board_list 理쒖큹 �쟾泥� 議고쉶
	public ArrayList<BoardVo> select(int startCount, int endCount){
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		List<BoardVo> list = sqlSession.selectList("mapper.board.list", param);
		return (ArrayList<BoardVo>)list;
	}
	
	
	
	
	
	
	
	
	
	
	
}