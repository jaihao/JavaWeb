package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;

public class EmployeeDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	/**
	 * 显示所有员工
	 * @return
	 */
	public List<Employee> getAll(){
		List<Employee> list =new ArrayList<Employee>();
		String sql="select * from Employee";
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Employee e=new Employee();
				e.setEid(rs.getInt("eid"));
				e.setEname(rs.getString("ename"));
				e.setEage(rs.getInt("eage"));
				e.setEsex(rs.getInt("esex"));
				e.setEemail(rs.getString("eemail"));
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace( );
		}finally{
			DBUitl.closeAll(rs, ps, conn);
		}
		return list;
	}
	/**
	 * 添加员工
	 * @param em
	 * @return
	 */
	public boolean addEmployee(Employee em){
		boolean bl=false;
		String sql="insert Employee(ename,eage,esex,eemail) values(?,?,?,?)";
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1, em.getEname());
			ps.setInt(2, em.getEage());
			ps.setInt(3, em.getEsex());
			ps.setString(4, em.getEemail());
			bl=ps.executeUpdate()>0;
		} catch (Exception e) {
			e.printStackTrace( );
		}finally{
			DBUitl.closeAll(null, ps, conn);
		}
		return bl;
	}
}
