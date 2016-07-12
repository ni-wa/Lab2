package Model;

public class Seat extends PhysicalSeat {

    private Customer customer;
    private Food food;

    public Seat(int seatNo, Type type){
        this.seatNo = seatNo;
        this.type = type;
    }
    
    public boolean isBooked() {
        if (getCustomer() == null) {
            return false;
        } else {
            return true;
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
