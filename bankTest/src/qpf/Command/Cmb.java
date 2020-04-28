package qpf.Command;

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

public class Cmb {
	public void saveMoney(long amount, String cardID) throws SQLException {
		System.out.println("�����д����" + amount);
		/*
		//��ȡ����
        Connection connection = JDBCUtils.getConnection();
        //��ȡSQL������
        String sql = "update cardInfo set balance=balance+"+amount;
        //�õ�Ԥ�������
        PreparedStatement pst = connection.prepareStatement(sql);
       
        //ִ��SQL
        int rs = pst.executeUpdate();
       // return rs.next();
      
        */
        
        
        DBOperator db;
		db=new DBOperatorSubA();
		Statement stmt =DBOperator.createStmt(db.connDB()); //��ѯ
		stmt.executeUpdate("update cardInfo set balance=balance+"+amount+"where cardID="+cardID);
		
		Date date = new Date();
		SimpleDateFormat dateFormat1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=dateFormat1.format(date);
		//���ý����˺�
		SimpleDateFormat dateFormat2= new SimpleDateFormat("HHmmss");
		String transID=dateFormat2.format(date);
		String remark="������"+amount;
		stmt.executeUpdate("insert into transInfo(transID,cardID,transMoney,transDate,transType,remark)values('"+transID+"','"+cardID+"','"+amount+"','"+time+"','���','"+remark+"')");    
		   
        
	}
	public void getMoney(long amount,String cardID) throws SQLException {
		System.out.println("������ȡ����" + amount);
//		Connection connection = JDBCUtils.getConnection();
//	    //��ȡSQL������
//	    String sql = "update cardInfo set balance=balance-"+amount;
//	    //�õ�Ԥ�������
//	    PreparedStatement pst = connection.prepareStatement(sql);
//	       
//	     //ִ��SQL
//	    int rs = pst.executeUpdate();
//	     // return rs.next();
		
		 DBOperator db;
		 db=new DBOperatorSubA();
		 Statement stmt =DBOperator.createStmt(db.connDB()); //��ѯ
		 stmt.executeUpdate("update cardInfo set balance=balance-"+amount+"where cardID="+cardID);
			
		 Date date = new Date();
		 SimpleDateFormat dateFormat1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String time=dateFormat1.format(date);
		 //���ý����˺�
		 SimpleDateFormat dateFormat2= new SimpleDateFormat("HHmmss");
		 String transID=dateFormat2.format(date);
		 String remark="ȡ�����"+amount;
		 stmt.executeUpdate("insert into transInfo(transID,cardID,transMoney,transDate,transType,remark)values('"+transID+"','"+cardID+"','"+amount+"','"+time+"','ȡ��','"+remark+"')");    
			   
		
	}
}
