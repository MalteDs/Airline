package ui;
import model.*;

import java.io.IOException;

public class Main {
    public static Airline airline = new Airline();
    public static void main(String[] args) throws IOException {
        airline.loadPassengerData();
        System.out.println(airline.getPassengers());
        System.out.println(airline.registerBoarding(123456));
        System.out.println(airline.registerBoarding(1004132));
        System.out.println(airline.registerBoarding(101325));
        System.out.println(airline.printBoardingOrder());
        System.out.println(airline.exitOrder());

    }
}
