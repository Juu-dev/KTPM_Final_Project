package quanlynhankhau;

import java.util.Calendar;
import javax.swing.UIManager;
import views.mng.LogInView;
import views.mng.MainFrame1;


public class QuanLyNhanKhau {

    public static Calendar calendar = Calendar.getInstance();
    
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
//        MainFrame mainFrame = new MainFrame();
//        mainFrame.setLocationRelativeTo(null);
//        mainFrame.setResizable(false);
//        mainFrame.setVisible(true);
        LogInView loginUI = new LogInView();
        loginUI.setVisible(true); 
    }
    
}
