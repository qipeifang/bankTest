package qpf.Bridge;

import java.sql.SQLException;
import java.sql.Statement;

import qpf.Template_Method.DBOperator;
import qpf.Template_Method.DBOperatorSubA;

public class InOrOut {
	public static void operation(String cardID1,String cardID2,long amount) throws SQLException {
		Abstraction abstraction = new RefinedAbstraction();
		DBOperator db;
		db=new DBOperatorSubA();
		Statement stmt =DBOperator.createStmt(db.connDB()); //��ѯ
		//ִ��SQL,����booleanֵ��ʾ�Ƿ����ResultSet 
        boolean hasResultSet =stmt.execute("select cardID from cardInfo where cardID="+cardID2);
        if (hasResultSet){
        	//������ת��
        	abstraction.setImplementor(new ConcreateImplementorA());
    	    abstraction.operation(cardID1,cardID2,amount);
        }
        else{
        	//���м�ת��
        	abstraction.setImplementor(new ConcreateImplementorB());
      	    abstraction.operation(cardID1,cardID2,amount);
        }
	}
}
