package main;

import java.util.Calendar;
import javax.swing.UIManager;

import views.user.UserLoginUI;
import views.manager.MainFrame1;


public class MainAppUser {
    public static Calendar calendar = Calendar.getInstance();
    
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        UserLoginUI loginUI = new UserLoginUI();
        loginUI.setVisible(true); 
    }
    
}
