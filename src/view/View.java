package view;

import Model.Seat;
import Model.Flight;
import Model.Customer;
import Model.Food;
import Model.Menu;
import Model.Airplane;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    static protected Scanner scanner;

    String instructions = "\n\nVad vill du göra?\n";
    String exitChoice = "0 Avsluta";

    String[] startScreenText = {
        instructions,
        exitChoice,
        "1 Boka resa",
        "2 Profit",
        "3 Visa all flight info",
        "4 Lägg till flygplan",
        "5 Tag bort flygplan",
        "6 Byt flygplan för flighten",
        "7 Visa alla flygplan"};
    
        

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

    public int showAvailableSeats(int noOf1stClassSeatsAvail, int price1stClass, 
            int noOf2ndClassSeatsAvail, int price2ndClass) {
        int arrayLength = 4; // 2 alternatives + Instructions + exit alternative
        String[] text = new String[arrayLength];
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
    
    public int showRemoveAirplaneAlternatives(List<Airplane> airplaneList){
        String[] removeAirplaneAlternatives = new String[airplaneList.size() + 2]; // instruction and go back alternative -> 2
        removeAirplaneAlternatives[0] = "Välj id på plan som skall tas bort";
        removeAirplaneAlternatives[1] = "0 Avbryt";
        int i = 2;
        for (Airplane airplane : airplaneList) {
            removeAirplaneAlternatives[i] = airplane.toString();
            i++;
        }
        int choice = showOptions(removeAirplaneAlternatives);
        return choice;
    }

    public Customer showGetCustomerData() {
        String getNameText = "Mata in kundens namn\t";
        String getIdText = "Mata in kundens id. Max 10 tecken\t";

        String customerName = getString(getNameText, 2, 100);
        int id = 0;
        boolean notNumeric = true;
        String customerId = getString(getIdText, 2, 10);
        Customer customer = new Customer(customerName, customerId);
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

    
    public void showProfit(int profit){
        System.out.println("\nProfiten är " + profit + " Skr.");
        return;
    }

    public String getAirplaneName() {
        String getNameText = "Mata in flygplanest namn (minst Mellan 2 och 40 bokst/siffror";
        String airplaneName = getString(getNameText, 2, 40);
        return airplaneName;
    }
    
    public int getNumberOfFirstClassSeats(){
        String getNumberOf1stClassSeats = "Mata in antalet förstaklassplatser (mellan 2 och 999)";
        int  numberOf1stClassSeats = getInt(getNumberOf1stClassSeats,
                Airplane.MIN_NUMBER_OF_FIRST_CLASS_SEATS, Airplane.MAX_NUMBER_OF_FIRST_CLASS_SEATS);
        return numberOf1stClassSeats;
    }
    
    public int getNumberOfSecondClassSeats(){
        String getNumberOf2ndClassSeats = "Mata in antalet andraklassplatser(mellan 2 och 999)";
        int  numberOf2ndClassSeats = getInt(getNumberOf2ndClassSeats,
                Airplane.MIN_NUMBER_OF_SECOND_CLASS_SEATS, Airplane.MAX_NUMBER_OF_SECOND_CLASS_SEATS);
        return numberOf2ndClassSeats;
    }
        
    private int getInt(String mess, int min, int max) {
        boolean notAnInt = true;
        String input = "";
        int result = 0;
        while (notAnInt) {
//            System.out.println(mess);
            input = getString(mess, min, max);
            if (input.matches("\\d+")) {
                // Integer!!!
                result = Integer.parseInt(input);
                if (result <= max && result >= min) {
                    notAnInt = false;
                }
            }
        }
        return result;
    }

    public int changeAirplaneForFlight(Flight flight, List<Airplane> availableAirplanes) {
        
        String[] changeAirplaneAlternatives = new String[availableAirplanes.size() + 2];  // instruction and go back alternative -> 2
        changeAirplaneAlternatives[0]  = "Välj nr(EJ ID) på plan som skall användas";
        changeAirplaneAlternatives[1] = "0 Avbryt";
        int i = 2;
        for (Airplane airplane : availableAirplanes) {
            changeAirplaneAlternatives[i] = "Nr: " + (i-1) + "\t" + airplane.toString();
            i++;
        }
        int choice = showOptions(changeAirplaneAlternatives);
        return choice;
    }
}
