package com.gga.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.gga.dao.MovieDao;
import com.gga.vo.MovieVo;

@Service
public class MovieServiceImpl implements MovieService{

	private MovieDao movieDao = new MovieDao();
	
	@Override
	public ArrayList<MovieVo> getMovieList(int startCount, int endCount) {
		return movieDao.getResultList(startCount, endCount);
	}

	@Override
	public int getMovieUpdate(MovieVo movieVo) {
		return movieDao.update(movieVo);
	}

	@Override
	public int getMovieInsert(MovieVo movieVo) {
		return movieDao.insert(movieVo);
	}

	@Override
	public MovieVo getMovieSelect(String movieid) {
		return movieDao.mselect(movieid);
	}

	@Override
	public MovieVo getMovieSearchSelect(String movietitle) {
		return movieDao.seaselect(movietitle);
	}

	@Override
	public int getMovieDelete(String movieid) {
		return movieDao.delete(movieid);
	}

	@Override
	public int getTotalRowCount() {
		return movieDao.totalRowCount();
	}
}