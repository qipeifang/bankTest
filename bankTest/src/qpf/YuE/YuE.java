package qpf.YuE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import qpf.Template_Method.DBOperator;
import qpf.Template_Method.DBOperatorSubA;

public class YuE {
	public static void getBalance(String cardID) throws SQLException{
		DBOperator db;
		db=new DBOperatorSubA();
		Statement stmt =DBOperator.createStmt(db.connDB()); //��ѯ
		ResultSet rs=stmt.executeQuery("select balance from cardInfo where cardID="+cardID);
		while(rs.next()){
			System.out.println("��"+rs.getString(1)); 
		}
	}
}

	
