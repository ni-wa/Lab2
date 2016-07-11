package Model;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Food> foodList = null;

    public Menu() {
        foodList = new ArrayList<>();
    }

    
    
    
    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public List getFoodList() {
        return foodList;
    }

    @Override
    public String toString() {
        return "Foodlist";
    }
}
