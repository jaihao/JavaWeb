package com.nf.entity;

import java.util.Date;

public class Dromitory {
	String  dromitoryId ;
	String stuName;
	String stuSex;
	String clsName;
	Date inDate;
	int bedNo;
	public String getDromitoryId() {
		return dromitoryId;
	}
	public void setDromitoryId(String dromitoryId) {
		this.dromitoryId = dromitoryId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public String getClsName() {
		return clsName;
	}
	public void setClsName(String clsName) {
		this.clsName = clsName;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public int getBedNo() {
		return bedNo;
	}
	public void setBedNo(int bedNo) {
		this.bedNo = bedNo;
	}
	
}
