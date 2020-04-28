package yx.Singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
	private static Login instance = null;
	private Account account;
	private LoginState state;
	
	//构造函数
	private Login(String accountID,String accountPassword) {
		this.account = new Account(accountID,accountPassword);
		this.state = new LogonState(this);
	}

	public void setState(LoginState state) {
		this.state = state;
	}

	public static Login getinstance(String accountID,String accountPassword) {
		if(instance == null) {
			instance = new Login(accountID,accountPassword);
			System.out.println("恭喜"+accountID+"登录成功");
		}
		else {
			System.out.println("已登录，不可重复登录。");  
		}
		return instance;
	}
	
	//判断账号是否存在
	public static boolean login(String accountID,String accountPassword) throws Exception {
        //获取对象
        Connection connection = qpf.FactoryMethod.JDBCUtils.getConnection();
        //获取SQL运输器
        String sql = "select*from account where accountID=? and accountPassword=?";
        //得到预编译对象
        PreparedStatement pst = connection.prepareStatement(sql);
        //给？赋值
        pst.setString(1,accountID);
        pst.setString(2,accountPassword);
        //执行SQL
        ResultSet rs = pst.executeQuery();
        return rs.next();
    }

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	public void optCard() throws Exception
	{
		state.optCard();
	}
	public void exit()
	{
		state.exit();
	}
	public void activateCard() throws Exception
	{
		state.activateCard();
	}
	public void post() throws Exception
	{
		state.post();
	}

}
