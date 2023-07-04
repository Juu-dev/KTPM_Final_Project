package main;

import java.util.Calendar;
import javax.swing.UIManager;

import views.manager.LogInView;
import views.manager.MainFrame1;


public class MainApp {

    public static Calendar calendar = Calendar.getInstance();
    
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        LogInView loginUI = new LogInView();
        loginUI.setVisible(true); 
    }
    
}
