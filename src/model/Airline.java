package model;

import structures.*;

import java.io.*;

public class Airline {
    private HashTable<Integer, Passenger> passengers;
    Queue<Integer> boardingQueue = new Queue<>();
    Queue<Integer> vipBoardingQueue = new Queue<>();
    Queue<Integer> specialBoardingQueue = new Queue<>();
    Flight flight;
    private int[] ids;
    final static String path = "src/data/passengers.txt";
    final static String planePath = "src/data/flight.txt";
    int boardingOrder = 0;
    public Airline() {
    }

    public HashTable<Integer, Passenger> loadPassengerData() throws IOException {
        File file = new File(path);
        int i = 0;
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                ids[i] = Integer.parseInt(data[1]);
                int age = Integer.parseInt(data[2]);
                String seatNumber = data[3];
                int miles = Integer.parseInt(data[4]);
                boolean isVip;

                if(Integer.parseInt(String.valueOf(data[3].charAt(1)))<=4){
                    isVip = true;
                }else isVip = false;
                boolean specialNeeds = Boolean.valueOf(data[5]);
                Passenger passenger = new Passenger(name, ids[i], age, seatNumber, miles, isVip, specialNeeds, flight);
                passengers.put(ids[i], passenger);
                i++;
            }
        }
        return passengers;
    }

    public void loadPlaneData() throws IOException {
        File file = new File(planePath);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String flightNumber = data[0];
                String originAirport = data[1];
                String destinationAirport = data[2];
                int rows = Integer.parseInt(data[3]);
                int column = Integer.parseInt(data[4]);
                flight = new Flight(flightNumber, originAirport, destinationAirport, rows, column);
                ids = new int[rows*column*2];
                passengers = new HashTable<>(rows*column*2);
            }
        }
    }

    public Passenger searchPassenger(int id) {
        return passengers.get(id);
    }

    public String getPassengers() {
        return passengers.toString();
    }

    public void registerBoarding(int id) {
        Passenger passenger = searchPassenger(id);
        if (passenger != null && !isBoarded(passenger)) {

            if (passenger.isVip()) {
                passenger.setBoardingOrder(boardingOrder);
                vipBoardingQueue.enqueue(passenger.getId());
                boardingOrder++;
            } else if (passenger.getAge() > 65 || passenger.isSpecialNeeds() || passenger.getMiles() > 3000){
                passenger.setBoardingOrder(boardingOrder);
                specialBoardingQueue.enqueue(passenger.getId());
                boardingOrder++;
            } else {
                passenger.setBoardingOrder(boardingOrder);
                boardingQueue.enqueue(passenger.getId());
                boardingOrder++;
            }
        }
    }

    private boolean isBoarded(Passenger passenger) {
        if(vipBoardingQueue.contains(passenger.getId()) || specialBoardingQueue.contains(passenger.getId()) || boardingQueue.contains(passenger.getId())){
            return true;
        }
        return false;
    }

    public void simulateArrive(){
        for(int i = 0; i <=  ids.length-1; i++){
            registerBoarding(ids[i]);
        }
    }

    public String printBoardingOrder(){
        int order = 1;
        Passenger passenger;
        String messageBoardingOrder = "-----------------------------\n"+
                                    "Boarding order: \n"+
                                    "------------------------------\n";
        while (!vipBoardingQueue.isEmpty()){
            passenger = passengers.get(vipBoardingQueue.dequeue());
            messageBoardingOrder += order+". "+ passenger.getName() + "\n";
            order++;
        }
        while (!specialBoardingQueue.isEmpty()){
            passenger = passengers.get(specialBoardingQueue.dequeue());
            messageBoardingOrder += order+". "+passenger.getName() + "\n";
            order++;
        }
        while (!boardingQueue.isEmpty()){
            passenger = passengers.get(boardingQueue.dequeue());
            messageBoardingOrder += order+". "+passenger.getName() + "\n";
            order++;
        }
        return messageBoardingOrder;
    }
    public int corridor(){
        return flight.getRowsSeat()/2;
    }

    public String exitOrder(){
        int order = 1;
        String message ="-----------------------\n"+
                        "Exit order: \n"+
                        "-----------------------\n"+
                        "Name                              ||    Boarding Order   ||    Seat   \n"+
                        "----------------------------------------------------------------------\n";
        PriorityQueue<Passenger> exitOrder = new PriorityQueue<>();
        exitOrder = exitOrder(exitOrder);
        while(!exitOrder.isEmpty()){
            message += order + ". "+ exitOrder.dequeue().getBoardingInformation()+"\n";
            order++;
        }
        return message;
    }
    private PriorityQueue exitOrder(PriorityQueue<Passenger> exitOrder){
        for(int i = 1; i < ids.length; i++){
            if(passengers.get(ids[i-1])!=null && ids[i] != 0){
                exitOrder.enqueue(passengers.get(ids[i]), passengers.get(ids[i]).compareTo(passengers.get(ids[i-1])));
            }
        }
        return exitOrder;
    }
}