package utility;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class HeaderRenderer extends DefaultTableCellRenderer {
        private final Color defaultBackgroundColor = Color.decode("#206BA6");
        private final Color hoverBackgroundColor = Color.decode("#BDD5F3");
        private final Font defaultFont = new Font("Times New Roman", Font.BOLD, 16);
        private final Cursor defaultCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

        private int columnBeingSorted = -1; // Cột đang được sắp xếp

        public HeaderRenderer() {
            setHorizontalAlignment(SwingConstants.CENTER);
            setOpaque(true);
            setBackground(defaultBackgroundColor);
            setForeground(Color.WHITE);
            setFont(defaultFont);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Thiết lập màu nền khi hover
            if (column == columnBeingSorted) {
                component.setBackground(hoverBackgroundColor);
            } else {
                component.setBackground(defaultBackgroundColor);
            }

            // Thiết lập biểu tượng chỉ dẫn
            if (column == columnBeingSorted) {
                if (table.getColumnModel().getColumn(column).getHeaderValue().toString().startsWith("\u2191")) {
                    setText("\u2193 " + value.toString());
                } else {
                    setText("\u2191 " + value.toString());
                }
            } else {
                setText(value.toString());
            }

            // Thiết lập font chữ và con trỏ chuột
            component.setFont(defaultFont);
            component.setCursor(defaultCursor);

            return component;
        }

        public void setColumnBeingSorted(int columnBeingSorted) {
            this.columnBeingSorted = columnBeingSorted;
        }
    }
