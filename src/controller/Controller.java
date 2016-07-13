package controller;

import view.View;
import Model.Airplane;
import Model.Customer;
import Model.Flight;
import Model.Profit;
import Model.Seat;
import Model.Type;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private View view;
    private Flight flight;
    private Airplane airPlane;
    private Profit profit = new Profit();
    
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
            } else if (choice == 2) {
                profitCalculation();
            } else {
                choice = 0;
            }
        }
    }

    private void bookingProcedure() {
        int choice = -1;

        int[] seatsAvaileblaAndPrices = flight.getAvailableSeats();
        int noOf1stClassSeatsAvail = seatsAvaileblaAndPrices[0];
        int noOf2ndClassSeatsAvail = seatsAvaileblaAndPrices[1];
        int price1stClass = seatsAvaileblaAndPrices[2];
        int price2ndClass = seatsAvaileblaAndPrices[3];

        int seatNo = 0;
        while (choice < 0) {
            choice = view.showAvailableSeats(noOf1stClassSeatsAvail,
                    price1stClass, noOf2ndClassSeatsAvail, price2ndClass);
            switch (choice) {
                case 1:
                    seatNo = flight.createTempBooking(Type.FIRST_CLASS);
                    break;

                case 2:
                    seatNo = flight.createTempBooking(Type.SECOND_CLASS);
                    break;
            }
        }
        choice = -1;
        Seat seat = null;
        while (choice < 0) {
            choice = view.showFood(flight.getMenu());
            seat = flight.getSeatByNumber(seatNo);
            seat.setFood(flight.getMenu().getFoodByNumber(choice));
        }
        Customer customer = null;
        if (seat != null && customer != null) {
            while (customer == null) {
                customer = view.showGetCustomerData();
            }
            view.showBookingData(flight, seat);
        }
    }

    private void profitCalculation() {
        int choice = -1;

        int profitSKr = profit.profitCalc(flight);
        view.showProfit(profitSKr);
    }
}
