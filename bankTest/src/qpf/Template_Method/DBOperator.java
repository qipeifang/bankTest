package qpf.Template_Method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DBOperator {
	public abstract Connection connDB();
	
	public static Statement createStmt(Connection conn) {
		Statement stmt = null;
		try 
		{
			stmt = conn.createStatement();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return stmt;
	}
	
	public static ResultSet executeQuery(Statement stmt, String sql) {
		ResultSet rs = null;
		try 
		{
			rs = stmt.executeQuery(sql);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet executeQuery(PreparedStatement preparedstmt)
	{
		ResultSet rs = null;
		try {
			rs = preparedstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public static PreparedStatement prepareStmt(Connection conn, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt) {
		if (stmt != null) 
		{
			try 
			{
				stmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) 
	{
		if (rs != null) 
		{
			try {
				rs.close();
				}
			catch (SQLException e) 
				{
				e.printStackTrace();
				}
		}
	}
	
	
  /* public void process(Statement stmt, String sql)
   {
    connDB();//连接数据库
   	//openDB();//打开数据库
   	//useDB();//使用数据库
  	//closeDB(connDB());//关闭数据库
    
   }*/
}
