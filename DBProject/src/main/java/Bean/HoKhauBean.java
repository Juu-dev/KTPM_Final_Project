package Bean;

import java.util.ArrayList;
import java.util.List;
import models.HoKhauModel;
import models.NhanKhauModel;
import models.ThanhVienCuaHoModel;

/**
 *
* ket noi tu nhien gia ho_khau va nhan_khau
 */

public class HoKhauBean {
    private HoKhauModel hoKhauModel;
    private NhanKhauModel chuHo;
    private List<NhanKhauModel> listNhanKhauModels;
    private List<ThanhVienCuaHoModel> listThanhVienCuaHo;

    public HoKhauBean(HoKhauModel hoKhauModel, NhanKhauModel chuHo, List<NhanKhauModel> listNhanKhauModels, List<ThanhVienCuaHoModel> listThanhVienCuaHo) {
        this.hoKhauModel = hoKhauModel;
        this.chuHo = chuHo;
        this.listNhanKhauModels = listNhanKhauModels;
        this.listThanhVienCuaHo = listThanhVienCuaHo;
    }
    
    public HoKhauBean() {
        this.hoKhauModel = new HoKhauModel();
        this.chuHo = new NhanKhauModel();
        this.listNhanKhauModels = new ArrayList<>();
        this.listThanhVienCuaHo = new ArrayList<>();
    }

    
    public HoKhauModel getHoKhauModel() {
        return hoKhauModel;
    }

    public void setHoKhauModel(HoKhauModel hoKhauModel) {
        this.hoKhauModel = hoKhauModel;
    }

    public NhanKhauModel getChuHo() {
        return chuHo;
    }

    public void setChuHo(NhanKhauModel chuHo) {
        this.chuHo = chuHo;
    }

    public List<NhanKhauModel> getListNhanKhauModels() {
        return listNhanKhauModels;
    }

    public void setListNhanKhauModels(List<NhanKhauModel> listNhanKhauModels) {
        this.listNhanKhauModels = listNhanKhauModels;
    }

    public List<ThanhVienCuaHoModel> getListThanhVienCuaHo() {
        return listThanhVienCuaHo;
    }

    public void setListThanhVienCuaHo(List<ThanhVienCuaHoModel> listThanhVienCuaHo) {
        this.listThanhVienCuaHo = listThanhVienCuaHo;
    }

    // @Override
    // public String toString() {
    //     String res = "<html> <style>p {padding: 5px; margin-left: 20px} table, th, td {border: 1px solid black; border-collapse: collapse;} table {width: 500px}</style> <div>"
    //             + "<h3>Thông tin cơ bản"
    //             + "<p>Mã hộ khẩu: <b>" + hoKhauModel.getMaHoKhau() + "</p>"
    //             + "<p>Họ tên chủ hộ: <b>" + chuHo.getHoTen() + "</p>"
    //             + "<p>Địa chỉ: <b>" + hoKhauModel.getDiaChi() + "</p>"
    //             + "<p>Ngày lập: <b>" + hoKhauModel.getNgayLap().toString() + "</p>"
    //             + "<h4>Danh sách thành viên<table>"
    //             + "<tr>"
    //             + "<th>Họ tên</th>"
    //             + "<th>Ngày sinh</th>"
    //             + "<th>Giới tính</th>"
    //             + "<th>Quan hệ với chủ hộ</th>"
    //             + "</tr>";
    //     for (int i = 0; i < listNhanKhauModels.size(); i++) {
    //         res += "<tr>"
    //                 + "<td>"
    //                 + listNhanKhauModels.get(i).getHoTen()
    //                 + "</td>"
    //                 + "<td>"
    //                 + listNhanKhauModels.get(i).getNamSinh().toString()
    //                 + "</td>"
    //                 + "<td>"
    //                 + listNhanKhauModels.get(i).getGioiTinh()
    //                 + "</td>"
    //                 + "<td>"
    //                 + listThanhVienCuaHo.get(i).getQuanHeVoiChuHo()
    //                 + "</td>"
    //                 + "</tr>";
    //     }
        
        
        
    //     res += "</table></div></html>";
    //     return res;
    // }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("<html>");
        sb.append("<style>")
        .append("table {")
        .append("    border-collapse: collapse;")
        .append("    width: 580px")
        .append("}")
        .append("th, td {")
        .append("    padding: 8px;")
        .append("    text-align: left;")
        .append("    border-bottom: 1px solid #ddd;")
        .append("}")
        .append("th {")
        .append("    background-color: #f2f2f2;")
        .append("}")
        .append(".section {")
        .append("    margin-bottom: 20px;")
        .append("}")
        .append(".table-title {")
        .append("    text-align: center;")
        .append("}")
        .append("</style>");
        
        sb.append("<div class='section'>")
        .append("<h1 class='table-title'>Sổ hộ khẩu - ").append(hoKhauModel.getMaHoKhau()).append("</h1>")
        .append("<h2>Thông tin cơ bản</h2>")
        .append("<table>")
        .append("<tr>")
        .append("<th>Mã hộ khẩu</th>")
        .append("<th>Họ tên chủ hộ</th>")
        .append("<th>Địa chỉ</th>")
        .append("<th>Ngày lập</th>")
        .append("</tr>")
        .append("<tr>")
        .append("<td>").append(hoKhauModel.getMaHoKhau()).append("</td>")
        .append("<td>").append(chuHo.getHoTen()).append("</td>")
        .append("<td>").append(hoKhauModel.getDiaChi()).append("</td>")
        .append("<td>").append(hoKhauModel.getNgayLap().toString()).append("</td>")
        .append("</tr>")
        .append("</table>")
        .append("</div>");

        sb.append("<div class='section'>")
        .append("<h2>Danh sách thành viên</h2>")
        .append("<table>")
        .append("<tr>")
        .append("<th>Họ tên</th>")
        .append("<th>Ngày sinh</th>")
        .append("<th>Giới tính</th>")
        .append("<th>Quan hệ với chủ hộ</th>")
        .append("</tr>");

        for (int i = 0; i < listNhanKhauModels.size(); i++) {
            sb.append("<tr>")
            .append("<td>").append(listNhanKhauModels.get(i).getHoTen()).append("</td>")
            .append("<td>").append(listNhanKhauModels.get(i).getNamSinh().toString()).append("</td>")
            .append("<td>").append(listNhanKhauModels.get(i).getGioiTinh()).append("</td>")
            .append("<td>").append(listThanhVienCuaHo.get(i).getQuanHeVoiChuHo()).append("</td>")
            .append("</tr>");
        }
        
        sb.append("</table>")
        .append("</div>")
        .append("</html>");

        return sb.toString();
    }

}
