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

    public String showBookingInformationForSeat(Seat seat) {
        StringBuffer sb = new StringBuffer();
        sb.append(seat.toString());
        return sb.toString();
    }

    /**
     * @return the airplane
     */
    public Airplane getAirplane() {
        return airplane;
    }

    /**
     * @param airplane the airplane to set
     */
    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    /**
     * @return the seats
     */
    public ArrayList<Seat> getSeats() {
        return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    /**
     * @return the departure
     */
    public LocalDateTime getDeparture() {
        return departure;
    }

    /**
     * @param departure the departure to set
     */
    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    /**
     * @return the arrival
     */
    public LocalDateTime getArrival() {
        return arrival;
    }

    /**
     * @param arrival the arrival to set
     */
    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    /**
     * @return the firstClassPrice
     */
    public int getFirstClassPrice() {
        return firstClassPrice;
    }

    /**
     * @param firstClassPrice the firstClassPrice to set
     */
    public void setFirstClassPrice(int firstClassPrice) {
        this.firstClassPrice = firstClassPrice;
    }

    /**
     * @return the secondClassPrice
     */
    public int getSecondClassPrice() {
        return secondClassPrice;
    }

    /**
     * @param secondClassPrice the secondClassPrice to set
     */
    public void setSecondClassPrice(int secondClassPrice) {
        this.secondClassPrice = secondClassPrice;
    }

    /**
     * @return the menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    
}
