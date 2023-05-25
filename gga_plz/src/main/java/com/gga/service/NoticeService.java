package com.gga.service;

import java.util.ArrayList;

import com.gga.vo.NoticeVo;

public interface NoticeService {
	
	int getInsert(NoticeVo noticeVo);
	ArrayList<NoticeVo> getSelect(int startCount, int endCount);
	NoticeVo getSelect(String nid);
	int getUpdate(NoticeVo noticeVo);
	int getDelete(String nid);
	int getTotalRowCount();
	void getUpdateHits(String nid);
	NoticeVo getN_select(String ntitle);

}
