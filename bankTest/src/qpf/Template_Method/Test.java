package qpf.Template_Method;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Test {

	public static void main(String[] args) throws SQLException {
		DBOperator db1;
		db1=new DBOperatorSubA();
//		db1.process(db1.connDB(), null);
		//System.out.println("---------------------------------------");			
//		db1=new DBOperatorSubB();
		//db1.process();
		Statement stmt =DBOperator.createStmt(db1.connDB()); //��ѯ
//		ResultSet rs = null; //�õ�������
		stmt.executeUpdate("update cardInfo set balance=balance+"+9);
		
		
	}

}
