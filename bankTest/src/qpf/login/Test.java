package qpf.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import qpf.FactoryMethod.JDBCUtils;


public class Test {
    public static void main(String[] args)throws Exception {
        //����ɨ����
        Scanner sc = new Scanner(System.in);
        System.out.print("�������˺ţ�");
        String userName = sc.nextLine();
        System.out.print("���������룺");
        String password = sc.nextLine();
        boolean flag = login(userName,password);
        if(flag){
            System.out.println("��ϲ"+userName+"��¼�ɹ�");
        }else {
            System.out.println("�˺Ż��������򲻴���");
        }
    }
 
    private static boolean login(String userName, String password) throws Exception {
        //��ȡ����
        Connection connection = JDBCUtils.getConnection();
        //��ȡSQL������
        String sql = "select*from account where accountID=? and accountPassword=?";
        //�õ�Ԥ�������
        PreparedStatement pst = connection.prepareStatement(sql);
        //������ֵ
        pst.setString(1,userName);
        pst.setString(2,password);
        //ִ��SQL
        ResultSet rs = pst.executeQuery();
        return rs.next();
    }
}