package Model;

import java.util.ArrayList;
import java.util.List;

public class Airplane {

    private List<PhysicalSeat> physicalSeats = new ArrayList<>();

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
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Number of firstclass seats: " + getNumberOf1stClassSeats());
        sb.append("\tNumber of secondclass seats: " + getNumberOf2ndClassSeats()+ "\n");
        return sb.toString();
    }

    List<PhysicalSeat> getPhysicalSeats() {
        return physicalSeats;
    }

    int getNumberOfPhysicalSeats() {
        return physicalSeats.size();
    }

    int getNumberOf1stClassSeats() {
        int i = 0;
        for (PhysicalSeat seat : physicalSeats) {
            if (seat.getType() == Type.FIRST_CLASS) {
                i++;
            }
        }
        return i;
    }

    int getNumberOf2ndClassSeats() {
        int i = 0;
        for (PhysicalSeat seat : physicalSeats) {
            if (seat.getType() == Type.SECOND_CLASS) {
                i++;
            }
        }
        return i;
    }
}
