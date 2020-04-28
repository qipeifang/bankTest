package qpf.Bridge;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import qpf.Template_Method.DBOperator;
import qpf.Template_Method.DBOperatorSubA;

//����Implementor�ӿڵ�ʵ����B
//���м�ת��
public class ConcreateImplementorB implements Implementor {
	//String cardID1 �����߿���
	//String cardID2 ת��Ŀ�꿨��
     public void operation(String cardID1,String cardID2,long amount) throws SQLException {
         //System.out.println("this is concreteImplementorB's operation...");
    	
    	//��ȡ��ǰʱ��
    	Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=dateFormat.format(date);
    	//���ý����˺�
		SimpleDateFormat dateFormat2= new SimpleDateFormat("HHmmss");
		String transID=dateFormat2.format(date);
		
    	DBOperator db;
		db=new DBOperatorSubA();
		Statement stmt =DBOperator.createStmt(db.connDB()); //��ѯ
		stmt.executeUpdate("update cardInfo set balance=balance-"+amount*1.002+"where cardID="+cardID1);//���м�ת�˿۳�0.2%��������
		String remark="ת�����"+amount;
//		stmt.executeUpdate("insert into transInfo(transID,cardID,transMoney,transDate,transType,remark)values('122201','1234567890987654321','3','2019-12-12','5','6')");    
		stmt.executeUpdate("insert into transInfo(transID,cardID,transMoney,transDate,transType,remark)values('"+transID+"','"+cardID1+"','"+amount+"','"+time+"','ת��','"+remark+"')"); 
     
     }
 }
