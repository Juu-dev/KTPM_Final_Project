/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.manager.nhaVanHoa;
import models.ThongTinCoSoVatChat;
import interfaces.ICapNhatCoSoVatChat;


public class CapNhatCoSoVatChat {
    private static ICapNhatCoSoVatChat API = new mysqlSubsystem.CapNhatCoSoVatChat();

    public static ThongTinCoSoVatChat thongTinCoSoVatChat(String name, String room) {
       return API.thongTinCoSoVatChat(name, room);
    }
    
    public static void capNhatCSVC(String name, String room, String date, String description, int amount){
        API.capNhatCSVC(name, room, date, description, amount);
    }
    
    public static void themCSVC(String name, String room, String date, String description, int amount){
        API.themCSVC(name, room, date, description, amount);
    }
}
