package qpf.Bridge;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws SQLException {
		//Abstraction abstraction = new RefinedAbstraction();
        //调用第一个实现类
		//银行内转账
		//abstraction.setImplementor(new ConcreateImplementorA());
	    //abstraction.operation("1234567890987654321","1111111111111111111",1000);
		//abstraction.operation("1111111111111111111","1234567890987654321",10000);
		//调用第二个实现类
	  //银行间转账
//	    abstraction.setImplementor(new ConcreateImplementorB());
//	   abstraction.operation("1111111111111111111",1000);
		
		
		InOrOut.operation("1111111111111111111","1234567890987654329",10000);
		
		
		
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("MMdd"+1);
		String time=dateFormat.format(date);
		System.out.println(time);
	}
	//转账
	public static void zhuanzhang(String cardID) throws SQLException{
		Scanner input = new Scanner(System.in);
		System.out.println("输入目标银行卡：");
		String cardID2=input.next();
		System.out.println("输入转账金额：");
		long money=input.nextLong();
		InOrOut.operation(cardID,cardID2,money);
		
	}

}
