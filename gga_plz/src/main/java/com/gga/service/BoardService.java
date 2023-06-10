package com.gga.service;

import java.util.ArrayList;

import com.gga.vo.BoardCommentVo;
import com.gga.vo.BoardVo;

public interface BoardService {
	
	//���� ����
	BoardVo getContentPage(String bid);
	BoardVo getUpdatePage(String bid);
	int getUpdateResult(BoardVo boardVo);
	int getDeleteResult(String bid);
	int getWriteResult(BoardVo boardVo);
	ArrayList<BoardVo> getList(int startCount, int endCount, String btitle);
	ArrayList<BoardVo> getList(int startCount, int endCount);
	int getSearchRowCount(String btitle);
	int getTotalRowCount();
 	
	//���� ����
	ArrayList<BoardCommentVo> getCommentList(int startCount,int endCount,String bid);
	int getCommentRowCount(String bid);
	int getCommentWriteResult(BoardCommentVo commentVo);
	int getCommentDeleteResult(String bcid);
	int getCommentUpdateResult(String bcid,String updateComment);
	String getCommentSelect(String bcid);
}