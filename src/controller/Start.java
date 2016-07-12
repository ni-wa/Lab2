/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Flight;

/**
 *
 * @author User
 */
public class Start {
    public static void main(String[] args) {
        
        InitData intiData = new InitData();
        Flight flight = intiData.createFlight();
        Controller controller = new Controller(flight);
        controller.startInterface();
    }
}
