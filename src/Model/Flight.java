package Model;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Flight {

    private Airplane airplane;
    private ArrayList<Seat> seats = new ArrayList<>();
    private LocalDateTime departure;
    private LocalDateTime arrival;
    private int firstClassPrice;
    private int secondClassPrice;
    private Menu menu;
    
    private Customer tempCustomer = new Customer("TempBooking", 0);
      
    public Flight(Airplane airplane, Menu menu){
        this.airplane = airplane;
        //When a flight is defined, a list of bookable Seats is defined 
        //with equal number of seats as available Physical seats 
        //in the actual type of Airplane.
        seats = convertPhysicalSeatsToSeats(airplane.getPhysicalSeats());
        //Seat[] seats = new Seat[airplane.getNumberOfPhysicalSeats()];

        departure = LocalDateTime.of(2016,12,24,12,00);
        arrival = LocalDateTime.of(2016,12,24,13,00);
        firstClassPrice = 2222;
        secondClassPrice = 555;
        this.menu = menu;
    }
    
    
    private int createBooking(Customer customer, Food food, Seat seat){
        seat.setCustomer(customer);
        if (food != null) {
            seat.setFood(food);
        }
        return seat.getSeatNo();
    }
    
    public int createTempBooking(Type type){
        Seat seat = getFirstAvailableSeat(type);
        createBooking(tempCustomer, null, seat);
        return seat.getSeatNo();
    }
    
    private Seat getFirstAvailableSeat(Type type){
        for (Seat seat : seats) {
            if (!seat.isBooked() && seat.getType() == type) {
                return seat;
            }
            
        }
        return null;
    }

    public int[] getAvailableSeats() {
        int numberOf1stClassSeatsAvail = getNoOf1stClassSeatsAvail();
        int numberOf2ndClassSeatsAvail = getNoOf2ndClassSeatsAvail();
        int price1stClass = getFirstClassPrice();
        int price2ndClass = getSecondClassPrice();
        int[] availSeatsAndPrices = {numberOf1stClassSeatsAvail,
            numberOf2ndClassSeatsAvail, price1stClass, price2ndClass};
        return availSeatsAndPrices;
        }

    public Seat preliminaryBooking(Enum type) {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private ArrayList<Seat> convertPhysicalSeatsToSeats(List<PhysicalSeat> physicalSeats) {
        for (PhysicalSeat physicalSeat : physicalSeats) {
            seats.add((Seat) physicalSeat);
        }
        return seats;
    }

    public String showBookingInformationForSeat(Seat seat) {
        StringBuffer sb = new StringBuffer();
        sb.append(seat.toString());
        return sb.toString();
    }
    
    public int getNoOf1stClassSeats(){
        int noOf1stClassSeats = 0;
        for (Seat seat : seats) {
            if (seat.getType() == Type.FIRST_CLASS) {
                noOf1stClassSeats++;
            }
        }
        return noOf1stClassSeats;
    }
    
    public int getNoOf2ndClassSeats(){
       int noOf2ndClassSeats = 0;
        for (Seat seat : seats) {
            if (seat.getType() == Type.SECOND_CLASS) {
                noOf2ndClassSeats++;
            }
        }
        return noOf2ndClassSeats;
    }
    
    public int getNoOf1stClassSeatsAvail(){
       int noOf1stClassSeatsAvail = getNoOf1stClassSeats();
        for (Seat seat : seats) {
            if (seat.getType() == Type.FIRST_CLASS 
                    && seat.isBooked()) {
                noOf1stClassSeatsAvail--;
            }
        }
        return noOf1stClassSeatsAvail;
    }
    public int getNoOf2ndClassSeatsAvail(){
        int noOf2ndClassSeatsAvail = getNoOf2ndClassSeats();
        for (Seat seat : seats) {
            if (seat.getType() == Type.SECOND_CLASS 
                    && seat.isBooked()) {
                noOf2ndClassSeatsAvail--;
            }
        }
        return noOf2ndClassSeatsAvail;
    }
    
    public Seat getSeatByNumber(int seatNumber){
        for (Seat seat : seats) {
            if (seat.getSeatNo() == seatNumber) {
                return seat;
            }
        }
        return null;
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
