package Model;

public class Profit {

    double profitConst = 0.20;

    //TODO seatMoney and mealMoney might be calculated in the same
    //TODO for loop if that makes anyone happier :-)

    public int profitCalc(Flight flight){ 
        int seatMoney =
        flight.getNoOf1stClassSeatsBooked() * flight.getFirstClassPrice() +
        flight.getNoOf2ndClassSeatsBooked() * flight.getSecondClassPrice();

        int mealMoney = 0;
        for (Seat seat : flight.getSeats()) {            
            int thisMeal = seat.getFood().getPrice();
            mealMoney =+ thisMeal;
        }
        int flightProfit = (int)(profitConst * seatMoney + profitConst * mealMoney);
        return flightProfit;
    }
}
