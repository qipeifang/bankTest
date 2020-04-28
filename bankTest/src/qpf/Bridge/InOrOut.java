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
		Statement stmt =DBOperator.createStmt(db.connDB()); //查询
		//执行SQL,返回boolean值表示是否包含ResultSet 
        boolean hasResultSet =stmt.execute("select cardID from cardInfo where cardID="+cardID2);
        if (hasResultSet){
        	//银行内转账
        	abstraction.setImplementor(new ConcreateImplementorA());
    	    abstraction.operation(cardID1,cardID2,amount);
        }
        else{
        	//银行间转账
        	abstraction.setImplementor(new ConcreateImplementorB());
      	    abstraction.operation(cardID1,cardID2,amount);
        }
	}
}
