package Model;

public class Customer {

    private String name;

    private String id;

    public Customer(String customerName, String id) {
        this.name = customerName;
        this.id = id;
    }

    public String toString(){
        return "Name: " + name + "\t\tId: " + id;
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
    public String getId() {
        return id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    
}
