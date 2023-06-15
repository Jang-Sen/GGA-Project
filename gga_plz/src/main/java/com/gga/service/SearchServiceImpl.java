package com.gga.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gga.dao.SearchDao;
import com.gga.vo.IndexSearchVo;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao searchDao;
	
	// 영화 서치 json
	@Override
	public ArrayList<IndexSearchVo> getMovieSearch(String searchContent) {
		return searchDao.movieSearch(searchContent);
	}
	
	// 공지 서치 json
	@Override
	public ArrayList<IndexSearchVo> getNoticeSearch(String searchContent) {
		return searchDao.noticeSearch(searchContent);
	}
	
	// 리뷰 서치 json
	@Override
	public ArrayList<IndexSearchVo> getBoardSearch(String searchContent) {
		return searchDao.boardSearch(searchContent);
	}
	
	// 상품 서치 json
	@Override
	public ArrayList<IndexSearchVo> getProductSearch(String searchContent) {
		return searchDao.productSearch(searchContent);
	}
	
	
	
	
}
