package entity;
/**
 * 
 eid ;-���	<br>
ename;--Ա������<br>
eage;--Ա������<br>
esex;--Ա���Ա�<br>
 eemail;--Ա������	<br>
 *
 */
public class Employee {
	private int eid ;
	private String ename;
	private int eage;
	private int esex;
	private String eemail;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEage() {
		return eage;
	}
	public void setEage(int eage) {
		this.eage = eage;
	}
	public int getEsex() {
		return esex;
	}
	public void setEsex(int esex) {
		this.esex = esex;
	}
	public String getEemail() {
		return eemail;
	}
	public void setEemail(String eemail) {
		this.eemail = eemail;
	}
	
	
}
