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

    /**
     * @return the seatNo
     */
    public int getSeatNo() {
        return seatNo;
    }

    /**
     * @return the type
     */
    public Enum getType() {
        return type;
    }

}
