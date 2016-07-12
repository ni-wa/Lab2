package Model;

import java.util.List;

public class Airplane {
    
    private List<PhysicalSeat> physicalSeats;

    private String status;

    public Airplane(List<PhysicalSeat> physicalSeats, String status) {
        this.physicalSeats = physicalSeats;
        this.status = status;
    }
    
    List<PhysicalSeat> getPhysicalSeats(){
        return physicalSeats;
    }
    int getNumberOfPhysicalSeats(){
        return physicalSeats.size();
    }
}
