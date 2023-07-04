package interfaces;

import java.sql.SQLException;
import java.util.List;

import Bean.HoKhauBean;

public interface IHoKhau {
    public boolean addNew(HoKhauBean hoKhauBean) throws ClassNotFoundException, SQLException;
    public boolean checkPerson(int id);
    public List<HoKhauBean> getListHoKhau();
    public List<HoKhauBean> search(String key);
    public void tachHoKhau(HoKhauBean hoKhauBean);
    public void chuyenDi(int idhoKhau, String noiChuyenDen, String lyDoChuyen);
}
