package com.gga.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gga.dao.BoardDao;
import com.gga.vo.BoardCommentVo;
import com.gga.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public int getCommentMasterRowCount(String id) {
		return boardDao.commentMasterRowCount(id);
		
	}
	
	@Override
	public ArrayList<BoardVo> getCommentMaster(int startCount, int endCount, String id) {
		return (ArrayList<BoardVo>)boardDao.commentMaster(startCount, endCount, id);
	}
	
	
	// Board_comment_update_result (댓글 업데이트 결과)
	@Override
	public int getCommentUpdateResult(String bcid, String updateComment) {
		return boardDao.commentUpdateResult(bcid,updateComment);
	}
	
	// Board_comment_delete_result (댓글 삭제 결과)
	@Override
	public int getCommentDeleteResult(String bcid) {
		return boardDao.commentDeleteResult(bcid);
	}
	
	// Board_comment_delete_select (댓글 삭제전 Bid 값 추출)
	@Override
	public String getCommentSelect(String bcid) {
		return boardDao.commentSelect(bcid);
	}
	
	// Board_comment_write (댓글 작성 저장)
	@Override
	public int getCommentWriteResult(BoardCommentVo commentVo) {
		return boardDao.commentInsert(commentVo);
	}
	
	// Board_comment (페이징카운트)
	@Override
	public int getCommentRowCount(String bid) {
		return boardDao.commentRowCount(bid);
	}
	
	// Board_comment (리스트조회)
	@Override
	public ArrayList<BoardCommentVo> getCommentList(int startCount, int endCount, String bid) {
		return boardDao.commentSelect(startCount, endCount, bid);
	}
	
	// Board_Content (페이지)
	@Override
	public BoardVo getContentPage(String bid) {
		if(boardDao.select(bid) != null) {
			boardDao.updateHits(bid);
		}
		return boardDao.select(bid);
	}
	
	// Board_Update (페이지)
	@Override
	public BoardVo getUpdatePage(String bid) {
		return boardDao.select(bid);
		
	}
	// Board_Update (저장)
	@Override
	public int getUpdateResult(BoardVo boardVo) {
		return boardDao.update(boardVo);
	}
	
	// Board_delete (저장)
	@Override
	public int getDeleteResult(String bid) {
		return boardDao.delete(bid);
	}
	
	// Board_write (저장)
	@Override
	public int getWriteResult(BoardVo boardVo) {
		return boardDao.insert(boardVo);
	}
	
	// Board_list (+페이징)
	@Override
	public ArrayList<BoardVo> getList(int startCount, int endCount, String btitle){
		return boardDao.select(startCount, endCount, btitle);
	}
	// Board_list (+페이징, 첫번째화면)
	@Override
	public ArrayList<BoardVo> getList(int startCount, int endCount){
		return boardDao.select(startCount, endCount);
	}
	
	
	// dbCount(페이징)
	@Override
	public int getSearchRowCount(String btitle) {
		return boardDao.searchRowCount(btitle);
	}
	@Override
	public int getTotalRowCount() {
		return boardDao.totalRowCount();
	}
}