package chatting.chat.vo;

public class Room {
    int roomNumber;
    String roomName;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roonName) {
        this.roomName = roonName;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roonName='" + roomName + '\'' +
                '}';
    }
}
