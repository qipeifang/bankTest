package yx.Singleton;

public class Account {
	private String accountID;    //�˺�
	private String accountPassword;    //����
	
	//���캯��
	public Account(String accountID,String accountPassword) {
		this.accountID = accountID;
		this.accountPassword = accountPassword;
	}
	
	//get��set����
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	
}
