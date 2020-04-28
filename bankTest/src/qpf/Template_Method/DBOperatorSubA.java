package qpf.Template_Method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBOperatorSubA extends DBOperator
{
//	 public static final String DIVERCLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	 public  static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=bankDB";
//	 public static  final String USER = "sa";
//	 public static  final String PASSWORD = "123";
	public Connection connDB()
	{
		//System.out.println("使用JDBC-ODBC桥接连接数据库");		
		Connection conn = null;
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=bankDB", "sa", "123");
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
