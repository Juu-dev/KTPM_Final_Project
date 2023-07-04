package controllers.manager.nhaVanHoa;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import utility.CustomTableCellRenderer;



public class MainFrameController {
    private JTable jTableLich;
    private JTable jTableDonDangKy;
    

    public MainFrameController(JTable jTableLich, JTable jTableDonDangKy) {
        this.jTableDonDangKy = jTableDonDangKy;
        this.jTableLich = jTableLich;
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
    }


}
