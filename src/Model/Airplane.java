package Model;

import java.util.List;

public class Airplane {

    private List<PhysicalSeat> physicalSeats;

    private String status;

    public Airplane() {
    }

    public Airplane(List<PhysicalSeat> physicalSeats, String status) {
        this.physicalSeats = physicalSeats;
        this.status = status;
    }
    
    public Airplane(int noOf1stClassSeats, int noOf2ndClassSeats, String status) {
        for (int i = 0; i < noOf1stClassSeats; i++) {
            PhysicalSeat ps = new Seat(i + 1, Type.FIRST_CLASS);
            physicalSeats.add(ps);
        }
        for (int i = noOf1stClassSeats + 1; i < noOf1stClassSeats + noOf2ndClassSeats; i++) {
            PhysicalSeat ps = new Seat(i + 1, Type.SECOND_CLASS);
            physicalSeats.add(ps);
        }
        this.status = status;
    }

    List<PhysicalSeat> getPhysicalSeats() {
        return physicalSeats;
    }

    int getNumberOfPhysicalSeats() {
        return physicalSeats.size();
    }
}
