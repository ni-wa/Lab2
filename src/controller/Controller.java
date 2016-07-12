package controller;

import view.View;
import Model.Airplane;
import Model.Flight;
import Model.Seat;
import Model.Type;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private View view;

    private Flight flight;

    private Airplane airPlane;

    Controller(Flight flight) {
        this.flight = flight;
    }

    public void startInterface() {
        view = new View();
        int choice = -1;
        while (choice != 0) {
            choice = view.ShowStartScreen();
           if (choice == 1) {
               bookingProcedure();
           } else {
               choice = 0;
           }
        }
    }
    
    private void bookingProcedure() {
        int choice = -1;
        while (choice != 0) {
            int[] seatsAvaileblaAndPrices = flight.getAvailableSeats();
            int noOf1stClassSeatsAvail = seatsAvaileblaAndPrices[0];
            int noOf2ndClassSeatsAvail = seatsAvaileblaAndPrices[1];
            int price1stClass = seatsAvaileblaAndPrices[2];
            int price2ndClass = seatsAvaileblaAndPrices[3];
            choice = view.showAvailableSeats(noOf1stClassSeatsAvail, 
                    price1stClass, noOf2ndClassSeatsAvail, price2ndClass);
        }
    }
}
