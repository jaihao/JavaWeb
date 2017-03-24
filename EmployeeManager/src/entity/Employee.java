package entity;
/**
 * 
 eid ;-编号	<br>
ename;--员工名称<br>
eage;--员工年龄<br>
esex;--员工性别<br>
 eemail;--员工邮箱	<br>
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
