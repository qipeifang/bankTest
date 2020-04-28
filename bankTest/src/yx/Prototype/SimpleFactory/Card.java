package yx.Prototype.SimpleFactory;

public class Card {  //储蓄卡
	private String cardID;  //银行卡号
	private String cardPassword;   //银行卡密码
	private String customerID;   //客户ID
	private String openDate;    //开卡时间
	private int openMoney;   //开卡金额
	private int balance;   //余额
	private int isReportLoss;   //是否遗失
	
	public Card(String cardID,String cardPassword,String customerID,String openDate,int openMoney,
			int balance,int isReportLoss) {
		this.cardID = cardID;
		this.cardPassword = cardPassword;
		this.customerID = customerID;
		this.openDate = openDate;
		this.openMoney = openMoney;
		this.balance = balance;
		this.isReportLoss = isReportLoss;
	}
	
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public Object clone()  //复制函数
	{
		Card clone=null;
		try
		{
			clone=(Card)super.clone();		
		}
        catch(CloneNotSupportedException e)
        {
        	System.out.println("Clone failure!");
        }
		return clone;
	}
	
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getCardPassword() {
		return cardPassword;
	}
	public void setCardPassword(String cardPassword) {
		this.cardPassword = cardPassword;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public int getOpenMoney() {
		return openMoney;
	}
	public void setOpenMoney(int openMoney) {
		this.openMoney = openMoney;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getIsReportLoss() {
		return isReportLoss;
	}
	public void setIsReportLoss(int isReportLoss) {
		this.isReportLoss = isReportLoss;
	}
	 
}
