package qpf.Bridge;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import qpf.Template_Method.DBOperator;
import qpf.Template_Method.DBOperatorSubA;

//定义Implementor接口的实现类B
//银行间转账
public class ConcreateImplementorB implements Implementor {
	//String cardID1 操作者卡号
	//String cardID2 转账目标卡号
     public void operation(String cardID1,String cardID2,long amount) throws SQLException {
         //System.out.println("this is concreteImplementorB's operation...");
    	
    	//获取当前时间
    	Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=dateFormat.format(date);
    	//设置交易账号
		SimpleDateFormat dateFormat2= new SimpleDateFormat("HHmmss");
		String transID=dateFormat2.format(date);
		
    	DBOperator db;
		db=new DBOperatorSubA();
		Statement stmt =DBOperator.createStmt(db.connDB()); //查询
		stmt.executeUpdate("update cardInfo set balance=balance-"+amount*1.002+"where cardID="+cardID1);//银行间转账扣除0.2%的手续费
		String remark="转出金额"+amount;
//		stmt.executeUpdate("insert into transInfo(transID,cardID,transMoney,transDate,transType,remark)values('122201','1234567890987654321','3','2019-12-12','5','6')");    
		stmt.executeUpdate("insert into transInfo(transID,cardID,transMoney,transDate,transType,remark)values('"+transID+"','"+cardID1+"','"+amount+"','"+time+"','转账','"+remark+"')"); 
     
     }
 }
