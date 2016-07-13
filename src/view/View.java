package view;

import Model.Seat;
import Model.Flight;
import Model.Customer;
import Model.Food;
import Model.Menu;
import com.sun.xml.internal.ws.util.StringUtils;
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
        "1 Boka resa\n",
        "2 Profit\n",
        "3 Visa all flight info"};

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
                if (string.length() > 0) {
                    System.out.println(string);
                }
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

    public static String getString(String message, int minLength, int maxLength) {
        String input = null;// = "";
        boolean error = true;
        while (error) {
            System.out.println(message);
            if (scanner.hasNext()) {
                input = scanner.next();
                if (minLength <= input.trim().length()
                        || maxLength >= input.trim().length()) {
                    error = false;
                }
            } else {
                error = true;
                scanner.next();
            }
        }
//        scanner.nextLine();
        return input;
    }

    public int ShowStartScreen() {
        int input = showOptions(startScreenText);
        return input;
    }

    public int showAvailableSeats(int noOf1stClassSeatsAvail, int price1stClass, int noOf2ndClassSeatsAvail, int price2ndClass) {
        String[] text = new String[4];
        if (noOf1stClassSeatsAvail == 0 && noOf2ndClassSeatsAvail == 0) {
            System.out.println("Sorry!\n");
            System.out.println("Alla biljetter är slut!!!");
            return -1;
        }
        String showFirstClassAlternative = "";
        if (noOf1stClassSeatsAvail > 0) {
            showFirstClassAlternative = "Förstaklassbiljetter:\t" + noOf1stClassSeatsAvail + " stycken\tPris: " + price1stClass + " kr\n";
        }
        String showSecondClassAlternative = "";
        if (noOf2ndClassSeatsAvail > 0) {
            showSecondClassAlternative = "Andraklassbiljetter:\t"
                    + noOf2ndClassSeatsAvail + " stycken\tPris: " + price2ndClass + " kr\n";
        }
        text[0] = instructions + showFirstClassAlternative + showSecondClassAlternative;
//                + "Förstaklassbiljetter:\t" + noOf1stClassSeatsAvail + " stycken\tPris: " + price1stClass + " kr\n"
//                + "Andraaklassbiljetter:\t" + noOf2ndClassSeatsAvail + " stycken\tPris: " + price2ndClass + " kr\n";

        text[1] = exitChoice;
        if (noOf1stClassSeatsAvail > 0) {
            text[2] = "1 Boka en förstaklassbiljett";
        } else {
            text[2] = "";
        }
        if (noOf2ndClassSeatsAvail > 0) {
            text[3] = "2 Boka en andraklassbiljett";
        } else {
            text[3] = "";
        }

        return showOptions(text);
    }

    public int showFood(Menu menu) {
        List<Food> foodList = new ArrayList<>(menu.getFoodList());
        int noOfFoodChoices = menu.getFoodList().size() + 2; // +2  to make room for instructions and 0 alternative
        String[] foodAlternatives = new String[noOfFoodChoices];
        foodAlternatives[0] = instructions;
        foodAlternatives[1] = "0 Ingen mat önskas";
        int i = 2;
        for (Food food : foodList) {
            foodAlternatives[i] = i - 1 + " " + food.toString();
            i++;
        }
        return showOptions(foodAlternatives);
    }

    public Customer showGetCustomerData() {
        String getNameText = "Mata in kundens namn\t";
        String getIdText = "Mata in kundens id. Max 10 tecken\t";

        String customerName = getString(getNameText, 2, 100);
        int id = 0;
        boolean notNumeric = true;
//        scanner.next();
        String customerId = getString(getIdText, 4, 4);

//        while (notNumeric) {
//            String customerId = getString(getIdText, 10);
//            if (customerId.matches("\\d+")) {
//                notNumeric = false;
//                id = Integer.parseInt(customerId);
//            }
//            
//        }
        Customer customer = new Customer(customerName, customerId);
        System.out.println("C name=" + customerName + "\tcusId=" + customerId);
        return customer;
    }

    public Seat showBookingData(Flight flight, Seat seat) {
        System.out.println("\n\n");
        String bookingInformation = flight.showBookingInformationForSeat(seat);
        System.out.println("Bokningsinformation:\n" + bookingInformation);
        System.out.println(flight.toString());
        System.out.println("\n\n");
        return seat;
    }

    public void showAllFligthData(Flight flight) {
        flight.showAllFlightData();

    }
}
