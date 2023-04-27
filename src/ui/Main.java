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
                    "2. Register boarding\n" +
                    "3. Print boarding order\n" +
                    "4. Print exit order\n" +
                    "5. Exit\n");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    airline.loadPassengerData();
                    break;
                case 2:
                    System.out.println("Enter passenger id: ");
                    airline.simulateArrive();
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
