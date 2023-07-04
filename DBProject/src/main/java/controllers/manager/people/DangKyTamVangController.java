package controllers.manager.people;

import interfaces.ITamVang;
import models.TamVangModel;

public class DangKyTamVangController {
    private static ITamVang API = new mysqlSubsystem.TamVang();

    public int checkCMT(String cmt) {
        return API.checkCMT(cmt);
    }
    
    public boolean addNew(TamVangModel tamVangModel) {
        return API.addNew(tamVangModel);
    }
}
