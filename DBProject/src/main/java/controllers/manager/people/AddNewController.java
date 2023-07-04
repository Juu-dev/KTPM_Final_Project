package controllers.manager.people;

import Bean.NhanKhauBean;
import interfaces.IPeople;

import java.sql.SQLException;

// lop thuc hien cac chuc nang trong giao dien them moi nhan khau

public class AddNewController {
    private static IPeople API = new mysqlSubsystem.People();

    public boolean addNewPeople(NhanKhauBean nhanKhauBean) throws SQLException, ClassNotFoundException{
        return API.addNewPeople(nhanKhauBean);
    }
}
