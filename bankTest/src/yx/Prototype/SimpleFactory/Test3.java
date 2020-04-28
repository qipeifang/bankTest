package yx.Prototype.SimpleFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import qpf.FactoryMethod.JDBCUtils;
import yx.Builder.Director;
import yx.Builder.Register;
import yx.Builder.RegisterBuilder;
import yx.Builder.RegisterConcreteBuilder;

public class Test3 {
	
	public static void main(String args[]) throws Exception
	{
		cjcard();
	}
	
	public static void cjcard() throws Exception
	{
		String cardID = " ";
		String customerID = " ";
		Scanner sc = new Scanner(System.in);
        System.out.print("��ѡ�����������");
        String cardname = sc.nextLine();
        while(cardID.length() != 19) {
            System.out.print("�����뿨�ţ�19���ַ�����");
            cardID = sc.nextLine();
        }
        System.out.print("���������п����루6λ����");
        String cardPassword = sc.nextLine();
        while(customerID.length() != 8) {
        	System.out.print("������ͻ��ţ�8���ַ�����");
            customerID = sc.nextLine();
		}
        //��ȡ��ǰʱ��
    	Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String openDate=dateFormat.format(date);
        System.out.print("�����뿪������������");
        int openMoney = sc.nextInt();
        int balance = openMoney;
        System.out.print("�������Ƿ��ʧ����ʧΪ0��δ��ʧΪ1����");
        int isReportLoss = sc.nextInt();
        //��������
        try
        {
            Card card;
        	card=CardFactory.produceCard( cardname, cardID, cardPassword, customerID, openDate,
        			openMoney, balance, isReportLoss);
        	if(CreateCard(cardID, cardPassword, customerID, openDate, openMoney,
        			balance, isReportLoss)) {
        		System.out.print("�������п��ɹ���");
        	}
        	else
        	{
        		System.out.print("�������п�ʧ�ܣ�");
        	}
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
        
/*      Card card,copyCard;
        card=new Card(cardID, cardPassword, openDate,
    			openMoney, balance, isReportLoss);
		copyCard=(Card)card.clone();
		System.out.println("depositCard==copyDepositCard?");
		System.out.println(card==copyCard);
		*/
	}
	
	public static boolean CreateCard(String cardID, String cardPassword,String customerID,
			String openDate,int openMoney, int balance, int isReportLoss) throws Exception {
        //��ȡ����
        Connection connection = JDBCUtils.getConnection();
        //���п����Ƿ��ظ�
        String sql = "select*from cardInfo where cardID=? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1,cardID);
        ResultSet rs = pst.executeQuery();
        //�ͻ�ID�Ƿ����
        String sql2 = "select*from userInfo where customerID=? ";
        PreparedStatement pst2 = connection.prepareStatement(sql2);
        pst2.setString(1,customerID);
        ResultSet rs2 = pst2.executeQuery();
        
        if(rs.next()){
        	System.out.print("�����ظ���������ѡ��");
        	return false;
        }
        else if(!rs2.next()) {
        	System.out.print("�ͻ�ID�����ڣ�������ѡ��");
        	return false;
        }
        else {
            //�������п�����
            String sql3 = " insert into cardInfo(cardID, cardPassword, customerID, openDate, "
            		+ "openMoney, balance, isReportLoss) values (?,?,?,?,?,?,?)";
            PreparedStatement pst3 = connection.prepareStatement(sql3);
            pst3.setString(1,cardID);
            pst3.setString(2,cardPassword);
            pst3.setString(3,customerID);
            pst3.setString(4,openDate);
            pst3.setInt(5,openMoney);
            pst3.setInt(6,balance);
            pst3.setInt(7,isReportLoss);
            int rs3 = pst3.executeUpdate();
            return true;
        }
    }

}

