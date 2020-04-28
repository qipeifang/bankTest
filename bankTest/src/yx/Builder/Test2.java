package yx.Builder;

import java.util.Scanner;

public class Test2 {
	public static void main(String args[]) throws Exception
	{
		zhuce();
	}

	public static void zhuce() throws Exception
	{
		String accountID = " ";
		String customerID = " ";
		Scanner sc = new Scanner(System.in);
		while(accountID.length() != 10) {
			System.out.print("请输入账号（10个字符）：");
	        accountID = sc.nextLine();
		}
        System.out.print("请输入密码（少于等于6个字符）：");
        String accountPassword = sc.nextLine();
        while(customerID.length() != 8) {
        	System.out.print("请输入客户号（8个字符）：");
            customerID = sc.nextLine();
		}
        System.out.print("请输入名字：");
        String customerName = sc.nextLine();
        System.out.print("请输入身份证号（18位）：");
        String pID = sc.nextLine();
        System.out.print("请输入电话（少于等于11个字符）：");
        String telephone = sc.nextLine();
        System.out.print("请输入地址：");
        String address = sc.nextLine();
        
        RegisterConcreteBuilder rcb = new RegisterConcreteBuilder();
		RegisterBuilder rb = rcb;
		Director director = new Director();
		if(director.register(accountID, accountPassword, customerID, customerName, pID,
				telephone, address))  //判断是否实现数据库插入
		{
			director.setRegisterBuilder(rb);
		    Register register = director.construct(accountID, accountPassword,customerID,
		    		customerName, pID, telephone, address);
		    System.out.print("注册成功！");
		}
		else
		{
			System.out.print("注册失败！");
		}
		
	}
}
