package yx.Singleton;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) throws Exception {
		denglu();
	}



    public static void denglu()throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("�������˺ţ�");
        String accountID = sc.nextLine();
        System.out.print("���������룺");
        String accountPassword = sc.nextLine();
        boolean flag = Login.login(accountID,accountPassword);
        if(flag){
        	
    	    Login login;
    	    login = Login.getinstance(accountID, accountPassword);
    	    }
        else {
        	System.out.println("�˺Ŵ�������������˺Ų����ڣ������µ�¼��");
        	
        	}
    }

}

