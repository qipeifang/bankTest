package yx.Singleton;

public class Account {
	private String accountID;    //账号
	private String accountPassword;    //密码
	
	//构造函数
	public Account(String accountID,String accountPassword) {
		this.accountID = accountID;
		this.accountPassword = accountPassword;
	}
	
	//get和set函数
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
