package view;

import Model.Seat;
import Model.Flight;
import Model.Customer;
import Model.Food;
import Model.Menu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class View {

    static protected Scanner scanner;

    String instructions = "Vad vill du göra?\n";
    String exitChoice = "0 Avsluta\n";

    String[] startScreenText = {
        instructions,
        exitChoice,
        "1 Profit\n",
        "2 Boka resa\n"};

    String[] availableSeats1stClassText = {
        "1 Boka förstaklassbiljett\n"
    };
    String[] availableSeats2ndClassText = {
        "1 Boka andraklassbiljett\n"
    };
    
    public View() {
        scanner = new Scanner(System.in);
    }

    public static int showOptions(String[] message) {
        int maxAcceptableInt = message.length - 1;
        int input = 0;
        boolean error = true;
        while (error) {
            for (String string : message) {
                System.out.println(string);
            }
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 0 && input <= maxAcceptableInt) {
                    error = false;
                }
            } else {
                error = true;
                scanner.next();
            }
        }
        return input;
    }
    public static String getString(String message, int maxLength) {
        String input = "";
        boolean error = true;
        while (error) {
            System.out.println(message);
            if (scanner.hasNext()) {
                input = scanner.nextLine();
                if (input.length() < 1 || input.length() > maxLength) {
                    error = false;
                }
            } else {
                error = true;
                scanner.next();
            }
        }
        return input;
    }

    public int ShowStartScreen() {
        int input = showOptions(startScreenText);
        return input;
    }

    public int showAvailableSeats(int noFo1stClassSeatsAvail, int price1stClass, int noOf2ndClassAvailable, int price2ndClass) {
        String[] text = new String[4];
        if (noFo1stClassSeatsAvail == 0 && noOf2ndClassAvailable == 0) {
            System.out.println("Sorry!\n");
            System.out.println("Alla biljetter är slut!!!");
            return -1;
        }
        text[0] = instructions;
        text[1] = exitChoice;

        text[2] = "Förstaklassbiljetter:\t" + noFo1stClassSeatsAvail + " stycken\nPris:" + price1stClass + " kr";
        text[3] = "Andraklassbiljetter:\t" + noOf2ndClassAvailable + " stycken\nPris:" + price2ndClass + " kr";
        return showOptions(text);
    }

    public int showFood(Menu menu) {
        List<Food> foodList = new ArrayList<>(menu.getFoodList());
        int noOfFoodChoices = menu.getFoodList().size() + 2; // +2  to make room for instructions and 0 alternative
        String[] foodAlternatives = new String[noOfFoodChoices];
        foodAlternatives[0] = instructions;
        foodAlternatives[1] = "Ingen mat önskas";
        int i = 1;
        for (Food food : foodList) {
            foodAlternatives[i] = i + " " + food.toString();
        }
        return showOptions(foodAlternatives);
    }

    public Customer showGetCustomerData() {
        String getNameText = "Mata in kundens namn\t";
        String getIdText = "Mata in kundens id. Max 4 siffror\t";
        
        String getCustomerName = getString(getNameText, 100);
        String getCustomerId = getString(getIdText, 10);
        int id = Integer.parseInt(getCustomerId);
        Customer c = new Customer(getCustomerName, id);
        return c;
    }

    public Seat showBookingData(Flight flight, Seat seat) {
        String bookingInformation = flight.showBookingInformationForSeat(seat);
        System.out.println("Bokningsinformation:\t" + bookingInformation);
        return seat;
    }
}
