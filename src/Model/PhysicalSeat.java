package Model;

public class PhysicalSeat {
    public PhysicalSeat(){
    }
    public PhysicalSeat(int seatNo, Type type){
        this.seatNo = seatNo;
        this.type = type;
               
    }
    private int seatNo;

    private Enum type;
}
