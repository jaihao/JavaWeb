package com.nf.entity;

import java.util.Date;

/**
 * 	private int lid	--编号
	String lname--捐款人姓名
	String lsex--捐款人性别	
	Date ltime	--捐款日期	
	Double lmoney--捐款金额	
 *
 */
public class LoveInHeart {
	private int lid;
	private String lname;
	private String lsex;
	private Date ltime;
	private Double lmoney;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLsex() {
		return lsex;
	}
	public void setLsex(String lsex) {
		this.lsex = lsex;
	}
	public Date getLtime() {
		return ltime;
	}
	public void setLtime(Date ltime) {
		this.ltime = ltime;
	}
	public Double getLmoney() {
		return lmoney;
	}
	public void setLmoney(Double lmoney) {
		this.lmoney = lmoney;
	}
	@Override
	public String toString() {
		return "LoveInHeart [lid=" + lid + ", lname=" + lname + ", lsex=" + lsex + ", ltime=" + ltime + ", lmoney="
				+ lmoney + "]";
	}

}
