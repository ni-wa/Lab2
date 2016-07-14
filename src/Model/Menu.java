package Model;

import java.util.ArrayList;
import java.util.List;


public class Menu {

    private List<Food> foodList = null;

    public Menu() {
        foodList = new ArrayList<>();
    }
    
    public Food getFoodByNumber(int foodId){
        List<Food> foodList = new ArrayList<>();
        foodList = getFoodList();
        for (Food food : foodList) {
            if (food.getFoodId() == foodId) {
                return food;
            }
        }
        return null;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }
    
}
