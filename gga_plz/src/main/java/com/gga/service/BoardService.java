package com.gga.service;

import java.util.ArrayList;

import com.gga.vo.BoardVo;

public interface BoardService {
	
	public BoardVo getContentPage(String bid);
	public BoardVo getUpdatePage(String bid);
	public int getUpdateResult(BoardVo boardVo);
	public int getDeleteResult(String bid);
	public int getWriteResult(BoardVo boardVo);
	public ArrayList<BoardVo> getList(int startCount, int endCount, String btitle);
	public ArrayList<BoardVo> getList(int startCount, int endCount);
	public int getSearchRowCount(String btitle);
	public int getTotalRowCount();
 	
}
