package com.nf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nf.entity.Dromitory;

public class DromitoryDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	/**
	 * 查询所有学生
	 */
	public List<Dromitory> getALLDromitory(){
		List<Dromitory> list =new ArrayList<Dromitory>();
		String sql="select * from dromitory";
		try {
			conn=BaseDao.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Dromitory d =new Dromitory();
				d.setDromitoryId(rs.getString("dromitoryId"));
				d.setStuName(rs.getString("stuName"));
				d.setStuSex(rs.getString("stuSex"));
				d.setClsName(rs.getString("clsName"));
				d.setInDate(rs.getTimestamp("inDate"));
				d.setBedNo(rs.getInt("bedNo"));
				list.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(rs, ps, conn);
		}
		return list;
	}
	
	
	/**
	 * 添加信息
	 */
	public boolean addDromitory(Dromitory d){
		boolean bl=false;
		String sql="insert dromitory (dromitoryId,stuName,stuSex,clsName,inDate,bedNo) values(?,?,?,?,?,?)";
		try {
			conn=BaseDao.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1, d.getDromitoryId());
			ps.setString(2, d.getStuName());
			ps.setString(3, d.getStuSex());
			ps.setString(4, d.getClsName());
			ps.setDate(5, new java.sql.Date(d.getInDate().getTime()));
			ps.setInt(6, d.getBedNo());
			bl=ps.executeUpdate()>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(null, ps, conn);
		}
		return bl;
	}
}
