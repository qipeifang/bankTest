package yx.Singleton;

public class Customer {
	private String customerID;  //�ͻ�ID
	private String customerName;   //����
	private String PID;   //���֤��
	private String telephone;   //�绰
	private String address;    //��ַ
	private String accountID;   //�˺�
	
	//���캯��
	public Customer(String customerID,String customerName,
			String pID,String telephone,String address,String accountID) {
		this.customerID = customerID;
		this.customerName = customerName;
		PID = pID;
		this.telephone = telephone;
		this.address = address;
		this.accountID = accountID;
	}
	
	//get��set����
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPID() {
		return PID;
	}
	public void setPID(String pID) {
		PID = pID;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	
	

}
