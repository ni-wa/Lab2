package Model;

import java.util.ArrayList;
import java.util.List;

class InitData {

    public Flight createFlight() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Food> createMenu() {

        List foodList = new ArrayList<>();
        foodList.add(new Food("Öjebytoast", 195));        
        foodList.add(new Food("Rimmad lax", 260));           
        foodList.add(new Food("Köttbullar med gräddsås", 195));           
        foodList.add(new Food("Isterband med kapris", 195));           
        foodList.add(new Food("Wallenbergare", 285));           
        foodList.add(new Food("Råbiff med klassiska tillbehör", 275));           
        foodList.add(new Food("Grillad hängmörad biff", 325));          
        return foodList;
       
    }

    private Airplane createAirplane() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
