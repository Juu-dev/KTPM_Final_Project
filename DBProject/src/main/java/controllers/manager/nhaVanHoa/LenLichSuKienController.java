/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.manager.nhaVanHoa;

import interfaces.ILenLichSuKien;
import models.LenLichSuKien;

public class LenLichSuKienController {
    private static ILenLichSuKien API = new mysqlSubsystem.LenLichSuKien();


    public static void lenLich(LenLichSuKien lich){
        API.lenLich(lich);
    }
}
