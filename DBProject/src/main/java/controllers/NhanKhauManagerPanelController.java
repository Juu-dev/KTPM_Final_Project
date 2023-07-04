package controllers;

import Bean.NhanKhauBean;
import utility.HeaderRenderer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import models.NhanKhauModel;
import mysqlSubsystem.NhanKhau;
import utility.ClassTableModel;
import utility.CustomTableCellRenderer;
import views.infoViews.InfoJframe;

public class NhanKhauManagerPanelController {
    private int[] columnSortStates = {0, 0, 0, 0, 0};
    private HeaderRenderer headerRenderer = new HeaderRenderer();


    private JPanel jpnView;
    private JTextField jtfSearch;
    private NhanKhau nhanKhauService;
    private List<NhanKhauBean> listNhanKhauBeans;
    private ClassTableModel classTableModel = null;
    private final String[] COLUMNS = {"ID", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ hiện nay"};
    private JFrame parentJFrame;

    public NhanKhauManagerPanelController(JPanel jpnView, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        classTableModel = new ClassTableModel();
        this.nhanKhauService = new NhanKhau();
        this.listNhanKhauBeans = this.nhanKhauService.statisticNhanKhau(-1, 200, "Toan bo", "Chua chet", 0, 2100);

        initAction();
    }

    public NhanKhauManagerPanelController() {
    }

    public void initAction() {
        this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listNhanKhauBeans = nhanKhauService.search(key.trim());
                setDataTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listNhanKhauBeans = nhanKhauService.search(key.trim());
                setDataTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listNhanKhauBeans = nhanKhauService.search(key.trim());
                setDataTable();
            }
        });
    }

    public void setDataTable() {
        List<NhanKhauModel> listItem = new ArrayList<>();
        this.listNhanKhauBeans.forEach(nhankhau -> {
            listItem.add(nhankhau.getNhanKhauModel());
        });
        DefaultTableModel model = classTableModel.setTableNhanKhau(listItem, COLUMNS);
        JTable table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
        };

        table.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = table.columnAtPoint(e.getPoint());
                if (column >= 0) {
                    sortColumn(column);
                }
            }
        });

        table.getTableHeader().setDefaultRenderer(new HeaderRenderer());
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));

        // Màu sắc hàng chẵn/lẻ
        table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());

        table.setRowHeight(50);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    NhanKhauBean temp = listNhanKhauBeans.get(table.getSelectedRow());
                    NhanKhauBean info = nhanKhauService.getNhanKhau(temp.getChungMinhThuModel().getSoCMT());
                    InfoJframe infoJframe = new InfoJframe(info.toString(), parentJFrame);
                    infoJframe.setLocationRelativeTo(null);
                    infoJframe.setVisible(true);
                }
            }
        });

        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(1350, 400));

        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }

    public void refreshData() {
        this.listNhanKhauBeans = this.nhanKhauService.getListNhanKhau();
        setDataTable();
    }

    public JPanel getJpnView() {
        return jpnView;
    }

    public void setJpnView(JPanel jpnView) {
        this.jpnView = jpnView;
    }

    public JTextField getJtfSearch() {
        return jtfSearch;
    }

    public void setJtfSearch(JTextField jtfSearch) {
        this.jtfSearch = jtfSearch;
    }


    private void sortColumn(int column) {
        // Xác định trạng thái sắp xếp của cột hiện tại
        int currentState = columnSortStates[column];

        // Tăng trạng thái sắp xếp lên 1 đơn vị và chu kỳ lại từ 0 nếu vượt quá 2
        currentState = (currentState + 1) % 2;

        // Cập nhật trạng thái sắp xếp của cột hiện tại
        columnSortStates[column] = currentState;

        // Sắp xếp danh sách listNhanKhauBeans theo cột tương ứng và trạng thái sắp xếp
        switch (column) {
            case 0: // Sắp xếp theo cột "ID"
                sortByID(currentState);
                break;
            case 1: // Sắp xếp theo cột "Họ tên"
                sortByHoTen(currentState);
                break;
            case 2: // Sắp xếp theo cột "Ngày sinh"
                sortByNgaySinh(currentState);
                break;
            case 3: // Sắp xếp theo cột "Giới tính"
                sortByGioiTinh(currentState);
                break;
            case 4: // Sắp xếp theo cột "Địa chỉ hiện nay"
                sortByDiaChi(currentState);
                break;
            default:
                break;
        }

        setDataTable(); // Cập nhật lại JTable sau khi sắp xếp
    }

    private void sortByID(int sortOrder) {
        // Sắp xếp danh sách listNhanKhauBeans theo cột "ID" và trạng thái sắp xếp
        listNhanKhauBeans.sort((bean1, bean2) -> {
            int id1 = bean1.getNhanKhauModel().getID();
            int id2 = bean2.getNhanKhauModel().getID();
            return sortOrder == 0 ? Integer.compare(id1, id2) : Integer.compare(id2, id1);
        });
    }

    private void sortByHoTen(int sortOrder) {
        // Sắp xếp danh sách listNhanKhauBeans theo cột "Họ tên" và trạng thái sắp xếp
        listNhanKhauBeans.sort((bean1, bean2) -> {
            String hoTen1 = bean1.getNhanKhauModel().getHoTen();
            String hoTen2 = bean2.getNhanKhauModel().getHoTen();
            return sortOrder == 0 ? hoTen1.compareTo(hoTen2) : hoTen2.compareTo(hoTen1);
        });
    }

    private void sortByNgaySinh(int sortOrder) {
        // Sắp xếp danh sách listNhanKhauBeans theo cột "Ngày sinh" và trạng thái sắp xếp
        listNhanKhauBeans.sort((bean1, bean2) -> {
            Date ngaySinh1 = bean1.getNhanKhauModel().getNamSinh();
            Date ngaySinh2 = bean2.getNhanKhauModel().getNamSinh();
            return sortOrder == 0 ? ngaySinh1.compareTo(ngaySinh2) : ngaySinh2.compareTo(ngaySinh1);
        });
    }

    private void sortByGioiTinh(int sortOrder) {
        // Sắp xếp danh sách listNhanKhauBeans theo cột "Giới tính" và trạng thái sắp xếp
        listNhanKhauBeans.sort((bean1, bean2) -> {
            String gioiTinh1 = bean1.getNhanKhauModel().getGioiTinh();
            String gioiTinh2 = bean2.getNhanKhauModel().getGioiTinh();
            return sortOrder == 0 ? gioiTinh1.compareTo(gioiTinh2) : gioiTinh2.compareTo(gioiTinh1);
        });
    }

    private void sortByDiaChi(int sortOrder) {
        // Sắp xếp danh sách listNhanKhauBeans theo cột "Địa chỉ hiện nay" và trạng thái sắp xếp
        listNhanKhauBeans.sort((bean1, bean2) -> {
            String diaChi1 = bean1.getNhanKhauModel().getDiaChiHienNay();
            String diaChi2 = bean2.getNhanKhauModel().getDiaChiHienNay();
            return sortOrder == 0 ? diaChi1.compareTo(diaChi2) : diaChi2.compareTo(diaChi1);
        });
    }
}
