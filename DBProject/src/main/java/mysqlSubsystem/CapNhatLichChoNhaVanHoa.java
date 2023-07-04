package mysqlSubsystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

import database.MysqlConnection;
import interfaces.ICapNhatLichChoNhaVanHoa;
import models.LenLichSuKien;


public class CapNhatLichChoNhaVanHoa implements ICapNhatLichChoNhaVanHoa {

    private String roomName;
    private String startTime;
    private String finishTime;
    private String eventName;
    private String eventDescriptions;
    private int fee;

    private LenLichSuKien lenLichSuKien = new LenLichSuKien(roomName, startTime, finishTime, eventName, eventDescriptions, fee);

    public boolean capNhatLichChoPhong(LenLichSuKien lenLichSuKien) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            // Lấy ra EventID cao nhất trong bảng EventTable
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT MAX(EVENTID) AS EVENTID FROM EVENTTABLE");
            int eventID;
            if (rs.next()) {
                eventID = rs.getInt("EVENTID") + 1;
            } else {
                eventID = 0;
            }
            // Xong phần lấy ra EventID
            String query = "INSERT INTO EVENTTABLE(EVENTID,\n"
                    + "EVENTNAME,\n"
                    + "STARTTIME ,\n"
                    + "FINISHTIME ,\n"
                    + "ROOMNAME ,\n"
                    + "EVENTDESCRIPTION ,\n"
                    + "FEE,\n"
                    + "NOTE) \n"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstatement = connection.prepareStatement(query);
            pstatement.setInt(1, eventID);
            pstatement.setString(2, lenLichSuKien.getEventName());
            pstatement.setString(3, lenLichSuKien.getStartTime());
            pstatement.setString(4, lenLichSuKien.getFinishTime());
            pstatement.setString(5, lenLichSuKien.getRoomName());
            pstatement.setString(6, lenLichSuKien.getEventDescriptions());
            pstatement.setInt(7, lenLichSuKien.getFee());
            int i = pstatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
}
