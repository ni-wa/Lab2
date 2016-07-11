package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {

    private ArrayList<Seat> seats;

    private LocalDateTime departure;

    private Airplane airplane;

    private int firstClassPrice;

    private int secondClassPrice;

    private Menu menu;

    private LocalDateTime arrival;
    
    public Flight(){
        this.firstClassPrice = 2222;
        this.secondClassPrice = 555;
    }

    public Seat createBooking(Customer customer, Food food, Seat seat) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Seat> getAvailableSeats() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Seat preliminaryBooking(Enum type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private List<PhysicalSeat> convertPhysicalSeatsToSeats(List<PhysicalSeat> physicalSeats) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
