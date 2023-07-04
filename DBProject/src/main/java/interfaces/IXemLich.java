package interfaces;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public interface IXemLich {
    public void show(DefaultTableModel model);
    public ArrayList<String> showDetail(DefaultTableModel model, int index);
    public boolean checkAvailable(String room, LocalDateTime startTime, LocalDateTime endTime) ;
}
