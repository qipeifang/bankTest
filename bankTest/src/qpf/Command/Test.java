package qpf.Command;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws SQLException {
		//��������ִ������
//		Atm atm = new Atm();
//		Command[] commands = new Command[2];
//		commands[0] = new CmbDepositCommand();//���
//		commands[1] = new CmbWithdrawCommand();//ȡ��
//		atm.setCommand(commands);
//		atm.action(0,100,"1234567890987654321");//���
//		atm.action(1,100,"1234567890987654321");//ȡ��
//		atm.cancel(0);
//		atm.action(1);
//		atm.cancel(1);
		qukuan("1234567890987654321");
		//cunkuan("1234567890987654321");
	}
	public static void qukuan(String cardID) throws SQLException{
		//����ȡ��ķ���
		System.out.print("����ȡ���");
		Scanner input = new Scanner(System.in);
		int money=input.nextInt();
		Atm atm = new Atm();
		Command[] commands = new Command[1];
		commands[0] = new CmbWithdrawCommand();
		atm.setCommand(commands);
		atm.action(0,money,cardID);
	}
	public static void cunkuan(String cardID) throws SQLException{
		//���ô��ķ���
		System.out.print("�������");
		Scanner input = new Scanner(System.in);
		int money=input.nextInt();
		Atm atm = new Atm();
		Command[] commands = new Command[1];
		commands[0] = new CmbDepositCommand();
		atm.setCommand(commands);
		atm.action(0,money,cardID);
	}
}
