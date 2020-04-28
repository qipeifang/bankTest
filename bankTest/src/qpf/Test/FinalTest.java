package qpf.Test;

import java.util.Scanner;


public class FinalTest {

	public static void main(String[] args) throws Exception {
		Select();
	}
	public static void Select() throws Exception{
		System.out.println("=============欢迎进入ATM银行管理系统=============");
		while(true){
		System.out.println("请选择需要执行的功能：1.登录        2.注册用户      3.开卡");
		Scanner a = new Scanner(System.in);
		switch(a.nextInt()) {
		case 1:
			yx.Singleton.Test1.denglu();
//			System.out.println("输入卡号：");
//			Scanner input = new Scanner(System.in);
//			String cardid=input.next();
			String cardID=yx.Test4.choosesCard();
			display(cardID);
			break;
		case 2:
			yx.Builder.Test2.zhuce();
			break;
		case 3:
			yx.Prototype.SimpleFactory.Test3.cjcard();
			break;
			}
		}
	}
	
	public static void display(String cardID) throws Exception{
		while(true) {
			System.out.println("请选择需要操作的项目：1.取款    2.存款    3.查询余额    4.转账    5.修改密码    6.打印凭条   7.重新登录  8.退出");
			Scanner s = new Scanner(System.in);
			switch(s.nextInt()) {
					case 1:
						//调用取款的方法
						qpf.Command.Test.qukuan(cardID);
						break;
					case 2:
						//调用存款的方法
						qpf.Command.Test.cunkuan(cardID);
						break;
					case 3:
						//调用查询余额的方法
						qpf.YuE.YuE.getBalance(cardID);
						break;
					case 4:
						//调用转账的方法
						qpf.Bridge.Test.zhuanzhang(cardID);
						break;
					case 5:
						//调用修改密码的方法
						qpf.Adapter.Test.xgPwd(cardID);
						break;
					case 6:
						//调用打印凭条的方法
						qpf.DaYin.DaYin.display(cardID);;
						break;
					case 7:
						//调用重新登录的方法,也就是调用自己
						Select();
						break;
					case 8:
						System.out.println("欢迎下次登录该系统！");
						System.exit(0);
						break;
					default:
						System.out.println("你输入有误！请重新输入！");
						break;
				}
			}
			
	}

}
