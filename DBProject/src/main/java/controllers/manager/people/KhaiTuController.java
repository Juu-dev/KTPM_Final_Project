package controllers.manager.people;

import interfaces.IKhaiTu;
import models.KhaiTuModel;

public class KhaiTuController {
    private static IKhaiTu API = new mysqlSubsystem.KhaiTu();

    public int checkCMT(String cmt) {
        return API.checkCMT(cmt);
    }
    
    public boolean addNew(KhaiTuModel khaiTuModel) {
        return API.addNew(khaiTuModel);
    }
}
