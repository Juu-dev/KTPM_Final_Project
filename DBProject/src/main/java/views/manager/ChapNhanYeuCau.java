/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.manager;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controllers.manager.XemLich;
import controllers.manager.nhaVanHoa.LenLichSuKienController;
import controllers.manager.nhaVanHoa.ThongTinNguoiDungDangKy;
import models.LenLichSuKien;
import models.TinhTrangYeuCau;
import java.time.format.DateTimeFormatter;

public class ChapNhanYeuCau extends javax.swing.JFrame {
    private int index;
    private DefaultTableModel model;
    /**
     * Creates new form ChapNhanYeuCau
     */
    public ChapNhanYeuCau(DefaultTableModel model ,int index) {
        this.index = index;
        this.model = model;
        initComponents();
        setLocationRelativeTo(null);
        jLabelMota.setText((String)model.getValueAt(index, 5));
        jLabelUsername.setText("Tên người dùng: " +(String)model.getValueAt(index, 1));
        jLabelThoigian.setText("Thời gian từ:   "+(String)model.getValueAt(index, 2)+"   đến:   " +(String)model.getValueAt(index, 3));
    }
    public ChapNhanYeuCau(){
        
    }
    
    private boolean check(){
        if(jTextField2.getText() == ""){
            JOptionPane.showMessageDialog(null, "Vui vòng điền phí sử dụng", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        int phi = 0;
        try{
            phi = Integer.parseInt(jTextField2.getText());
        } catch(NumberFormatException e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Phí sử dụng không hợp lệ", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
        }
        if(phi < 0){
            JOptionPane.showMessageDialog(null, "Phí sử dụng không hợp lệ", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
         
        //Parse String to LocalDateTime
        LocalDateTime startTime = LocalDateTime.parse((String)model.getValueAt(index, 2), formatter);
        LocalDateTime endTime = LocalDateTime.parse((String)model.getValueAt(index, 3), formatter);
        
        /*
        (String)model.getValueAt(index, 2)
        String startHour = hourBoxStart.getItemAt(hourBoxStart.getSelectedIndex());
        String startMinute = minuteBoxStart.getItemAt(minuteBoxStart.getSelectedIndex());
        LocalDateTime startTime = Instant.ofEpochMilli(jDateStart.getDate().getTime() )
                            .atZone( ZoneId.systemDefault() )
                            .toLocalDateTime();
        startTime.plusHours(Integer.valueOf(startHour));
        startTime.plusMinutes(Integer.valueOf(startMinute));

        String endHour = hourBoxFinish.getItemAt(hourBoxFinish.getSelectedIndex());
        String endMinute = minuteBoxFinish.getItemAt(minuteBoxFinish.getSelectedIndex());
        LocalDateTime endTime = Instant.ofEpochMilli(jDateFinish.getDate().getTime() )
                            .atZone( ZoneId.systemDefault() )
                            .toLocalDateTime();
        endTime.plusHours(Integer.valueOf(endHour));
        endTime.plusMinutes(Integer.valueOf(endMinute));
        */
        if(!XemLich.checkAvailable((String)model.getValueAt(index, 4), startTime, endTime)) {
            JOptionPane.showMessageDialog(null, "Sự kiện trùng với sự kiện khác", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelMota = new javax.swing.JLabel();
        jLabelThoigian = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jLabelghichu = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabelphi = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelMota.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelMota.setText("Mô tả:");

        jLabelThoigian.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelThoigian.setText("Thời gian từ: ");

        jLabelUsername.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelUsername.setText("Tên người dùng:");

        jLabelghichu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelghichu.setText("Ghi chú:");

        jLabelphi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelphi.setText("Phí sử dụng:");

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(32, 135, 215));
        jButton1.setText("Chấp thuận");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Từ chối");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Xử lý yêu cầu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMota)
                    .addComponent(jLabelThoigian)
                    .addComponent(jLabelUsername)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelghichu)
                            .addComponent(jLabelphi))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jLabelUsername)
                .addGap(18, 18, 18)
                .addComponent(jLabelThoigian)
                .addGap(18, 18, 18)
                .addComponent(jLabelMota)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelghichu)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelphi)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(check()){
        int id = Integer.parseInt((String)model.getValueAt(index, 0));
        TinhTrangYeuCau tinhtrang = new TinhTrangYeuCau("Chấp thuận", jTextField1.getText(), id, (String)model.getValueAt(index, 2), (String)model.getValueAt(index, 3), Integer.parseInt(jTextField2.getText()));
        ThongTinNguoiDungDangKy.state(tinhtrang);
        LenLichSuKienController.lenLich(new LenLichSuKien((String)model.getValueAt(index, 4), (String)model.getValueAt(index, 2), (String)model.getValueAt(index, 3), (String)model.getValueAt(index, 1) + " thuê", (String)model.getValueAt(index, 5), Integer.parseInt(jTextField2.getText())));
        model.setRowCount(0);
        ThongTinNguoiDungDangKy.print(model);
        this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int id = Integer.parseInt((String)model.getValueAt(index, 0));
        TinhTrangYeuCau tinhtrang = new TinhTrangYeuCau("Từ chối", jTextField1.getText(), id, (String)model.getValueAt(index, 2), (String)model.getValueAt(index, 3), 0);
        ThongTinNguoiDungDangKy.state(tinhtrang);
        model.setRowCount(0);
        ThongTinNguoiDungDangKy.print(model);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChapNhanYeuCau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChapNhanYeuCau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChapNhanYeuCau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChapNhanYeuCau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChapNhanYeuCau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelMota;
    private javax.swing.JLabel jLabelThoigian;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JLabel jLabelghichu;
    private javax.swing.JLabel jLabelphi;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
