package qpf.Bridge;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import qpf.Template_Method.DBOperator;
import qpf.Template_Method.DBOperatorSubA;

//定义Implementor接口的实现类A
//银行内转账
public class ConcreateImplementorA implements Implementor {
	//String cardID1 操作者卡号
	//String cardID2 转账目标卡号
    public void operation(String cardID1,String cardID2,long amount) throws SQLException {
         //System.out.println("this is concreteImplementorA's operation...");
    	
    	
    	//获取当前时间
    	Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=dateFormat.format(date);
    	
		
    	DBOperator db;
		db=new DBOperatorSubA();
		Statement stmt =DBOperator.createStmt(db.connDB()); //查询
		//操作者卡号信息变更
		//设置交易账号
		SimpleDateFormat dateFormat1= new SimpleDateFormat("HHmmss");
		String transID1=dateFormat1.format(date);
		stmt.executeUpdate("update cardInfo set balance=balance-"+amount+"where cardID="+cardID1);
		String remark1="转出金额"+amount;
//		stmt.executeUpdate("insert into transInfo(transID,cardID,transMoney,transDate,transType,remark)values('122201','1234567890987654321','3','2019-12-12','5','6')");    
		stmt.executeUpdate("insert into transInfo(transID,cardID,transMoney,transDate,transType,remark)values('"+transID1+"','"+cardID1+"','"+amount+"','"+time+"','转账','"+remark1+"')");    
   
		// 转账目标卡号信息变更
		//设置交易账号
		SimpleDateFormat dateFormat2= new SimpleDateFormat("99"+"mmss");
		String transID2=dateFormat2.format(date);
		stmt.executeUpdate("update cardInfo set balance=balance+"+amount+"where cardID="+cardID2);
		String remark2="转入金额"+amount;
		stmt.executeUpdate("insert into transInfo(transID,cardID,transMoney,transDate,transType,remark)values('"+transID2+"','"+cardID2+"','"+amount+"','"+time+"','转账','"+remark2+"')");    
		   
    
    }

 }
