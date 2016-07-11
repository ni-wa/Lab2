package view;


import Model.Seat;
import Model.Flight;
import Model.Customer;
import Model.Menu;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class View {
    
    String[] startScreenText = {
        "Vad vill du göra", 
        "0 Avsluta",
        "1 Profit", 
        "2 Boka resa"};
    
    String[] availableSeatsText= {
        "Vad vill du göra",
        "0 Avsluta",
        "1 Boka förstaklassbiljett",
        "2 Boka andraklassbiljett"
    };
    
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
     int readIntInput(){
        System.out.print("Enter String");
        String s = br.readLine();
        System.out.print("Enter Integer:");
        try{
            int i = Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
     }

    public int ShowStartScreen() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int showAvailableSeats(int noFo1stClassSeatsAvail, int price1stClass, int noOf2ndClassAvailable, int price2ndClass) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Menu showFood(Menu menu) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Customer showGetCustomerData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Seat showBookingData(Flight flight, Seat seat) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
