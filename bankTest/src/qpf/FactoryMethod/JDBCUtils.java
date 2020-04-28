package qpf.FactoryMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	 
	
    public static final String DIVERCLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public  static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=bankDB";
    public static  final String USER = "sa";
    public static  final String PASSWORD = "123";
 
    //每次别人获取连接的时候，都需要加载该类。但是一个类只需要加载一次就够了。静态代码块只需要执行一次。
    static {
        try {
            Class.forName(DIVERCLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
 
    //连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
           connection = DriverManager.getConnection(URL,USER,PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
 
    //关闭资源
    public static void close(ResultSet rs, Statement  st,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}