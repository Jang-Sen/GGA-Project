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
	
	// Board_Content (������)
	@Override
	public BoardVo getContentPage(String bid) {
		if(boardDao.select(bid) != null) {
			boardDao.updateHits(bid);
		}
		return boardDao.select(bid);
	}
	
	// Board_Update (������)
	@Override
	public BoardVo getUpdatePage(String bid) {
		return boardDao.select(bid);
		
	}
	// Board_Update (����)
	@Override
	public int getUpdateResult(BoardVo boardVo) {
		return boardDao.update(boardVo);
	}
	
	// Board_delete (����)
	@Override
	public int getDeleteResult(String bid) {
		return boardDao.delete(bid);
	}
	
	// Board_write (����)
	@Override
	public int getWriteResult(BoardVo boardVo) {
		return boardDao.insert(boardVo);
	}
	
	// Board_list (+����¡)
	@Override
	public ArrayList<BoardVo> getList(int startCount, int endCount, String btitle){
		return boardDao.select(startCount, endCount, btitle);
	}
	// Board_list (+����¡, ù��°ȭ��)
	@Override
	public ArrayList<BoardVo> getList(int startCount, int endCount){
		return boardDao.select(startCount, endCount);
	}
	
	
	// dbCount(����¡)
	@Override
	public int getSearchRowCount(String btitle) {
		return boardDao.searchRowCount(btitle);
	}
	@Override
	public int getTotalRowCount() {
		return boardDao.totalRowCount();
	}
}
