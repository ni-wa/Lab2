package Model;

public class Customer {

    private String name;

    private int id;

    public Customer(String customerName, int id) {
        this.name = customerName;
        this.id = id;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
}
