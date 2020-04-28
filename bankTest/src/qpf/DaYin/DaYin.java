package qpf.DaYin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import qpf.FactoryMethod.JDBCUtils;
import qpf.Template_Method.DBOperator;
import qpf.Template_Method.DBOperatorSubA;

public class DaYin {
	public static void display(String cardID) throws SQLException{
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("HH");
		String time=dateFormat.format(date);
		
		DBOperator db;
		db=new DBOperatorSubA();
		Statement stmt =DBOperator.createStmt(db.connDB()); //查询
		ResultSet rs=stmt.executeQuery("select * from transInfo where transID like '"+time+"%' and cardID="+cardID);
		
		while(rs.next()){
			System.out.println("##########打印凭条##########"+"\n"+
							   "交易ID："+rs.getString(1) + "  " + "\n"+
							   "交易卡号："+rs.getString(2)+ "  " + "\n"+ 
							   "交易金额："+rs.getString(3)+ "  " + "\n"+   
							   "交易时间："+rs.getString(4)+ "  " + "\n"+  
							   "交易类型："+rs.getString(5)+ "  " + "\n"+  
							   "交易描述："+rs.getString(6)); 
		}
		
		
		
		
		
	}
}
