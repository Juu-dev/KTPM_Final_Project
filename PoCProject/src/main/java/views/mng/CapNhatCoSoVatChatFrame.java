/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mng;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import services.MysqlConnection;
import controllers.mng.CapNhatCoSoVatChat;
import javax.swing.JOptionPane;
import controllers.user.XemLichSuDungNhaVanHoaController;
/**
 *
 * @author keplegarry
 */
public class CapNhatCoSoVatChatFrame extends javax.swing.JFrame {

    /**
     * Creates new form CapNhatCoSoVatChatFrame
     */
    public CapNhatCoSoVatChatFrame() {
        initComponents();
        setLocationRelativeTo(null);
        jComboBoxVatPhamUpdate();
    }
    
    private void jComboBoxVatPhamUpdate(){
        try{
            Connection conn = MysqlConnection.getMysqlConnection();
            String phong = (String)jComboBoxPhong.getSelectedItem();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Infrastructure");
             while(rs.next()){
                if(rs.getString("RoomName").equals(phong)){
                    jComboBoxVatPham.addItem(rs.getString("ItemName"));
                }
        }
        } catch(SQLException e){
            
        } catch(ClassNotFoundException e){
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinnerSoLuong = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        datePicker = new com.github.lgooddatepicker.components.DatePicker();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldThongTin = new javax.swing.JTextField();
        jButtonXacNhan = new javax.swing.JButton();
        jButtonLamMoi = new javax.swing.JButton();
        jButtonHuy = new javax.swing.JButton();
        jComboBoxPhong = new javax.swing.JComboBox<>();
        jComboBoxVatPham = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cập nhật thông tin cơ sở vật chất");

        jLabel1.setText("Chọn vật phẩm:");
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel2.setText("Số lượng:");
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jSpinnerSoLuong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel3.setText("Phòng:");
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel4.setText("Ngày cập nhật:");
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        datePicker.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel5.setText("Thông tin:");
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTextFieldThongTin.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jButtonXacNhan.setText("Xác nhận");
        jButtonXacNhan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButtonXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXacNhanActionPerformed(evt);
            }
        });

        jButtonLamMoi.setText("Làm mới");
        jButtonLamMoi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButtonLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLamMoiActionPerformed(evt);
            }
        });

        jButtonHuy.setText("Hủy");
        jButtonHuy.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButtonHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHuyActionPerformed(evt);
            }
        });

        XemLichSuDungNhaVanHoaController xemLichSuDungNhaVanHoaController = new XemLichSuDungNhaVanHoaController();
        jComboBoxPhong.setModel(new javax.swing.DefaultComboBoxModel<>(xemLichSuDungNhaVanHoaController.layDanhSachPhong()));
        jComboBoxPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBoxPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPhongActionPerformed(evt);
            }
        });

        jComboBoxVatPham.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonXacNhan)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLamMoi)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldThongTin, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxVatPham, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSpinnerSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(61, 61, 61)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))
                            .addGap(48, 48, 48)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jComboBoxPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxVatPham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinnerSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                        .addGap(29, 29, 29)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLamMoi)
                    .addComponent(jButtonXacNhan)
                    .addComponent(jButtonHuy))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXacNhanActionPerformed
        if(datePicker.getDate() == null || jTextFieldThongTin.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Vui vòng điền đẩy đủ thông tin", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            CapNhatCoSoVatChat.capNhatCSVC
        ((String)jComboBoxVatPham.getSelectedItem(), (String)jComboBoxPhong.getSelectedItem(), datePicker.getDate().toString(), jTextFieldThongTin.getText(), (int)jSpinnerSoLuong.getValue());
        jButtonLamMoiActionPerformed(evt);
        }
        
    }//GEN-LAST:event_jButtonXacNhanActionPerformed

    private void jComboBoxPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPhongActionPerformed
        jComboBoxVatPham.removeAllItems();
        jComboBoxVatPhamUpdate();
        jButtonLamMoiActionPerformed(evt);
    }//GEN-LAST:event_jComboBoxPhongActionPerformed

    private void jButtonLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLamMoiActionPerformed
        jTextFieldThongTin.setText("");
        datePicker.clear();
        jSpinnerSoLuong.setValue(0);
        
    }//GEN-LAST:event_jButtonLamMoiActionPerformed

    private void jButtonHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHuyActionPerformed
        if(datePicker.getDate() == null && jTextFieldThongTin.getText().length() == 0){
            this.dispose();
        } else {
            if (JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                this.dispose();
            } else {              
            }
        }
    }//GEN-LAST:event_jButtonHuyActionPerformed

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
            java.util.logging.Logger.getLogger(CapNhatCoSoVatChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CapNhatCoSoVatChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CapNhatCoSoVatChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CapNhatCoSoVatChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CapNhatCoSoVatChatFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker datePicker;
    private javax.swing.JButton jButtonHuy;
    private javax.swing.JButton jButtonLamMoi;
    private javax.swing.JButton jButtonXacNhan;
    private javax.swing.JComboBox<String> jComboBoxPhong;
    private javax.swing.JComboBox<String> jComboBoxVatPham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSpinner jSpinnerSoLuong;
    private javax.swing.JTextField jTextFieldThongTin;
    // End of variables declaration//GEN-END:variables
}
