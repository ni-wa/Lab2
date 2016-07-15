package controller;

import view.View;
import Model.Airplane;
import Model.AirplaneFleet;
import Model.Customer;
import Model.Flight;
import Model.Profit;
import Model.Seat;
import Model.Type;
import Model.AirplaneStatus;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private View view;
    private Flight flight;
    private Airplane airPlane;
//    private List<Airplane> airplaneList = new ArrayList<>();
    private AirplaneFleet airplaneFleet;
    private Profit profit = new Profit();

    private int[] seatsAvaileblaAndPrices;
    private int noOf1stClassSeatsAvail;
    private int noOf2ndClassSeatsAvail;
    private int price1stClass;
    private int price2ndClass;

    Controller(AirplaneFleet airplaneFleet, Flight flight) {
        this.flight = flight;
        this.airplaneFleet = airplaneFleet;
    }

    public void startInterface() {
        view = new View();
        int choice = -1;
        while (choice != 0) {

            seatsAvaileblaAndPrices = flight.getAvailableSeats();
            noOf1stClassSeatsAvail = seatsAvaileblaAndPrices[0];
            noOf2ndClassSeatsAvail = seatsAvaileblaAndPrices[1];
            price1stClass = seatsAvaileblaAndPrices[2];
            price2ndClass = seatsAvaileblaAndPrices[3];

            choice = view.ShowStartScreen();
            if (choice == 1) {
                bookingProcedure();
            }
            if (choice == 3) {
                view.showAllFligthData(flight);
            } else if (choice == 2) {
                profitCalculation();
            } else if (choice == 4) {
                addAirplane();
            } else if (choice == 5) {
                removeAirplane();
            } else if (choice == 6) {
                changeAirplane();
            } else if (choice == 7) {
                showAllAirplanes();
            }
        }
    }

    private void bookingProcedure() {
        int choice = -1;

        seatsAvaileblaAndPrices = flight.getAvailableSeats();
        noOf1stClassSeatsAvail = seatsAvaileblaAndPrices[0];
        noOf2ndClassSeatsAvail = seatsAvaileblaAndPrices[1];
        price1stClass = seatsAvaileblaAndPrices[2];
        price2ndClass = seatsAvaileblaAndPrices[3];
        boolean seatsAvail = false;
        if (noOf1stClassSeatsAvail > 0 || noOf2ndClassSeatsAvail > 0) {
            seatsAvail = true;
        }

        int seatNo = 0;
        while (choice < 0) {
            choice = view.showAvailableSeats(noOf1stClassSeatsAvail,
                    price1stClass, noOf2ndClassSeatsAvail, price2ndClass);

            if ((choice == 1 && flight.getNoOf1stClassSeatsAvail() <= 0)
                    || (choice == 2 && flight.getNoOf2ndClassSeatsAvail() <= 0)) {
                choice = -1;
            }

            switch (choice) {
                case 0:
                    choice = 0;
                    break;
                case 1:
                    seatNo = flight.createTempBooking(Type.FIRST_CLASS);
                    System.out.println("Temporär bokning gjord!\n");
                    break;

                case 2:
                    seatNo = flight.createTempBooking(Type.SECOND_CLASS);
                    System.out.println("Temporär bokning gjord!\n");
                    break;
            }
        }
        if (seatNo > 0) {
            choice = -1;
            Seat seat = flight.getSeatByNumber(seatNo);
            while (choice < 0) {
                choice = view.showFood(flight.getMenu());
                flight.setFoodAndSeatByNumbers(seatNo, choice);
            }
            Customer customer = null;
            if (customer == null) {
                while (customer == null) {
                    customer = view.showGetCustomerData();
                }
                flight.updateTempBookingToRealBooking(seat, customer);
                view.showBookingData(flight, seat);
            }
        }
    }

    private void profitCalculation() {
        int choice = -1;
        int profitSKr = profit.profitCalc(flight);
        view.showProfit(profitSKr);
    }

    private void addAirplane() {
        String airplaneName = view.getAirplaneName();
        int numberOf1stClassSeats = view.getNumberOfFirstClassSeats();
        int numberOf2ndClassSeats = view.getNumberOfSecondClassSeats();
        Airplane airplane = new Airplane(
                numberOf1stClassSeats, numberOf2ndClassSeats,
                airplaneName, AirplaneStatus.AVAILABLE, airplaneFleet);
    }

    private void removeAirplane() {
        List<Airplane> airPlaneList = airplaneFleet.getAirPlaneList();
        int idOfAirplaneToRemove
                = view.showRemoveAirplaneAlternatives(airPlaneList);
        Airplane airplane = airplaneFleet.getAirplaneById(idOfAirplaneToRemove);
        airplaneFleet.removeAirplane(airplane);
    }

    private void changeAirplane() {
        List<Airplane> availableAirplanes = airplaneFleet.getAirPlaneListByStatus(AirplaneStatus.AVAILABLE);

        int listNumber = view.changeAirplaneForFlight(flight, availableAirplanes) - 1;
        if (listNumber < 0) {
            return;
        }
        Airplane airplane = availableAirplanes.get(listNumber);
        flight.getAirplane().setAirplaneStatus(AirplaneStatus.AVAILABLE);
        airplane.setAirplaneStatus(AirplaneStatus.BUSY);
        flight.setAirplane(airplane);
    }

    private void showAllAirplanes() {
//        airplaneFleet.
        System.out.println(airplaneFleet.toString());
    }

}
