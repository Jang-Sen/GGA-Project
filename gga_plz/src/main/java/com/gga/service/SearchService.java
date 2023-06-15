package com.gga.service;

import java.util.ArrayList;

import com.gga.vo.IndexSearchVo;

public interface SearchService {
	
	//통합검색 영화 - json
	ArrayList<IndexSearchVo> getMovieSearch(String searchContent);
	
	//통합검색 공지사항 - json
	ArrayList<IndexSearchVo> getNoticeSearch(String searchContent);
	
	//통합검색 리뷰게시판 - json
	ArrayList<IndexSearchVo> getBoardSearch(String searchContent);
	
	//통합검색 스토어 - json
	ArrayList<IndexSearchVo> getProductSearch(String searchContent);
	
	
}
