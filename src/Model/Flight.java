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
    
    private Customer tempCustomer = new Customer("TempBooking", "");
      
    public Flight(Airplane airplane, Menu menu){
        this.airplane = airplane;
        airplane.setAirplaneStatus(AirplaneStatus.BUSY);
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
    
     public void updateTempBookingToRealBooking(Seat seat, Customer customer) {
         seat.setCustomer(customer);
    }
    
    public int createBooking(Type type, Food food, Customer customer){
        Seat seat = getFirstAvailableSeat(type);
        seat.setCustomer(customer);
        if (food != null) {
            seat.setFood(food);
        }
        return seat.getSeatNo();
    }
    
    public void setFoodAndSeatByNumbers(int seatNumber, int foodNumber){
        Seat seat = getSeatByNumber(seatNumber);
        Food food = menu.getFoodByNumber(foodNumber);
        seat.setFood(food);
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

    //TODO implement reservation of alternative class
//    public Seat preliminaryBooking(Enum type) {
//        for (Seat seat : seats) {
//            if (seat.getType() == type 
//                    && (seat.getPrelBooked() != false)) {
//                seat.setPrelBooked(true);
//                return seat;
//            }
//        }
//        return null;
//    }

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
 
    public int getNoOf1stClassSeatsAvail(){
       int noOf1stClassSeatsAvail = airplane.getNumberOf1stClassSeats();
        for (Seat seat : seats) {
            if (seat.getType() == Type.FIRST_CLASS 
                    && seat.isBooked()) {
                noOf1stClassSeatsAvail--;
            }
        }
        return noOf1stClassSeatsAvail;
    }
    public int getNoOf2ndClassSeatsAvail(){
        int noOf2ndClassSeatsAvail = airplane.getNumberOf2ndClassSeats();
        for (Seat seat : seats) {
            if (seat.getType() == Type.SECOND_CLASS 
                    && seat.isBooked()) {
                noOf2ndClassSeatsAvail--;
            }
        }
        return noOf2ndClassSeatsAvail;
    }

    public int getNoOf1stClassSeatsBooked(){
       int noOf1stClassSeatsBooked = 0;
        for (Seat seat : seats) {
            if (seat.getType() == Type.FIRST_CLASS 
                    && seat.isBooked()) {
                noOf1stClassSeatsBooked++;
            }
        }
        return noOf1stClassSeatsBooked;
    }
    public int getNoOf2ndClassSeatsBooked(){
        int noOf2ndClassSeatsBooked = 0;
        for (Seat seat : seats) {
            if (seat.getType() == Type.SECOND_CLASS 
                    && seat.isBooked()) {
                noOf2ndClassSeatsBooked++;
            }
        }
        return noOf2ndClassSeatsBooked;
    }
    
    public Seat getSeatByNumber(int seatNumber){
        for (Seat seat : seats) {
            if (seat.getSeatNo() == seatNumber) {
                return seat;
            }
        }
        return null;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Departure:\t" + departure + "\t Arrival:\t"+ arrival);
        return sb.toString();
    }
    
    public void showAllFlightData() {
        this.toString();
        for (Seat seat : seats) {
            System.out.println(seat.toString());
        }
        System.out.println(airplane.toString());
    }
    
    

    public Airplane getAirplane() {
        return airplane;
    }
    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }
    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }
    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }
    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public int getFirstClassPrice() {
        return firstClassPrice;
    }
    public void setFirstClassPrice(int firstClassPrice) {
        this.firstClassPrice = firstClassPrice;
    }

    public int getSecondClassPrice() {
        return secondClassPrice;
    }
    public void setSecondClassPrice(int secondClassPrice) {
        this.secondClassPrice = secondClassPrice;
    }

    public Menu getMenu() {
        return menu;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }  
}
