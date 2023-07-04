/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.manager.nhaVanHoa;

import javax.swing.table.DefaultTableModel;
import models.TinhTrangYeuCau;


public class ThongTinNguoiDungDangKy {
    private static interfaces.IThongTinNguoiDungDangKy API = new mysqlSubsystem.ThongTinNguoiDungDangKy();

    public static void print(DefaultTableModel model){
        API.print(model);
    }
    
    public static void state(TinhTrangYeuCau tinhtrang){
        API.state(tinhtrang);
    }
}
