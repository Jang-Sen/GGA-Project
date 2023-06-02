package com.gga.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gga.dao.BoardDao;
import com.gga.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
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
