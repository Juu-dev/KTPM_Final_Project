package interfaces;

import models.ThongTinCoSoVatChat;

public interface ICapNhatCoSoVatChat {
    public ThongTinCoSoVatChat thongTinCoSoVatChat(String name, String room);
    public void capNhatCSVC(String name, String room, String date, String description, int amount);
    public void themCSVC(String name, String room, String date, String description, int amount);
}
