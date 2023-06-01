package com.gga.service;

import java.util.ArrayList;

import com.gga.vo.MemberVo;

public interface MemberService {
	String getIdCheck(String id);
	int getJoin(MemberVo memberVo);
	int getLogin(MemberVo memberVo);
	int getTotalRowCount();
	ArrayList<MemberVo> getSelect(int startCount, int endCount);
	String findId(String name, String birth, String phone);
	int findPw(MemberVo memberVo);
}
