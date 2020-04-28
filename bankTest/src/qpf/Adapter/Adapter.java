package qpf.Adapter;

import java.sql.SQLException;
import java.sql.Statement;

import qpf.Template_Method.DBOperator;
import qpf.Template_Method.DBOperatorSubA;

/**
 * 怎么才可以在目标接口中的 request() 调用 Adaptee 的 adapteeRequest() 方法呢？
 * 通过一个适配器类，实现 Target 接口，
 * 同时继承了 Adaptee 类，
 * 然后在实现的 request() 方法中调用
 * 父类的 adapteeRequest() 即可实现
 */

/**
 * Adapter（适配器类）：适配器可以调用另一个接口，作为一个转换器，
 * 对Adaptee和Target进行适配，适配器类是适配器模式的核心，
 * 在对象适配器中，它通过继承Target并关联一个Adaptee对象使二者产生联系。
 */

public class Adapter extends Adaptee implements Target{
   // @Override
    public void request(String cardID, String cardPassword) throws SQLException {
    	 DBOperator db1;
 		db1=new DBOperatorSubA();
 		Statement stmt =DBOperator.createStmt(db1.connDB()); //查询
 		//stmt.executeUpdate("update account set accountPassword="+accountPassword+"where accountID="+accountID);
 		stmt.executeUpdate("update cardInfo set cardPassword="+cardPassword+"where cardID="+cardID);
 		System.out.println("密码修改成功！");
        //...一些操作...
        super.adapteeRequest();
        //...一些操作...
    }

//	@Override
//	public void request() {
//		// TODO Auto-generated method stub
//		
//	}
}