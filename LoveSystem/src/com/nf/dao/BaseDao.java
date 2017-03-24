package com.nf.dao;
import java.sql.*;
/**
 * <h2>自定义一个数据库操作的工具类</h2>
 * 可以获取连接getCon();<br>
 * 可以关闭所有数据库连接资源closeAll();<br>
 * 可以执行非查询sql语句.<br>
 * @author mach
 *
 */
public class BaseDao {
	// 驱动
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// 连接字符串,"jdbc:sqlserver"协议，"localhost"数据库连接地址,"1433"数据服务端口号,"nf"要连接的数据库名
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=LoveDB";
	// sql登录账号
	private static String uid = "sa";
	// sql登录密码
	private static String pwd = "12345";
	/** 
	 * 静态代码块来加载驱动,自动运行，并只执行一次
	 * */
	static {
		try {
			Class.forName(driver);// 加载驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库的连接对象
	 * 
	 * @return 返回数据库连接对象
	 */
	public static Connection getCon() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, uid, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 执行增,删,改(insert, delete, update)SQL语句
	 * 
	 * @param sql 非查询sql语句
	 * @return 返回受影响的行
	 */
	public static int update(String sql) {
		int row = 0;
		Connection conn = getCon();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			row = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, stmt, conn);
		}
		return row;
	}

	/**
	 * 关闭并释放数据库连接的相关资源
	 * @param rs 结果集，只有查询时才有结果集，没有结果集可关闭，可以传参数null
	 * @param stmt 语句对象
	 * @param conn　连接对象
	 */
	public static void closeAll(ResultSet rs, Statement stmt, Connection conn){
		try {
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 测试数据连接是否成功!
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		Connection conn = getCon();
		System.out.println(conn);//显示：ConnectionID:1  表示连接成功!
		conn.close();			
	}
}
