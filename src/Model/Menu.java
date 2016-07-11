package Model;

import java.util.ArrayList;
import java.util.List;


public class Menu {

    private List<Food> foodList = null;

    public Menu() {
        foodList = new ArrayList<>();
        InitData id = new InitData();
        foodList = id.createMenu();

    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }
    
}
