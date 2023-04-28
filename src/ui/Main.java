package ui;
import model.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Airline airline = new Airline();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean exit = false;

        while (!exit) {
            System.out.println("------------------------------------\n " +
                    "--------------AIRLINE--------------\n" +
                    "------------------------------------" +
                    "\n"+
                    "1. Load passengers data\n" +
                    "2. Register arrival at the boarding lounge\n" +
                    "3. Start passenger entry\n" +
                    "4. Print exit order\n" +
                    "5. Exit\n");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Entering passengers data... ");
                    airline.loadPassengerData();
                    airline.loadPlaneData();
                    System.out.println("Passengers data entered successfully!");
                    break;
                case 2:
                    System.out.println("Boarding passengers...");
                    airline.simulateArrive();
                    System.out.println("Passengers boarded successfully!");
                    break;
                case 3:
                    System.out.println(airline.printBoardingOrder());
                    break;
                case 4:
                    System.out.println(airline.exitOrder());
                    break;
                case 5:
                    System.out.println("Bye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
