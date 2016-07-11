/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Airplane;
import Model.Flight;
import Model.Food;
import Model.Menu;
import Model.PhysicalSeat;
import Model.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class InitData {

    public Menu createMenu() {
        Food f1 = new Food("Meat", 25);
        Food f2 = new Food("Veggie", 125);
        Food f3 = new Food("Other", 325);
        List<Food> foodList = new ArrayList<>();
        foodList.add(f1);
        foodList.add(f2);
        foodList.add(f3);
        Menu menu = new Menu();
        menu.setFoodList(foodList);
        return menu;
    }

    public Airplane createAirplane(
            int noOf1ClassSeats,
            int noOf2ndClassSeats,
            String status) {
        List<PhysicalSeat> physicalSeats = new ArrayList<>();
        for (int i = 0; i < noOf1ClassSeats; i++) {
            PhysicalSeat ps = new PhysicalSeat(i + 1, Type.FIRST_CLASS);
            physicalSeats.add(ps);
        }
        for (int i = noOf1ClassSeats + 1; i < noOf1ClassSeats + noOf2ndClassSeats; i++) {
            PhysicalSeat ps = new PhysicalSeat(i + 1, Type.SECOND_CLASS);
            physicalSeats.add(ps);
        }
        Airplane airplane = new Airplane(physicalSeats, "OK");
        return airplane;
    }
    
    public Flight createFlight(){
        Airplane airplane = createAirplane(5, 5, "OK");
        Menu menu = createMenu();
        Flight flight = new Flight(menu, airplane);
        return flight;
        
    }

}


