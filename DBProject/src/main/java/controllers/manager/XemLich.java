/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.manager;

import java.util.ArrayList;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;


public class XemLich {
    private static interfaces.IXemLich API = new mysqlSubsystem.XemLich();

    public static void show(DefaultTableModel model){
        API.show(model);
    }
    
    public static ArrayList<String> showDetail(DefaultTableModel model, int index){
        return API.showDetail(model, index);
    }
    
    public static boolean checkAvailable(String room, LocalDateTime startTime, LocalDateTime endTime) {
        return API.checkAvailable(room, startTime, endTime);
    }
}

