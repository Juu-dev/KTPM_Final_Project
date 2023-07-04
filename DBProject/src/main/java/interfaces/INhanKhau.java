package interfaces;

import java.util.List;

import Bean.NhanKhauBean;

public interface INhanKhau {
    public NhanKhauBean getNhanKhau(String cmt);
    public List<NhanKhauBean> getListNhanKhau();
    public List<NhanKhauBean> statisticNhanKhau(int TuTuoi, int denTuoi, String gender, String Status, int tuNam, int denNam);
    public List<NhanKhauBean> search(String keyword);
    public int count_gen(String s);
    public int count_age(int limit_start,int limit_end);
}
