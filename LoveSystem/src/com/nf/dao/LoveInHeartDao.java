package com.nf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nf.entity.LoveInHeart;
	

public class LoveInHeartDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	/**
	 * 显示所有信息
	 * @return
	 */
	public List<LoveInHeart> getLoveList(){
		List<LoveInHeart> list =new ArrayList<LoveInHeart>();
		String sql="select lid,lname,lsex,ltime,lmoney from LoveInHeart order by lmoney desc";
		try {
			conn=BaseDao.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				LoveInHeart l=new LoveInHeart();
				l.setLid(rs.getInt("lid"));
				l.setLname(rs.getString("lname"));
				l.setLsex(rs.getString("lsex"));
				l.setLmoney(rs.getDouble("lmoney"));
				l.setLtime(rs.getDate("ltime"));
				list.add(l);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(rs, ps, conn);
		}
		return list;
	}
	/**
	 * 添加
	 * @param love
	 * @return
	 */
	public boolean addLoveInHeart (LoveInHeart love){
		boolean bl=false;
		String sql="insert LoveInHeart(lname,lsex,ltime,lmoney) values(?,?,?,?)";
		try {
			conn=BaseDao.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1, love.getLname());
			ps.setString(2, love.getLsex());
			ps.setDate(3, new java.sql.Date(love.getLtime().getTime()));
			ps.setDouble(4, love.getLmoney());
			bl = ps.executeUpdate()>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(null, ps, conn);
		}
		return bl;
	}
}
