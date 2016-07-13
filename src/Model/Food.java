package Model;

/**
 * 
 * @author Andreas Gleerup
 */
public class Food  {
    
    private static int id = 1; // to automacially increase foodId
    private String foodName;
    private int price;
    private final int foodId;
    
    
    public Food(String foodName, int price) {
        this.foodName = foodName;
        this.price = price;
        foodId = id;
        id++;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return price;
    }

    public void setFoodName(String foodName) {
        
        this.foodName = foodName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return foodName+ "\t" + price + " kr"    ;
    }

    /**
     * @return the foodId
     */
    public int getFoodId() {
        return foodId;
    }
    
    
}
