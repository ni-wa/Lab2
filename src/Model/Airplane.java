package Model;

import java.util.List;

public class Airplane {

    private List<PhysicalSeat> physicalSeats;

    private String status;

    public Airplane(List<PhysicalSeat> physicalSeats, String status) {
        this.physicalSeats = physicalSeats;
        this.status = status;
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
