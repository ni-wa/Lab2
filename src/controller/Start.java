/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Flight;
import Model.AirplaneFleet;

/**
 *
 * @author User
 */
public class Start {
    public static void main(String[] args) {
        
        InitData initData = new InitData();
        Flight flight = initData.createFlight();
        initData.createBookings(flight);
        AirplaneFleet airplaneFleet = initData.getAirPlaneFleet();
        Controller controller = new Controller(airplaneFleet, flight);
        controller.startInterface();
    }
}
