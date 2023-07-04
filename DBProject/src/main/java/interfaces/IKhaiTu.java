package interfaces;

import models.KhaiTuModel;

public interface IKhaiTu {
    public int checkCMT(String cmt);
    public boolean addNew(KhaiTuModel khaiTuModel);
}
