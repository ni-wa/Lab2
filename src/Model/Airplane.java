package Model;

import java.util.List;

public class Airplane {

    public Airplane(){
    }

    public Airplane(List<PhysicalSeat> physicalSeats, String status) {
        this.physicalSeat = physicalSeats;
        this.status = status;
    }
    
    private List<PhysicalSeat> physicalSeat;

    private String status;
}
