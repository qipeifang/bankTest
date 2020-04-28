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
		System.out.println("向银行存入金额：" + amount);
		/*
		//获取对象
        Connection connection = JDBCUtils.getConnection();
        //获取SQL运输器
        String sql = "update cardInfo set balance=balance+"+amount;
        //得到预编译对象
        PreparedStatement pst = connection.prepareStatement(sql);
       
        //执行SQL
        int rs = pst.executeUpdate();
       // return rs.next();
      
        */
        
        
        DBOperator db;
		db=new DBOperatorSubA();
		Statement stmt =DBOperator.createStmt(db.connDB()); //查询
		stmt.executeUpdate("update cardInfo set balance=balance+"+amount+"where cardID="+cardID);
		
		Date date = new Date();
		SimpleDateFormat dateFormat1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=dateFormat1.format(date);
		//设置交易账号
		SimpleDateFormat dateFormat2= new SimpleDateFormat("HHmmss");
		String transID=dateFormat2.format(date);
		String remark="存入金额"+amount;
		stmt.executeUpdate("insert into transInfo(transID,cardID,transMoney,transDate,transType,remark)values('"+transID+"','"+cardID+"','"+amount+"','"+time+"','存款','"+remark+"')");    
		   
        
	}
	public void getMoney(long amount,String cardID) throws SQLException {
		System.out.println("从银行取出金额：" + amount);
//		Connection connection = JDBCUtils.getConnection();
//	    //获取SQL运输器
//	    String sql = "update cardInfo set balance=balance-"+amount;
//	    //得到预编译对象
//	    PreparedStatement pst = connection.prepareStatement(sql);
//	       
//	     //执行SQL
//	    int rs = pst.executeUpdate();
//	     // return rs.next();
		
		 DBOperator db;
		 db=new DBOperatorSubA();
		 Statement stmt =DBOperator.createStmt(db.connDB()); //查询
		 stmt.executeUpdate("update cardInfo set balance=balance-"+amount+"where cardID="+cardID);
			
		 Date date = new Date();
		 SimpleDateFormat dateFormat1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String time=dateFormat1.format(date);
		 //设置交易账号
		 SimpleDateFormat dateFormat2= new SimpleDateFormat("HHmmss");
		 String transID=dateFormat2.format(date);
		 String remark="取出金额"+amount;
		 stmt.executeUpdate("insert into transInfo(transID,cardID,transMoney,transDate,transType,remark)values('"+transID+"','"+cardID+"','"+amount+"','"+time+"','取款','"+remark+"')");    
			   
		
	}
}
