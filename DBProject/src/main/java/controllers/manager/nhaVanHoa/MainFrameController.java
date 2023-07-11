package controllers.manager.nhaVanHoa;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JTable;

import database.MysqlConnection;
import utility.CustomTableCellRenderer;



public class MainFrameController {
    private JTable jTableLich;
    private JTable jTableDonDangKy;
    private JLabel jLabelSoDonDKChuaXL;
    private JLabel jLabelSoDonDKDaXL;
    private JLabel jLabelSoCSVC;
    private JLabel jLabelSoCSVCSanCo;

    public MainFrameController(JTable jTableLich, JTable jTableDonDangKy,JLabel jLabelSoDonDKChuaXL,JLabel jLabelSoDonDKDaXL,JLabel jLabelSoCSVC,JLabel jLabelSoCSVCSanCo) {
        this.jTableDonDangKy = jTableDonDangKy;
        this.jTableLich = jTableLich;
        this.jLabelSoDonDKChuaXL = jLabelSoDonDKChuaXL;
        this.jLabelSoDonDKDaXL = jLabelSoDonDKDaXL;
        this.jLabelSoCSVC = jLabelSoCSVC;
        this.jLabelSoCSVCSanCo = jLabelSoCSVCSanCo;
    }
    
    public void setDataTable() {
       // Định dạng header
        this.jTableLich.getTableHeader().setDefaultRenderer(new utility.HeaderRenderer());
        this.jTableLich.getTableHeader().setPreferredSize(new Dimension(100, 50));

        // Màu sắc hàng chẵn/lẻ
        this.jTableLich.setDefaultRenderer(Object.class, new CustomTableCellRenderer());

        this.jTableLich.setRowHeight(50);
        this.jTableLich.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        this.jTableLich.getColumnModel().getColumn(0).setMaxWidth(100);
        this.jTableLich.getColumnModel().getColumn(0).setMinWidth(100);
        this.jTableLich.getColumnModel().getColumn(0).setPreferredWidth(100);

         // Định dạng header
        this.jTableDonDangKy.getTableHeader().setDefaultRenderer(new utility.HeaderRenderer());
        this.jTableDonDangKy.getTableHeader().setPreferredSize(new Dimension(100, 50));

        // Màu sắc hàng chẵn/lẻ
        this.jTableDonDangKy.setDefaultRenderer(Object.class, new CustomTableCellRenderer());

        this.jTableDonDangKy.setRowHeight(50);
        this.jTableDonDangKy.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        this.jTableDonDangKy.getColumnModel().getColumn(0).setMaxWidth(100);
        this.jTableDonDangKy.getColumnModel().getColumn(0).setMinWidth(100);
        this.jTableDonDangKy.getColumnModel().getColumn(0).setPreferredWidth(100);

        try {
            Connection connection = MysqlConnection.getMysqlConnection();

            String query = "SELECT COUNT(*) AS tongRequest FROM request";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.jLabelSoDonDKChuaXL.setText(String.valueOf(rs.getInt("tongRequest")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM approve";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.jLabelSoDonDKDaXL.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM infrastructure";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.jLabelSoCSVC.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM room";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.jLabelSoCSVCSanCo.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();

            connection.close();
        } catch (Exception e) {
        }
    }


}
