package yx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import qpf.FactoryMethod.JDBCUtils;

public class Test4 {

	public static void main(String[] args) throws Exception {
		String a=choosesCard();
		//System.out.println("卡号："+a);
	}

	public static String choosesCard() throws Exception
	{
		String cardID = " ";
		Scanner sc = new Scanner(System.in);
		while(cardID.length() != 19) {
            System.out.print("请输入卡号（19个字符）：");
            cardID = sc.nextLine();
		}
		System.out.print("请输入银行卡密码（6位）：");
        String cardPassword = sc.nextLine();
        if(selectCard(cardID, cardPassword)) {
    		System.out.println("卡号与密码正确！");
    		return cardID;
    	}
    	else
    	{
    		System.out.println("卡号或密码错误！");
    		return null;
    	}
	}
	
	public static boolean selectCard(String cardID, String cardPassword) throws Exception {
		//获取对象
        Connection connection = JDBCUtils.getConnection();
        //银行卡号是否存在，密码是否正确
        String sql = "select*from cardInfo where cardID=? and cardPassword=?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1,cardID);
        pst.setString(2,cardPassword);
        ResultSet rs = pst.executeQuery();
        return rs.next();
	}
}
