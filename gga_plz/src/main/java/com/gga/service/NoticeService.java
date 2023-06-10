package com.gga.service;

import java.util.ArrayList;

import com.gga.vo.NoticeVo;

public interface NoticeService {
	
	int getInsert(NoticeVo noticeVo);
	ArrayList<NoticeVo> getSelect(int startCount, int endCount);
	ArrayList<NoticeVo> getN_select(int startCount, int endCount, String ntitle);
	NoticeVo getSelect(String nid);
	int getUpdate(NoticeVo noticeVo);
	int getDelete(String nid);
	int getTotalRowCount();
	int getNtotalRowCount();
	int getAntotalRowCount();
	void getUpdateHits(String nid);
	
	

}
