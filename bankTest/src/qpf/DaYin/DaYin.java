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
		Statement stmt =DBOperator.createStmt(db.connDB()); //��ѯ
		ResultSet rs=stmt.executeQuery("select * from transInfo where transID like '"+time+"%' and cardID="+cardID);
		
		while(rs.next()){
			System.out.println("##########��ӡƾ��##########"+"\n"+
							   "����ID��"+rs.getString(1) + "  " + "\n"+
							   "���׿��ţ�"+rs.getString(2)+ "  " + "\n"+ 
							   "���׽�"+rs.getString(3)+ "  " + "\n"+   
							   "����ʱ�䣺"+rs.getString(4)+ "  " + "\n"+  
							   "�������ͣ�"+rs.getString(5)+ "  " + "\n"+  
							   "����������"+rs.getString(6)); 
		}
		
		
		
		
		
	}
}
