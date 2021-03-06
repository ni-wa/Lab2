/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Airplane;
import Model.AirplaneFleet;
import Model.AirplaneStatus;
import Model.Customer;
import Model.Flight;
import Model.Food;
import Model.Menu;
import Model.PhysicalSeat;
import Model.Seat;
import Model.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class InitData {
    AirplaneFleet airplaneFleet = new AirplaneFleet();
    
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

    public void createBookings(Flight flight) {
        Customer c1 = new Customer("Adam", "001");
        Customer c2 = new Customer("Bertil", "002");
        Customer c3 = new Customer("Ceasar", "003");
        Customer c4 = new Customer("David", "004");
        Customer c5 = new Customer("erik", "005");
        Food f1 = flight.getMenu().getFoodByNumber(1);
        Food f2 = flight.getMenu().getFoodByNumber(2);
        Food f3 = flight.getMenu().getFoodByNumber(3);
        flight.createBooking(Type.FIRST_CLASS, f1, c1);
        flight.createBooking(Type.FIRST_CLASS, f2, c2);
        flight.createBooking(Type.SECOND_CLASS, null, c3);
        flight.createBooking(Type.FIRST_CLASS, f1, c4);
        flight.createBooking(Type.FIRST_CLASS, f3, c5);
    }

    public Airplane createAirplane(int noOf1ClassSeats,
            int noOf2ndClassSeats, String name, AirplaneStatus airplaneStatus) {
        Airplane airplane = new Airplane(noOf1ClassSeats, noOf2ndClassSeats, name, airplaneStatus, airplaneFleet);
        return airplane;
    }

    public Flight createFlight() {
        Airplane airplane = createAirplane(5, 5, "Fokker03", AirplaneStatus.AVAILABLE);
        Menu menu = createMenu();
        Flight flight = new Flight(airplane, menu);
        return flight;

    }

    public AirplaneFleet getAirPlaneFleet() {
        return airplaneFleet;
    }

}
