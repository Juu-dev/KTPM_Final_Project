/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.manager.nhaVanHoa;

import interfaces.ICapNhatLichChoNhaVanHoa;
import models.LenLichSuKien;


public class CapNhatLichChoNhaVanHoa {
    private static ICapNhatLichChoNhaVanHoa API = new mysqlSubsystem.CapNhatLichChoNhaVanHoa();

    private String roomName;
    private String startTime;
    private String finishTime;
    private String eventName;
    private String eventDescriptions;
    private int fee;

    private LenLichSuKien lenLichSuKien = new LenLichSuKien(roomName, startTime, finishTime, eventName, eventDescriptions, fee);

    public boolean capNhatLichChoPhong(LenLichSuKien lenLichSuKien) {
        return API.capNhatLichChoPhong(lenLichSuKien);
    }
    
}
