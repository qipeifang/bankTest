package yx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import qpf.FactoryMethod.JDBCUtils;

public class Test4 {

	public static void main(String[] args) throws Exception {
		String a=choosesCard();
		//System.out.println("���ţ�"+a);
	}

	public static String choosesCard() throws Exception
	{
		String cardID = " ";
		Scanner sc = new Scanner(System.in);
		while(cardID.length() != 19) {
            System.out.print("�����뿨�ţ�19���ַ�����");
            cardID = sc.nextLine();
		}
		System.out.print("���������п����루6λ����");
        String cardPassword = sc.nextLine();
        if(selectCard(cardID, cardPassword)) {
    		System.out.println("������������ȷ��");
    		return cardID;
    	}
    	else
    	{
    		System.out.println("���Ż��������");
    		return null;
    	}
	}
	
	public static boolean selectCard(String cardID, String cardPassword) throws Exception {
		//��ȡ����
        Connection connection = JDBCUtils.getConnection();
        //���п����Ƿ���ڣ������Ƿ���ȷ
        String sql = "select*from cardInfo where cardID=? and cardPassword=?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1,cardID);
        pst.setString(2,cardPassword);
        ResultSet rs = pst.executeQuery();
        return rs.next();
	}
}
