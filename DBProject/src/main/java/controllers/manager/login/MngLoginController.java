/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.manager.login;

import java.sql.*;

import javax.swing.JOptionPane;

import database.MysqlConnection;


public class MngLoginController {
    private static boolean check = false;
    
    public static boolean getCheck(){
        return check;
    }

    public static void mngLogin(String mngUsername, String mngPassword) throws ClassNotFoundException, SQLException{
            try {
                    Connection conn = MysqlConnection.getMysqlConnection();
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("select * from MANAGER");
                    
                    while(rs.next()){
                        if(rs.getString("mngUsername").equals(mngUsername) && rs.getString("mngPassword").equals(mngPassword))
                            check = true;
                    }
                    if(check){
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                    } else {
                        JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }   
        } catch(SQLException e){
        }
    }
}