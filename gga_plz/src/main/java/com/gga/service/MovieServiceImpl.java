package com.gga.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gga.dao.MovieDao;
import com.gga.vo.MovieVo;

@Service("MovieService")
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieDao movieDao;
	
	@Override
	public ArrayList<MovieVo> getMovieList(int startCount, int endCount) {
		ArrayList<MovieVo> mlist = new ArrayList<MovieVo>();
		
		List<Object> list = movieDao.getResultList(startCount, endCount);
		
		for(Object obj : list) {
			MovieVo movieVo = (MovieVo)obj;
			
			mlist.add(movieVo);
		}
		return mlist;
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