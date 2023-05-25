package com.gga.service;

import java.util.ArrayList;

import com.gga.vo.MovieVo;

public interface MovieService {
	public ArrayList<MovieVo> getMovieList(int startCount, int endCount);
	public int getMovieUpdate(MovieVo movieVo);
	public int getMovieInsert(MovieVo movieVo);
	public MovieVo getMovieSelect(String movieid);
	public MovieVo getMovieSearchSelect(String movietitle);
	public int getMovieDelete(String movieid);
	public int getTotalRowCount();
}
