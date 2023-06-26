package com.gga.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.gga.dao.MemberDao;
import com.gga.vo.MemberVo;
import com.gga.vo.SessionVo;

public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
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
	public SessionVo getLogin(MemberVo memberVo) {
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
	
	@Override
	public String findId(MemberVo memberVo) {
		return memberDao.select_id(memberVo);
		
	}
	
	@Override
	public String findPw(MemberVo memberVo) {
		return memberDao.select_pw(memberVo);
	}
	
	@Override
	public MemberVo getMypageUpdate(String id) {
		return memberDao.select(id);
	}
	
	@Override
	public int getUpdate(MemberVo memberVo) {
		return memberDao.update(memberVo);
	}


}
