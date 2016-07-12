package Model;

public class PhysicalSeat {

    int seatNo;

    Enum type;

    public PhysicalSeat() {
    }

    public PhysicalSeat(int seatNo, Type type) {
        this.seatNo = seatNo;
        this.type = type;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public Enum getType() {
        return type;
    }

}
