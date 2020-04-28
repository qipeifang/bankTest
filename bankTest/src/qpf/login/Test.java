package qpf.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import qpf.FactoryMethod.JDBCUtils;


public class Test {
    public static void main(String[] args)throws Exception {
        //创建扫描器
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入账号：");
        String userName = sc.nextLine();
        System.out.print("请输入密码：");
        String password = sc.nextLine();
        boolean flag = login(userName,password);
        if(flag){
            System.out.println("恭喜"+userName+"登录成功");
        }else {
            System.out.println("账号或密码错误或不存在");
        }
    }
 
    private static boolean login(String userName, String password) throws Exception {
        //获取对象
        Connection connection = JDBCUtils.getConnection();
        //获取SQL运输器
        String sql = "select*from account where accountID=? and accountPassword=?";
        //得到预编译对象
        PreparedStatement pst = connection.prepareStatement(sql);
        //给？赋值
        pst.setString(1,userName);
        pst.setString(2,password);
        //执行SQL
        ResultSet rs = pst.executeQuery();
        return rs.next();
    }
}