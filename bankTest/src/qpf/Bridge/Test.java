package qpf.Bridge;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws SQLException {
		//Abstraction abstraction = new RefinedAbstraction();
        //���õ�һ��ʵ����
		//������ת��
		//abstraction.setImplementor(new ConcreateImplementorA());
	    //abstraction.operation("1234567890987654321","1111111111111111111",1000);
		//abstraction.operation("1111111111111111111","1234567890987654321",10000);
		//���õڶ���ʵ����
	  //���м�ת��
//	    abstraction.setImplementor(new ConcreateImplementorB());
//	   abstraction.operation("1111111111111111111",1000);
		
		
		InOrOut.operation("1111111111111111111","1234567890987654329",10000);
		
		
		
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("MMdd"+1);
		String time=dateFormat.format(date);
		System.out.println(time);
	}
	//ת��
	public static void zhuanzhang(String cardID) throws SQLException{
		Scanner input = new Scanner(System.in);
		System.out.println("����Ŀ�����п���");
		String cardID2=input.next();
		System.out.println("����ת�˽�");
		long money=input.nextLong();
		InOrOut.operation(cardID,cardID2,money);
		
	}

}
