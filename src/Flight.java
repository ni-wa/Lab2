public class Flight {

    private ArrayList<Seat> seats;

    private LocalDateTime departure;

    private Airplane airplane;

    private int FirstClassPrice;

    private int secondClassPrice;

    private Menu menu;

    private LocalDateTime arrival;

    public Seat createBooking(Customer customer, Food food, Seat seat) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Seat> getAvailableSeats() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Seat preliminaryBooking(Enum type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private List<PhysicalSeats> convertPhysicalSeatsToSeats(List<PhysicalSeats> physicalSeats) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
