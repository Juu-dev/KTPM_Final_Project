package controllers.manager.people;

import interfaces.ITamTru;
import models.TamTruModel;


public class DangKyTamTruController {
    private static ITamTru API = new mysqlSubsystem.TamTru();

    public int checkCMT(String cmt) {
        return API.checkCMT(cmt);
    }
    
    public boolean addNew(TamTruModel tamTruModel) {
        return API.addNew(tamTruModel);
    }
}
