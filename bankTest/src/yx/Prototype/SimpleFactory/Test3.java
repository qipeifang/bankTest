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
        System.out.print("请选择储蓄卡或其他：");
        String cardname = sc.nextLine();
        while(cardID.length() != 19) {
            System.out.print("请输入卡号（19个字符）：");
            cardID = sc.nextLine();
        }
        System.out.print("请输入银行卡密码（6位）：");
        String cardPassword = sc.nextLine();
        while(customerID.length() != 8) {
        	System.out.print("请输入客户号（8个字符）：");
            customerID = sc.nextLine();
		}
        //获取当前时间
    	Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String openDate=dateFormat.format(date);
        System.out.print("请输入开卡金额（整数）：");
        int openMoney = sc.nextInt();
        int balance = openMoney;
        System.out.print("请输入是否挂失（挂失为0，未挂失为1）：");
        int isReportLoss = sc.nextInt();
        //工厂方法
        try
        {
            Card card;
        	card=CardFactory.produceCard( cardname, cardID, cardPassword, customerID, openDate,
        			openMoney, balance, isReportLoss);
        	if(CreateCard(cardID, cardPassword, customerID, openDate, openMoney,
        			balance, isReportLoss)) {
        		System.out.print("创建银行卡成功！");
        	}
        	else
        	{
        		System.out.print("创建银行卡失败！");
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
        //获取对象
        Connection connection = JDBCUtils.getConnection();
        //银行卡号是否重复
        String sql = "select*from cardInfo where cardID=? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1,cardID);
        ResultSet rs = pst.executeQuery();
        //客户ID是否存在
        String sql2 = "select*from userInfo where customerID=? ";
        PreparedStatement pst2 = connection.prepareStatement(sql2);
        pst2.setString(1,customerID);
        ResultSet rs2 = pst2.executeQuery();
        
        if(rs.next()){
        	System.out.print("卡号重复，请重新选择。");
        	return false;
        }
        else if(!rs2.next()) {
        	System.out.print("客户ID不存在，请重新选择。");
        	return false;
        }
        else {
            //插入银行卡数据
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

