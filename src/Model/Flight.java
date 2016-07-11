package Model;

import java.time.LocalDateTime;
import java.time.Month;
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
      
    public Flight(Menu menu, Airplane airplane){
        firstClassPrice = 2222;
        secondClassPrice = 555;
        this.menu = menu;
        this.airplane = airplane;
        departure = LocalDateTime.of(2016,12,24,12,00);
        arrival = LocalDateTime.of(2016,12,24,13,00);
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
