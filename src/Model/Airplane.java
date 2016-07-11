package Model;

import java.util.List;

public class Airplane {

    private List<PhysicalSeat> physicalSeats;

    private String status;
    
    List<PhysicalSeat> getPhysicalSeats(){
        return physicalSeats;
    }
    int getNumberOfPhysicalSeats(){
        return physicalSeats.size();
    }
}
