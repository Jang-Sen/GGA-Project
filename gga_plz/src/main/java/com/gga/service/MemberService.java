package com.gga.service;

import java.util.ArrayList;

import com.gga.vo.MemberVo;
import com.gga.vo.SessionVo;

public interface MemberService {
	String getIdCheck(String id);
	int getJoin(MemberVo memberVo);
	SessionVo getLogin(MemberVo memberVo);
	int getTotalRowCount();
	ArrayList<MemberVo> getSelect(int startCount, int endCount);
	String findId(MemberVo memberVo);
	String findPw(MemberVo memberVo);
}
