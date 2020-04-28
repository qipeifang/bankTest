package qpf.Command;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws SQLException {
		//调用者来执行命令
//		Atm atm = new Atm();
//		Command[] commands = new Command[2];
//		commands[0] = new CmbDepositCommand();//存款
//		commands[1] = new CmbWithdrawCommand();//取款
//		atm.setCommand(commands);
//		atm.action(0,100,"1234567890987654321");//存款
//		atm.action(1,100,"1234567890987654321");//取款
//		atm.cancel(0);
//		atm.action(1);
//		atm.cancel(1);
		qukuan("1234567890987654321");
		//cunkuan("1234567890987654321");
	}
	public static void qukuan(String cardID) throws SQLException{
		//调用取款的方法
		System.out.print("输入取款金额：");
		Scanner input = new Scanner(System.in);
		int money=input.nextInt();
		Atm atm = new Atm();
		Command[] commands = new Command[1];
		commands[0] = new CmbWithdrawCommand();
		atm.setCommand(commands);
		atm.action(0,money,cardID);
	}
	public static void cunkuan(String cardID) throws SQLException{
		//调用存款的方法
		System.out.print("输入存款金额：");
		Scanner input = new Scanner(System.in);
		int money=input.nextInt();
		Atm atm = new Atm();
		Command[] commands = new Command[1];
		commands[0] = new CmbDepositCommand();
		atm.setCommand(commands);
		atm.action(0,money,cardID);
	}
}
