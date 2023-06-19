package com.gga.vo;

import java.util.ArrayList;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class MovieVo {
	String movieid, movietitle, genre, moviedday, runtime, audience, movieinfo,
		director, actor, mainposter, stillcut1, stillcut2, stillcut3, stillcut4, youtube
		, smainposter, sstillcut1, sstillcut2, sstillcut3, sstillcut4;
	int rno;
	CommonsMultipartFile[] files;
	ArrayList<String> mfiles = new ArrayList<String>();
	ArrayList<String> msfiles = new ArrayList<String>();
	public CommonsMultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(CommonsMultipartFile[] files) {
		this.files = files;
	}
	public ArrayList<String> getMfiles() {
		return mfiles;
	}
	public void setMfiles(ArrayList<String> mfiles) {
		this.mfiles = mfiles;
	}
	public ArrayList<String> getMsfiles() {
		return msfiles;
	}
	public void setMsfiles(ArrayList<String> msfiles) {
		this.msfiles = msfiles;
	}
	public String getSmainposter() {
		return smainposter;
	}
	public void setSmainposter(String smainposter) {
		this.smainposter = smainposter;
	}
	public String getSstillcut1() {
		return sstillcut1;
	}
	public void setSstillcut1(String sstillcut1) {
		this.sstillcut1 = sstillcut1;
	}
	public String getSstillcut2() {
		return sstillcut2;
	}
	public void setSstillcut2(String sstillcut2) {
		this.sstillcut2 = sstillcut2;
	}
	public String getSstillcut3() {
		return sstillcut3;
	}
	public void setSstillcut3(String sstillcut3) {
		this.sstillcut3 = sstillcut3;
	}
	public String getSstillcut4() {
		return sstillcut4;
	}
	public void setSstillcut4(String sstillcut4) {
		this.sstillcut4 = sstillcut4;
	}
	
	public String getMovieid() {
		return movieid;
	}
	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}
	public String getMovietitle() {
		return movietitle;
	}
	public void setMovietitle(String movietitle) {
		this.movietitle = movietitle;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMoviedday() {
		return moviedday;
	}
	public void setMoviedday(String moviedday) {
		this.moviedday = moviedday;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getAudience() {
		return audience;
	}
	public void setAudience(String audience) {
		this.audience = audience;
	}
	public String getMovieinfo() {
		return movieinfo;
	}
	public void setMovieinfo(String movieinfo) {
		this.movieinfo = movieinfo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getMainposter() {
		return mainposter;
	}
	public void setMainposter(String mainposter) {
		this.mainposter = mainposter;
	}
	public String getStillcut1() {
		return stillcut1;
	}
	public void setStillcut1(String stillcut1) {
		this.stillcut1 = stillcut1;
	}
	public String getStillcut2() {
		return stillcut2;
	}
	public void setStillcut2(String stillcut2) {
		this.stillcut2 = stillcut2;
	}
	public String getStillcut3() {
		return stillcut3;
	}
	public void setStillcut3(String stillcut3) {
		this.stillcut3 = stillcut3;
	}
	public String getStillcut4() {
		return stillcut4;
	}
	public void setStillcut4(String stillcut4) {
		this.stillcut4 = stillcut4;
	}
	public String getYoutube() {
		return youtube;
	}
	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
}
