package com.gga.vo;

public class ProductOrderVo {
	String pid, pname, pfile, cid, id, poid, podate, qty, pprice, psfile;
	int rno, totalprice;
	int[] qtyList;
	String[] pidList;
	
	public String getPsfile() {
		return psfile;
	}
	public void setPsfile(String psfile) {
		this.psfile = psfile;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPfile() {
		return pfile;
	}
	public void setPfile(String pfile) {
		this.pfile = pfile;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPoid() {
		return poid;
	}
	public void setPoid(String poid) {
		this.poid = poid;
	}
	public String getPodate() {
		return podate;
	}
	public void setPodate(String podate) {
		this.podate = podate;
	}
	
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int[] getQtyList() {
		return qtyList;
	}
	public void setQtyList(int[] qtyList) {
		this.qtyList = qtyList;
	}
	public String[] getPidList() {
		return pidList;
	}
	public void setPidList(String[] pidList) {
		this.pidList = pidList;
	}
}
