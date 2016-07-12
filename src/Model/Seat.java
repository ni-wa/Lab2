package Model;

public class Seat extends PhysicalSeat {

    private Customer customer;

    private Food food;

    public boolean isBooked() {
        if (getCustomer() == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the food
     */
    public Food getFood() {
        return food;
    }

    /**
     * @param food the food to set
     */
    public void setFood(Food food) {
        this.food = food;
    }
}
