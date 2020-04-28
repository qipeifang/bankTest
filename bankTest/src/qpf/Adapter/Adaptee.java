package qpf.Adapter;
//一个已存在的将被适配的类

/**
 * Adaptee（适配者类）：适配者即被适配的角色，
 * 它定义了一个已经存在的接口，
 * 这个接口需要适配，适配者类一般是一个具体类，
 * 包含了客户希望使用的业务方法，
 * 在某些情况下可能没有适配者类的源代码。
 */
public class Adaptee {
	public void adapteeRequest(){
       // System.out.println("被适配者的方法");
//        DBOperator db1;
//		db1=new DBOperatorSubA();
//		Statement stmt =DBOperator.createStmt(db1.connDB()); //查询
//		stmt.executeUpdate("update account set accountPassword="+accountPassword+"where accountID="+accountID);
    }
}