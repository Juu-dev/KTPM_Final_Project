package utility;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {

        private final Color evenRowColor = Color.decode("#F6FAFF");
        private final Color oddRowColor = Color.WHITE;
        private final Color hoverColor = Color.decode("#BDD5F3");

        public CustomTableCellRenderer() {
            setOpaque(true);
            setFont(new Font("Times New Roman", Font.PLAIN, 14));
            setHorizontalAlignment(SwingConstants.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Màu sắc hàng chẵn/lẻ
            if (row % 2 == 0) {
                component.setBackground(evenRowColor);
            } else {
                component.setBackground(oddRowColor);
            }

            // Hiệu ứng hover
            if (isSelected || hasFocus) {
                component.setBackground(hoverColor);
            }

            // Định dạng dữ liệu
            if (value instanceof Number) {
                setHorizontalAlignment(SwingConstants.CENTER);
            } else {
                setHorizontalAlignment(SwingConstants.CENTER);
            }

            return component;
        }
    }