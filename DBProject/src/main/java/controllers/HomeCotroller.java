package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;

import database.MysqlConnection;


public class HomeCotroller {
    private JLabel tongNhanKhauLb;
    private JLabel tongHoKhauLb;
    private JLabel nhanKhauTamTruLb;
    private JLabel nhanKhauTamVangLb;
    private JLabel khaituLb;
    private JLabel nhanKhauNamLb;
    private JLabel nhanKhauNuLb;

    public HomeCotroller(JLabel tongNhanKhauLb, JLabel tongHoKhau, JLabel nhanKhauTamTruLb, JLabel nhanKhauTamVangLb, JLabel khaituLb, JLabel nhanKhauNamLb, JLabel nhanKhauNuLb) {
        this.tongNhanKhauLb = tongNhanKhauLb;
        this.tongHoKhauLb = tongHoKhau;
        this.nhanKhauTamTruLb = nhanKhauTamTruLb;
        this.nhanKhauTamVangLb = nhanKhauTamVangLb;
        this.khaituLb = khaituLb;
        this.nhanKhauNamLb = nhanKhauNamLb;
        this.nhanKhauNuLb = nhanKhauNuLb;
    }
    
    public void setData() {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT COUNT(*) AS tong FROM nhan_khau";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongNhanKhauLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM ho_khau";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongHoKhauLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM tam_tru";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.nhanKhauTamTruLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM tam_vang";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.nhanKhauTamVangLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();

            // khai tu
            query = "SELECT COUNT(*) AS tongkhaitu FROM khai_tu";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.khaituLb.setText(String.valueOf(rs.getInt("tongkhaitu")));
            }
            preparedStatement.close();

            // nhan khau nam
            query = "SELECT COUNT(*) AS tongNam FROM nhan_khau WHERE gioiTinh = 'Nam'";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.nhanKhauNamLb.setText(String.valueOf(rs.getInt("tongNam")));
            }
            preparedStatement.close();

            // nhan khau nu
            query = "SELECT COUNT(*) AS tongNu FROM nhan_khau WHERE gioiTinh = 'Nữ'";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.nhanKhauNuLb.setText(String.valueOf(rs.getInt("tongNu")));
            }
            preparedStatement.close();
            
            connection.close();
        } catch (Exception e) {
        }
    }

    public JLabel getTongNhanKhauLb() {
        return tongNhanKhauLb;
    }

    public void setTongNhanKhauLb(JLabel tongNhanKhauLb) {
        this.tongNhanKhauLb = tongNhanKhauLb;
    }

    public JLabel getTongHoKhauLb() {
        return tongHoKhauLb;
    }

    public void setTongHoKhau(JLabel tongHoKhauLb) {
        this.tongHoKhauLb = tongHoKhauLb;
    }

    public JLabel getNhanKhauTamTruLb() {
        return nhanKhauTamTruLb;
    }

    public void setNhanKhauTamTruLb(JLabel nhanKhauTamTruLb) {
        this.nhanKhauTamTruLb = nhanKhauTamTruLb;
    }

    public JLabel getNhanKhauTamVangLb() {
        return nhanKhauTamVangLb;
    }

    public void setNhanKhauTamVangLb(JLabel nhanKhauTamVangLb) {
        this.nhanKhauTamVangLb = nhanKhauTamVangLb;
    }
    
    public JLabel getKhaituLb() {
        return khaituLb;
    }

    public void setKhaituLb(JLabel khaituLb) {
        this.khaituLb = khaituLb;
    }

    public JLabel getNhanKhauNamLb() {
        return nhanKhauNamLb;
    }

    public void setNhanKhauNamLb(JLabel nhanKhauNamLb) {
        this.nhanKhauNamLb = nhanKhauNamLb;
    }

    public JLabel getNhanKhauNuLb() {
        return nhanKhauNuLb;
    }

    public void setNhanKhauNuLb(JLabel nhanKhauNuLb) {
        this.nhanKhauNuLb = nhanKhauNuLb;
    }
}
