package com.gga.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gga.dao.NoticeDao;
import com.gga.vo.NoticeVo;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public int getInsert(NoticeVo noticeVo) {
		return noticeDao.insert(noticeVo);
	}
	
	@Override
	public ArrayList<NoticeVo> getSelect(int startCount, int endCount){
		return noticeDao.select(startCount, endCount);
	}
	
	@Override
	public NoticeVo getSelect(String nid) {
		return noticeDao.select(nid);
		
	}
	
	@Override
	public int getUpdate(NoticeVo noticeVo) {
		return noticeDao.update(noticeVo);
	}
	
	@Override
	public int getDelete(String nid) {
		return noticeDao.delete(nid);
	}
	
	@Override
	public int getTotalRowCount() {
		return noticeDao.totalRowCount();
	}
	
	@Override
	public void getUpdateHits(String nid) {
		noticeDao.updateHits(nid);
	}

	@Override
	public NoticeVo getN_select(String ntitle) {
		return noticeDao.n_select(ntitle);
	}

}
