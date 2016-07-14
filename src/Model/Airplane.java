package Model;

import java.util.ArrayList;
import java.util.List;

public class Airplane {
    private static int airplaneIdCounter = 1;
    
    public static final int MIN_NUMBER_OF_FIRST_CLASS_SEATS = 2;
    public static final int MAX_NUMBER_OF_FIRST_CLASS_SEATS = 500;

    public static final int MIN_NUMBER_OF_SECOND_CLASS_SEATS = 2;
    public static final int MAX_NUMBER_OF_SECOND_CLASS_SEATS = 500;

    private List<PhysicalSeat> physicalSeats = new ArrayList<>();
    private String name;
    private int airplaneId;
    private AirplaneStatus airplaneStatus;

    
    
    public Airplane() {
    }

//    public Airplane(List<PhysicalSeat> physicalSeats,
//            String name, AirplaneStatus airplaneStatus) {
//        this.name = name;
//        this.physicalSeats = physicalSeats;
//        this.airplaneId = airplaneIdCounter;
//        airplaneId++;
//    }

    public Airplane(int noOf1stClassSeats, int noOf2ndClassSeats,
            String name, AirplaneStatus airplaneStatus, AirplaneFleet airplaneFleet) {
        for (int i = 0; i < noOf1stClassSeats; i++) {
            PhysicalSeat ps = new Seat(i + 1, Type.FIRST_CLASS);
            physicalSeats.add(ps);
        }
        for (int i = noOf1stClassSeats; i < noOf1stClassSeats + noOf2ndClassSeats; i++) {
            PhysicalSeat ps = new Seat(i + 1, Type.SECOND_CLASS);
            physicalSeats.add(ps);
        }
        this.airplaneStatus = airplaneStatus;
        this.name = name;
        this.airplaneId = airplaneIdCounter;
        this.setAirplaneStatus(AirplaneStatus.AVAILABLE);
        airplaneIdCounter++;
        airplaneFleet.addAirplaneToFleet(this);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Id: " + getAirplaneId() + "\t Name: " + getName() +
                "\t" + this.getAirplaneStatus() + "\n");
        sb.append("Number of firstclass seats: " + getNumberOf1stClassSeats());
        sb.append("\tNumber of secondclass seats: " + getNumberOf2ndClassSeats() + "\n");
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the airplaneStatus
     */
    public AirplaneStatus getAirplaneStatus() {
        return airplaneStatus;
    }

    /**
     * @param airplaneStatus the airplaneStatus to set
     */
    public void setAirplaneStatus(AirplaneStatus airplaneStatus) {
        this.airplaneStatus = airplaneStatus;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the airplaneId
     */
    public int getAirplaneId() {
        return airplaneId;
    }

    /**
     * @param airplaneId the airplaneId to set
     */
    private void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }
}
