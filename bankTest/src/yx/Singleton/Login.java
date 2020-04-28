package yx.Singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
	private static Login instance = null;
	private Account account;
	private LoginState state;
	
	//���캯��
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
			System.out.println("��ϲ"+accountID+"��¼�ɹ�");
		}
		else {
			System.out.println("�ѵ�¼�������ظ���¼��");  
		}
		return instance;
	}
	
	//�ж��˺��Ƿ����
	public static boolean login(String accountID,String accountPassword) throws Exception {
        //��ȡ����
        Connection connection = qpf.FactoryMethod.JDBCUtils.getConnection();
        //��ȡSQL������
        String sql = "select*from account where accountID=? and accountPassword=?";
        //�õ�Ԥ�������
        PreparedStatement pst = connection.prepareStatement(sql);
        //������ֵ
        pst.setString(1,accountID);
        pst.setString(2,accountPassword);
        //ִ��SQL
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
