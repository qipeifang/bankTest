package qpf.Test;

import java.util.Scanner;


public class FinalTest {

	public static void main(String[] args) throws Exception {
		Select();
	}
	public static void Select() throws Exception{
		System.out.println("=============��ӭ����ATM���й���ϵͳ=============");
		while(true){
		System.out.println("��ѡ����Ҫִ�еĹ��ܣ�1.��¼        2.ע���û�      3.����");
		Scanner a = new Scanner(System.in);
		switch(a.nextInt()) {
		case 1:
			yx.Singleton.Test1.denglu();
//			System.out.println("���뿨�ţ�");
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
			System.out.println("��ѡ����Ҫ��������Ŀ��1.ȡ��    2.���    3.��ѯ���    4.ת��    5.�޸�����    6.��ӡƾ��   7.���µ�¼  8.�˳�");
			Scanner s = new Scanner(System.in);
			switch(s.nextInt()) {
					case 1:
						//����ȡ��ķ���
						qpf.Command.Test.qukuan(cardID);
						break;
					case 2:
						//���ô��ķ���
						qpf.Command.Test.cunkuan(cardID);
						break;
					case 3:
						//���ò�ѯ���ķ���
						qpf.YuE.YuE.getBalance(cardID);
						break;
					case 4:
						//����ת�˵ķ���
						qpf.Bridge.Test.zhuanzhang(cardID);
						break;
					case 5:
						//�����޸�����ķ���
						qpf.Adapter.Test.xgPwd(cardID);
						break;
					case 6:
						//���ô�ӡƾ���ķ���
						qpf.DaYin.DaYin.display(cardID);;
						break;
					case 7:
						//�������µ�¼�ķ���,Ҳ���ǵ����Լ�
						Select();
						break;
					case 8:
						System.out.println("��ӭ�´ε�¼��ϵͳ��");
						System.exit(0);
						break;
					default:
						System.out.println("�������������������룡");
						break;
				}
			}
			
	}

}
