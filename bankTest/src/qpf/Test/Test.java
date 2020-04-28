package qpf.Test;

import java.util.Scanner;

import qpf.Adapter.Adapter;
import qpf.Adapter.Target;
import qpf.Bridge.InOrOut;
import qpf.Command.Atm;
import qpf.Command.CmbDepositCommand;
import qpf.Command.CmbWithdrawCommand;
import qpf.Command.Command;
import qpf.login.Login;

public class Test {

	//@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		//用户输入用户名和密码去和已经定义的用户名密码做比较，相同则进入系统，不相同则报错
				System.out.println("=============欢迎进入ATM银行管理系统=============");
				Scanner s = new Scanner(System.in);
				Scanner input = new Scanner(System.in);
				System.out.print("请输入账号：");
				String name = s.nextLine();
				System.out.print("请输入密码：");
				String password = s.nextLine();
//				//将用户输入的用户名和密码与系统中的用户名密码相比是否相同，相同则进入系统
				Login login=new Login();
				String loginName=login.denglu(name, password);
				
				
				if(login.isT()) {
					//System.out.println("登录成功！");
					
					//在此处可以进行循环
					while(true) {
						System.out.println("请选择需要选择的项目：1.取款    2.存款    3.查询余额    4.转账    5.修改密码    6.重新登录  7.退出登录");
						switch(s.nextInt()) {
							case 1:
								//调用取款的方法
								System.out.print("输入取款金额：");
								int money1=input.nextInt();
								Atm atm1 = new Atm();
								Command[] commands1 = new Command[1];
								commands1[0] = new CmbDepositCommand();
								atm1.setCommand(commands1);
								String cardID1 = null;
								atm1.action(1,money1,cardID1);
								break;
							case 2:
								//调用存款的方法
								System.out.print("输入存款金额：");
								int money2=input.nextInt();
								Atm atm2 = new Atm();
								Command[] commands2 = new Command[1];
								commands2[0] = new CmbDepositCommand();
								atm2.setCommand(commands2);
								String cardID2 = null;
								atm2.action(0,money2,cardID2);
								
								break;
							case 3:
								//调用查询余额的方法
								break;
							case 4:
								//调用转账的方法
								System.out.println("输入目标银行卡号：");
								String cardID3 = s.nextLine();
								InOrOut a=new InOrOut();
								String cardID4 = null;
								System.out.print("输入转账金额：");
								int amount=input.nextInt();
								a.operation(cardID4,cardID3,amount);
								break;
							case 5:
								//调用修改密码的方法
//								System.out.print("请输入新密码:");
//								String newPwd = s.nextLine();
//								Target adapterTarget = new Adapter();
//							    adapterTarget.request(loginName,newPwd);
								 System.out.println("输入新密码：");
							     Scanner input1 = new Scanner(System.in);
							     String name1 = input.nextLine();
								 Target adapterTarget = new Adapter();
							     adapterTarget.request(loginName,name1);
							     System.out.println("密码修改成功！");
								break;
							case 6:
								//调用重新登录的方法,也就是调用自己
								//Select();
								break;
							case 7:
								System.out.println("欢迎下次登录该系统！");
								System.exit(0);
								break;
							default:
								System.out.println("你输入有误！请重新输入！");
								break;
						}
					}
					//不相同。则报错
				}else {
					System.out.println("用户名或密码错误!请重新输入！");
					//Select();
				}
			}
}
