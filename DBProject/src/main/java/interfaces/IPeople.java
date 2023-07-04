package interfaces;

import Bean.NhanKhauBean;

import java.sql.SQLException;

// lop thuc hien cac chuc nang trong giao dien them moi nhan khau

public interface IPeople {
    public boolean addNewPeople(NhanKhauBean nhanKhauBean) throws SQLException, ClassNotFoundException;
}
