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
			System.out.print("�������˺ţ�10���ַ�����");
	        accountID = sc.nextLine();
		}
        System.out.print("���������루���ڵ���6���ַ�����");
        String accountPassword = sc.nextLine();
        while(customerID.length() != 8) {
        	System.out.print("������ͻ��ţ�8���ַ�����");
            customerID = sc.nextLine();
		}
        System.out.print("���������֣�");
        String customerName = sc.nextLine();
        System.out.print("���������֤�ţ�18λ����");
        String pID = sc.nextLine();
        System.out.print("������绰�����ڵ���11���ַ�����");
        String telephone = sc.nextLine();
        System.out.print("�������ַ��");
        String address = sc.nextLine();
        
        RegisterConcreteBuilder rcb = new RegisterConcreteBuilder();
		RegisterBuilder rb = rcb;
		Director director = new Director();
		if(director.register(accountID, accountPassword, customerID, customerName, pID,
				telephone, address))  //�ж��Ƿ�ʵ�����ݿ����
		{
			director.setRegisterBuilder(rb);
		    Register register = director.construct(accountID, accountPassword,customerID,
		    		customerName, pID, telephone, address);
		    System.out.print("ע��ɹ���");
		}
		else
		{
			System.out.print("ע��ʧ�ܣ�");
		}
		
	}
}
