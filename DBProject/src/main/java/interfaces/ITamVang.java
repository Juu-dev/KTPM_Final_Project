package interfaces;

import models.TamVangModel;

public interface ITamVang {
    public int checkCMT(String cmt);
    public boolean addNew(TamVangModel tamVangModel);
}
