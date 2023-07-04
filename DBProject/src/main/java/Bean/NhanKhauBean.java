package Bean;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import models.ChungMinhThuModel;
import models.GiaDinhModel;
import models.NhanKhauModel;
import models.TieuSuModel;


public class NhanKhauBean {
    private NhanKhauModel nhanKhauModel;
    private ChungMinhThuModel chungMinhThuModel;
    private List<TieuSuModel> listTieuSuModels;
    private List<GiaDinhModel> listGiaDinhModels;
    
    public NhanKhauBean(NhanKhauModel nhanKhauModel, ChungMinhThuModel chungMinhThuModel, List<TieuSuModel> listTieuSuModels, List<GiaDinhModel> listGiaDinhModels) {
        this.nhanKhauModel = nhanKhauModel;
        this.chungMinhThuModel = chungMinhThuModel;
        this.listTieuSuModels = listTieuSuModels;
        this.listGiaDinhModels = listGiaDinhModels;
    }

    public NhanKhauBean() {
        this.nhanKhauModel = new NhanKhauModel();
        this.chungMinhThuModel = new ChungMinhThuModel();
        this.listGiaDinhModels = new ArrayList<>();
        this.listTieuSuModels = new ArrayList<>();
    }
    
    public NhanKhauModel getNhanKhauModel() {
        return nhanKhauModel;
    }

    public void setNhanKhauModel(NhanKhauModel nhanKhauModel) {
        this.nhanKhauModel = nhanKhauModel;
    }

    public ChungMinhThuModel getChungMinhThuModel() {
        return chungMinhThuModel;
    }

    public void setChungMinhThuModel(ChungMinhThuModel chungMinhThuModel) {
        this.chungMinhThuModel = chungMinhThuModel;
    }

    public List<TieuSuModel> getListTieuSuModels() {
        return listTieuSuModels;
    }

    public void setListTieuSuModels(List<TieuSuModel> listTieuSuModels) {
        this.listTieuSuModels = listTieuSuModels;
    }

    public List<GiaDinhModel> getListGiaDinhModels() {
        return listGiaDinhModels;
    }

    public void setListGiaDinhModels(List<GiaDinhModel> listGiaDinhModels) {
        this.listGiaDinhModels = listGiaDinhModels;
    }
    
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("<html>");
            res.append("<style>")
            .append("table {")
            .append("    border-collapse: collapse;")
            .append("    width: 580px")
            .append("}")
            .append("h1 {text-align: center;}")
            .append("p {padding: 5px; margin-left: 20px}")
            .append("th, td {")
            .append("    padding: 8px;")
            .append("    text-align: left;")
            .append("    border-bottom: 1px solid #ddd;")
            .append("}")
            .append("th {")
            .append("    background-color: #f2f2f2;")
            .append("}")
            .append(".section {")
            .append("    margin-bottom: 10px;")
            .append("    width: 580px;")
            .append("}")
            .append(".table-title {")
            .append("    text-align: center;")
            .append("}")
            .append("</style>")
            .append("<div class='section'>")
            .append("<h1>").append(nhanKhauModel.getHoTen()).append("-").append(getYearFromDate(nhanKhauModel.getNamSinh())).append("</h1>")
            .append("</div>");

        res.append("<div class='section'>")
            .append("<h2>Thông tin cơ bản:")
            .append("<p>Họ Tên: <b>").append(nhanKhauModel.getHoTen()).append("</p>")
            .append("<p>Năm Sinh: <b>").append(nhanKhauModel.getNamSinh()).append("</p>")
            .append("<p>Giới Tính: <b>").append(nhanKhauModel.getGioiTinh()).append("</p>")
            .append("<p>Nguyên Quán: <b>").append(nhanKhauModel.getNguyenQuan()).append("</p>")
            .append("<p>Dân Tộc: <b>").append(nhanKhauModel.getDanToc()).append("</p>")
            .append("<p>Tôn Giáo: <b>").append(nhanKhauModel.getTonGiao()).append("</p>")
            .append("<p>Quốc Tịch: <b>").append(nhanKhauModel.getQuocTich()).append("</p>")
            .append("<p>Số CMT: <b>").append(chungMinhThuModel.getSoCMT()).append("</p>")
            .append("<p>Hộ Chiếu Số : <b>").append(nhanKhauModel.getSoHoChieu()).append("</p>")
            .append("<p>Nơi Thường Trú : <b>").append(nhanKhauModel.getNoiThuongTru()).append("</p>")
            .append("<p>Địa Chỉ Hiện Tại : <b>").append(nhanKhauModel.getDiaChiHienNay()).append("</p>")
            .append("</div>");

        if (listTieuSuModels.size() > 0) {
            res.append("<h2>Thông tin phụ:<table>")
            .append("<tr>")
            .append("<th>Từ ngày</th>")
            .append("<th>Đến ngày</th>")
            .append("<th>Địa chỉ</th>")
            .append("<th>Nơi làm việc</th>")
            .append("</tr>");
        }

        for (TieuSuModel tieuSuModel : listTieuSuModels) {
            res.append("<tr>")
                .append("<td>").append(tieuSuModel.getTuNgay().toString()).append("</td>")
                .append("<td>").append(tieuSuModel.getDenNgay().toString()).append("</td>")
                .append("<td>").append(tieuSuModel.getDiaChi()).append("</td>")
                .append("<td>").append(tieuSuModel.getNoiLamViec()).append("</td>")
                .append("</tr>");
        }

        res.append("</table></div></html>");
        return res.toString();
    }

    private int getYearFromDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.YEAR);
}
}
