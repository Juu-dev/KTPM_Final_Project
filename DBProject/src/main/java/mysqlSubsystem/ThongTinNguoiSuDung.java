package mysqlSubsystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import models.ThongTinNguoSuDungModels;

import java.sql.*;
import javax.swing.JOptionPane;

import database.MysqlConnection;

public class ThongTinNguoiSuDung implements interfaces.IThongTinNguoiSuDung {
    ThongTinNguoSuDungModels thongTinNguoiSuDung = new ThongTinNguoSuDungModels();
    public ThongTinNguoSuDungModels nguoiSuDung(String userUsername) {
        try {            
            Connection connection = MysqlConnection.getMysqlConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM USERTAB WHERE USERUSERNAME = '" + userUsername + "'";
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                thongTinNguoiSuDung.setUserUsername(userUsername);
                thongTinNguoiSuDung.setBirthDay(rs.getString("BIRTHDAY"));
                thongTinNguoiSuDung.setJob(rs.getString("JOB"));
                thongTinNguoiSuDung.setPhoneNumber(rs.getString("PHONENUMBER"));
                thongTinNguoiSuDung.setSignUpDate(rs.getString("SIGNUPDATE"));
                thongTinNguoiSuDung.setUserAddress(rs.getString("ADDRESS"));
                thongTinNguoiSuDung.setUserFullname(rs.getString("FULLNAME"));                
            }
        } catch(Exception e) {
            System.out.println(e);
                JOptionPane.showMessageDialog(null, "Người dùng không tồn tại", "Warning", JOptionPane.WARNING_MESSAGE);
        }     
        return thongTinNguoiSuDung;
    }   
}
