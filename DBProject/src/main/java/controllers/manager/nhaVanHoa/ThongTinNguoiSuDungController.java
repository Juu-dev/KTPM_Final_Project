/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.manager.nhaVanHoa;
import models.ThongTinNguoSuDungModels;

public class ThongTinNguoiSuDungController {
   
    private static interfaces.IThongTinNguoiSuDung API = new mysqlSubsystem.ThongTinNguoiSuDung();

    public ThongTinNguoSuDungModels nguoiSuDung(String userUsername) {
        return API.nguoiSuDung(userUsername);
    }   
}
