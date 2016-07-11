package Model;

/**
 * 
 * @author Andreas Gleerup
 */
public class Food  {
    
    private String foodName;
    private int price;
    
    public Food(String foodName, int price) {
        this.foodName = foodName;
        this.price = price;
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
    
}
