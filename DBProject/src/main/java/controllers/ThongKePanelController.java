package controllers;

import Bean.NhanKhauBean;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


import models.NhanKhauModel;
import mysqlSubsystem.NhanKhau;
import services.StringService;
import utility.ClassTableModel;
import utility.CustomTableCellRenderer;



public class ThongKePanelController {
    private JComboBox GenderJcb;
    private JComboBox StatusJcb;
    private JTextField tuTuoiJtf;
    private JTextField denTuoiJtf;
    private JPanel jpnView;
    private NhanKhau nhanKhauService;
    private List<NhanKhauBean> listNhanKhauBeans;
    private ClassTableModel classTableModel;
    private final String[] COLUMNS = {"ID", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ hiện nay"};

    public ThongKePanelController(JComboBox genderJcb, JComboBox statusJcb, JTextField tuTuoiJtf, JTextField denTuoiJtf, JPanel jpnView) {
        this.GenderJcb = genderJcb;
        this.StatusJcb = statusJcb;
        this.tuTuoiJtf = tuTuoiJtf;
        this.denTuoiJtf = denTuoiJtf;
        this.jpnView = jpnView;
        this.nhanKhauService = new NhanKhau();
        this.listNhanKhauBeans = new ArrayList<>();
        this.listNhanKhauBeans = this.nhanKhauService.getListNhanKhau();
        this.classTableModel = new ClassTableModel();
    }
    
    public JPanel getJpnView() {
        return jpnView;
    }

    public void setJpnView(JPanel jpnView) {
        this.jpnView = jpnView;
    }

    public void setData() {
        int tuTuoi = -1;
        int denTuoi = 200;
        int tuNam = 0;
        int denNam = 2100;
        String gender = StringService.covertToString((String)this.GenderJcb.getSelectedItem());
        String status = StringService.covertToString((String)this.StatusJcb.getSelectedItem());
        try {
            if (!this.tuTuoiJtf.getText().trim().isEmpty()) {
                tuTuoi = Integer.parseInt(this.tuTuoiJtf.getText().trim());
            } else {
                tuTuoi = -1;
            }
            if (!this.denTuoiJtf.getText().trim().isEmpty()) {
                denTuoi = Integer.parseInt(this.denTuoiJtf.getText().trim());
            } else {
                denTuoi = 200;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(denTuoiJtf, "Vui lòng nhập đúng kiểu dữ liệu!!", "Warring", JOptionPane.ERROR_MESSAGE);
        }
        this.listNhanKhauBeans = this.nhanKhauService.statisticNhanKhau(tuTuoi, denTuoi, gender, status, tuNam, denNam);
        setDataTable();
    }
    
    public void setDataTable() {
        List<NhanKhauModel> listItem = new ArrayList<>();
        this.listNhanKhauBeans.forEach(nhankhau -> {
            listItem.add(nhankhau.getNhanKhauModel());
        });
        DefaultTableModel model = classTableModel.setTableNhanKhau(listItem, COLUMNS);
        JTable table = new JTable(model);
        
        // thiet ke bang

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        
       // Định dạng header
        table.getTableHeader().setDefaultRenderer(new utility.HeaderRenderer());
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));

        // Màu sắc hàng chẵn/lẻ
        table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());

        table.setRowHeight(50);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(100);
        table.getColumnModel().getColumn(0).setMinWidth(100);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(1350, 400));

        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }


    public JComboBox getGenderJcb() {
        return GenderJcb;
    }

    public void setGenderJcb(JComboBox GenderJcb) {
        this.GenderJcb = GenderJcb;
    }

    public JComboBox getStatusJcb() {
        return StatusJcb;
    }

    public void setStatusJcb(JComboBox StatusJcb) {
        this.StatusJcb = StatusJcb;
    }

    public JTextField getTuTuoiJtf() {
        return tuTuoiJtf;
    }

    public void setTuTuoiJtf(JTextField tuTuoiJtf) {
        this.tuTuoiJtf = tuTuoiJtf;
    }

    public JTextField getDenTuoiJtf() {
        return denTuoiJtf;
    }

    public void setDenTuoiJtf(JTextField denTuoiJtf) {
        this.denTuoiJtf = denTuoiJtf;
    }


    
    
}
