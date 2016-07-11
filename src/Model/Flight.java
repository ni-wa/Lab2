package Model;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Flight {

    private Airplane airplane;
    private ArrayList<Seat> seats;
    private LocalDateTime departure;
    private LocalDateTime arrival;
    private int firstClassPrice;
    private int secondClassPrice;
    private Menu menu;
      
    public Flight(Airplane airplane, Menu menu){
        this.airplane = airplane;
        //When a flight is defined, a list of bookable Seats is defined 
        //with equal number of seats as available Physical seats 
        //in the actual type of Airplane.
        Seat[] seats = new Seat[airplane.getNumberOfPhysicalSeats()];

        departure = LocalDateTime.of(2016,12,24,12,00);
        arrival = LocalDateTime.of(2016,12,24,13,00);
        firstClassPrice = 2222;
        secondClassPrice = 555;
        this.menu = menu;
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
    
    public String showBookingInformationForSeat(Seat seat){
        throw new UnsupportedOperationException("Not supported yet.");       
    }
}
