package yx.Builder;

public abstract class RegisterBuilder {
	protected Register register = new Register();
	public abstract void buildAccount(String accountID,String accountPassword);
	public abstract void buildCustomer(String customerID,String customerName,
			String pID,String telephone,String address,String accountID);
	
	public Register getMeal()
	{
		return register;
	}

}
