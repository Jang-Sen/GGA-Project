package com.gga.vo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class BoardVo {
	String bid, btitle, bcontent, bdate, mid, movieName, bfile, bsfile; 
	int rno, bhits, score;
	CommonsMultipartFile file1;
	
	public String getBfile() {
		return bfile;
	}
	public void setBfile(String bfile) {
		this.bfile = bfile;
	}
	public void setFile1(CommonsMultipartFile file1) {
		this.file1 = file1;
	}
	public String getBsfile() {
		return bsfile;
	}
	public void setBsfile(String bsfile) {
		this.bsfile = bsfile;
	}
	public CommonsMultipartFile getFile1() {
		return file1;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getBhits() {
		return bhits;
	}
	public void setBhits(int bhits) {
		this.bhits = bhits;
	}
}
