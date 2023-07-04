package interfaces;

import javax.swing.table.DefaultTableModel;

import models.TinhTrangYeuCau;

public interface IThongTinNguoiDungDangKy {
    public void print(DefaultTableModel model);
    public void state(TinhTrangYeuCau tinhtrang);
}
