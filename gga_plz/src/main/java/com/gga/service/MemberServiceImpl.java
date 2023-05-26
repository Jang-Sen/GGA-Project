package com.gga.service;

import java.util.ArrayList;

import com.gga.dao.MemberDao;
import com.gga.vo.MemberVo;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao = new MemberDao();
	
	@Override
	public String getIdCheck(String id) {
		int result = memberDao.idCheck(id);
		
		return String.valueOf(result);
	}
	
	@Override
	public int getJoin(MemberVo memberVo) {
		return memberDao.insert(memberVo);
	}
	
	@Override
	public int getLogin(MemberVo memberVo) {
		return memberDao.loginCheck(memberVo);
	}
	
	@Override
	public int getTotalRowCount() {
		return memberDao.totalRowCount();
	}
	
	@Override
	public ArrayList<MemberVo> getSelect(int startCount, int endCount){
		return memberDao.select(startCount, endCount);
	}

}
