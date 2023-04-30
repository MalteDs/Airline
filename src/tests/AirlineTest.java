package tests;
import junit.framework.TestCase;
import model.*;
import structures.*;


public class AirlineTest extends TestCase {
    Airline airline;
    HashTable<Integer, Passenger> passengers;
    Queue<Passenger> queue;
    PriorityQueue<Passenger> priorityQueue;

    int[]ids;

    final static int CAPACITY = 10;

    public void setUpScenario1(){
        airline = new Airline();
        passengers = new HashTable<>(CAPACITY);
    }

    public void setUpScenario2(){
        setUpScenario1();
        passengers.put(1, new Passenger("Juan", 1, 30, "1A", 0, false, false, null));
    }

    public void setUpScenario3(){
        setUpScenario2();
        passengers.put(2, new Passenger("Andres", 2, 20, "2A", 0, false, false, null));
        passengers.put(3, new Passenger("Daniel", 3, 22, "3A", 0, false, true, null));
        passengers.put(4, new Passenger("Camilo", 4, 25, "4D", 0, false, false, null));
    }

    public void testLoadPassengerData(){
        setUpScenario1();
        try{
            airline.loadPlaneData();
            airline.loadPassengerData();
        } catch (Exception e){
            fail();
        }
    }

    public void testLoadPlaneData(){
        setUpScenario1();
        try{
            airline.loadPlaneData();
        } catch (Exception e){
            fail();
        }
    }

    public void testRegisterBoarding() {
        setUpScenario3();
        testLoadPassengerData();
        try {
            airline.registerBoarding(7092856);
        } catch (Exception e) {
            fail();
        }
    }
}
