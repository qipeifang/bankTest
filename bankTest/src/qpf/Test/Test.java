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
		//�û������û���������ȥ���Ѿ�������û����������Ƚϣ���ͬ�����ϵͳ������ͬ�򱨴�
				System.out.println("=============��ӭ����ATM���й���ϵͳ=============");
				Scanner s = new Scanner(System.in);
				Scanner input = new Scanner(System.in);
				System.out.print("�������˺ţ�");
				String name = s.nextLine();
				System.out.print("���������룺");
				String password = s.nextLine();
//				//���û�������û�����������ϵͳ�е��û�����������Ƿ���ͬ����ͬ�����ϵͳ
				Login login=new Login();
				String loginName=login.denglu(name, password);
				
				
				if(login.isT()) {
					//System.out.println("��¼�ɹ���");
					
					//�ڴ˴����Խ���ѭ��
					while(true) {
						System.out.println("��ѡ����Ҫѡ�����Ŀ��1.ȡ��    2.���    3.��ѯ���    4.ת��    5.�޸�����    6.���µ�¼  7.�˳���¼");
						switch(s.nextInt()) {
							case 1:
								//����ȡ��ķ���
								System.out.print("����ȡ���");
								int money1=input.nextInt();
								Atm atm1 = new Atm();
								Command[] commands1 = new Command[1];
								commands1[0] = new CmbDepositCommand();
								atm1.setCommand(commands1);
								String cardID1 = null;
								atm1.action(1,money1,cardID1);
								break;
							case 2:
								//���ô��ķ���
								System.out.print("�������");
								int money2=input.nextInt();
								Atm atm2 = new Atm();
								Command[] commands2 = new Command[1];
								commands2[0] = new CmbDepositCommand();
								atm2.setCommand(commands2);
								String cardID2 = null;
								atm2.action(0,money2,cardID2);
								
								break;
							case 3:
								//���ò�ѯ���ķ���
								break;
							case 4:
								//����ת�˵ķ���
								System.out.println("����Ŀ�����п��ţ�");
								String cardID3 = s.nextLine();
								InOrOut a=new InOrOut();
								String cardID4 = null;
								System.out.print("����ת�˽�");
								int amount=input.nextInt();
								a.operation(cardID4,cardID3,amount);
								break;
							case 5:
								//�����޸�����ķ���
//								System.out.print("������������:");
//								String newPwd = s.nextLine();
//								Target adapterTarget = new Adapter();
//							    adapterTarget.request(loginName,newPwd);
								 System.out.println("���������룺");
							     Scanner input1 = new Scanner(System.in);
							     String name1 = input.nextLine();
								 Target adapterTarget = new Adapter();
							     adapterTarget.request(loginName,name1);
							     System.out.println("�����޸ĳɹ���");
								break;
							case 6:
								//�������µ�¼�ķ���,Ҳ���ǵ����Լ�
								//Select();
								break;
							case 7:
								System.out.println("��ӭ�´ε�¼��ϵͳ��");
								System.exit(0);
								break;
							default:
								System.out.println("�������������������룡");
								break;
						}
					}
					//����ͬ���򱨴�
				}else {
					System.out.println("�û������������!���������룡");
					//Select();
				}
			}
}
