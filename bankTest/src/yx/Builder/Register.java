package yx.Builder;

import yx.Singleton.Account;
import yx.Singleton.Customer;

public class Register {
	private Account account;
	private Customer customer;
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
