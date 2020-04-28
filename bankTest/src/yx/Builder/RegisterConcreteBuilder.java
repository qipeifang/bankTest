package yx.Builder;

import yx.Singleton.Account;
import yx.Singleton.Customer;

public class RegisterConcreteBuilder extends RegisterBuilder {
	
	public void buildAccount(String accountID,String accountPassword) {
		Account acc = new Account(accountID,accountPassword);
		register.setAccount(acc);
	}
	
	public void buildCustomer(String customerID,String customerName,
			String pID,String telephone,String address,String accountID) {
		Customer cus = new Customer(customerID,customerName,pID,telephone,address,accountID);
		register.setCustomer(cus);
	}
	
}
