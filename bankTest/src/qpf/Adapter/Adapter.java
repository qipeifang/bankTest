package qpf.Adapter;

import java.sql.SQLException;
import java.sql.Statement;

import qpf.Template_Method.DBOperator;
import qpf.Template_Method.DBOperatorSubA;

/**
 * ��ô�ſ�����Ŀ��ӿ��е� request() ���� Adaptee �� adapteeRequest() �����أ�
 * ͨ��һ���������࣬ʵ�� Target �ӿڣ�
 * ͬʱ�̳��� Adaptee �࣬
 * Ȼ����ʵ�ֵ� request() �����е���
 * ����� adapteeRequest() ����ʵ��
 */

/**
 * Adapter���������ࣩ�����������Ե�����һ���ӿڣ���Ϊһ��ת������
 * ��Adaptee��Target�������䣬����������������ģʽ�ĺ��ģ�
 * �ڶ����������У���ͨ���̳�Target������һ��Adaptee����ʹ���߲�����ϵ��
 */

public class Adapter extends Adaptee implements Target{
   // @Override
    public void request(String cardID, String cardPassword) throws SQLException {
    	 DBOperator db1;
 		db1=new DBOperatorSubA();
 		Statement stmt =DBOperator.createStmt(db1.connDB()); //��ѯ
 		//stmt.executeUpdate("update account set accountPassword="+accountPassword+"where accountID="+accountID);
 		stmt.executeUpdate("update cardInfo set cardPassword="+cardPassword+"where cardID="+cardID);
 		System.out.println("�����޸ĳɹ���");
        //...һЩ����...
        super.adapteeRequest();
        //...һЩ����...
    }

//	@Override
//	public void request() {
//		// TODO Auto-generated method stub
//		
//	}
}