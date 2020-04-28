package qpf.Bridge;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import qpf.Template_Method.DBOperator;
import qpf.Template_Method.DBOperatorSubA;

//����Implementor�ӿڵ�ʵ����A
//������ת��
public class ConcreateImplementorA implements Implementor {
	//String cardID1 �����߿���
	//String cardID2 ת��Ŀ�꿨��
    public void operation(String cardID1,String cardID2,long amount) throws SQLException {
         //System.out.println("this is concreteImplementorA's operation...");
    	
    	
    	//��ȡ��ǰʱ��
    	Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=dateFormat.format(date);
    	
		
    	DBOperator db;
		db=new DBOperatorSubA();
		Statement stmt =DBOperator.createStmt(db.connDB()); //��ѯ
		//�����߿�����Ϣ���
		//���ý����˺�
		SimpleDateFormat dateFormat1= new SimpleDateFormat("HHmmss");
		String transID1=dateFormat1.format(date);
		stmt.executeUpdate("update cardInfo set balance=balance-"+amount+"where cardID="+cardID1);
		String remark1="ת�����"+amount;
//		stmt.executeUpdate("insert into transInfo(transID,cardID,transMoney,transDate,transType,remark)values('122201','1234567890987654321','3','2019-12-12','5','6')");    
		stmt.executeUpdate("insert into transInfo(transID,cardID,transMoney,transDate,transType,remark)values('"+transID1+"','"+cardID1+"','"+amount+"','"+time+"','ת��','"+remark1+"')");    
   
		// ת��Ŀ�꿨����Ϣ���
		//���ý����˺�
		SimpleDateFormat dateFormat2= new SimpleDateFormat("99"+"mmss");
		String transID2=dateFormat2.format(date);
		stmt.executeUpdate("update cardInfo set balance=balance+"+amount+"where cardID="+cardID2);
		String remark2="ת����"+amount;
		stmt.executeUpdate("insert into transInfo(transID,cardID,transMoney,transDate,transType,remark)values('"+transID2+"','"+cardID2+"','"+amount+"','"+time+"','ת��','"+remark2+"')");    
		   
    
    }

 }
