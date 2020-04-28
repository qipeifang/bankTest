package qpf.Adapter;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws SQLException {
//        Target target = new ConcreteTarget();
//        target.request("2019101010","333333");

//        Target adapterTarget = new Adapter();
//        adapterTarget.request("2019101010","333446");
        
        
        System.out.println("输入新密码：");
        Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		Target adapterTarget = new Adapter();
        adapterTarget.request("1111111111111111111",name);
    }
	public static void xgPwd(String cardID) throws SQLException{
		System.out.println("输入新密码：");
        Scanner input = new Scanner(System.in);
		String pwd = input.nextLine();
		Target adapterTarget = new Adapter();
        adapterTarget.request(cardID,pwd);
	}
}