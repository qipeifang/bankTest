package yx.Builder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import qpf.FactoryMethod.JDBCUtils;

public class Director {
	private RegisterBuilder rb;
	
	public void setRegisterBuilder(RegisterBuilder rb)
	{
		this.rb=rb;
	}
	
	public Register construct(String accountID,String accountPassword,String customerID,
			String customerName,String pID,String telephone,String address)
	{
		rb.buildAccount(accountID, accountPassword);
		rb.buildCustomer(customerID,customerName, pID, telephone, address, accountID);
		return rb.getMeal();
	}
	
	public static boolean register(String accountID,String accountPassword,String customerID,
			String customerName,String pID,String telephone,String address) throws Exception {
        //��ȡ����
        Connection connection = JDBCUtils.getConnection();
        //�˺��Ƿ��ظ�
        String sql = "select*from account where accountID=? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1,accountID);
        ResultSet rs = pst.executeQuery();
        //�ͻ�ID�Ƿ��ظ�
        String sql2 = "select*from userInfo where customerID=? ";
        PreparedStatement pst2 = connection.prepareStatement(sql2);
        pst2.setString(1,customerID);
        ResultSet rs2 = pst2.executeQuery();
        //���֤�Ƿ��ظ�
        String sql3 = "select*from userInfo where pID=? ";
        PreparedStatement pst3 = connection.prepareStatement(sql3);
        pst3.setString(1,pID);
        ResultSet rs3 = pst3.executeQuery();
        
        if(rs.next()){
        	System.out.print("�˺��ظ���������ѡ��");
        	return false;
        }
        else if(rs2.next()) {
        	System.out.print("�ͻ�ID�ظ���������ѡ��");
        	return false;
        }
        else if(rs3.next()) {
        	System.out.print("���֤���ظ���������ѡ��");
        	return false;
        }
        else {
        	//�����˺�����
        	String sql4 = " insert into account(accountID,accountPassword) values (?,?)";
        	PreparedStatement pst4 = connection.prepareStatement(sql4);
            pst4.setString(1,accountID);
            pst4.setString(2,accountPassword);
            int rs4 = pst4.executeUpdate();
            //����ͻ�����
            String sql5 = " insert into userInfo(customerID,customerName, pID, telephone,"
            		+ " address, accountID) values (?,?,?,?,?,?)";
            PreparedStatement pst5 = connection.prepareStatement(sql5);
            pst5.setString(1,customerID);
            pst5.setString(2,customerName);
            pst5.setString(3,pID);
            pst5.setString(4,telephone);
            pst5.setString(5,address);
            pst5.setString(6,accountID);
            int rs5 = pst5.executeUpdate();
            return true;
        }
    }

}
