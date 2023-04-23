package model;

import structures.*;

import java.io.*;

public class Airline {

    private final HashTable<Integer, Passenger> passengers;
    Queue<Passenger> boardingQueue = new Queue<>();
    Queue<Passenger> vipBoardingQueue = new Queue<>();
    Queue<Passenger> specialBoardingQueue = new Queue<>();
    private final int[] ids = new int[150];
    final static String folder = "data";
    final static String path = "src/data/passengers.txt";
    int boardingOrder = 0;

    public Airline() {
        passengers = new HashTable<>(150);
    }

    public void loadPassengerData() throws IOException {
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
                boolean isVip = Boolean.valueOf(data[5]);
                boolean specialNeeds = Boolean.valueOf(data[6]);
                Passenger passenger = new Passenger(name, ids[i], age, seatNumber, miles, isVip, specialNeeds);
                passengers.put(ids[i], passenger);
                i++;
            }
        }
    }

    public Passenger searchPassenger(int id) {
        return passengers.get(id);
    }

    public String getPassengers() {
        return passengers.toString();
    }

    public String registerBoarding(int id) {
        Passenger passenger = searchPassenger(id);
        if (passenger != null) {
            if (passenger.isVip()) {
                vipBoardingQueue.enqueue(passenger);
                boardingOrder++;
                passenger.setBoardingOrder(boardingOrder);
                return "The passenger " + passenger.getId() + " is registered in the vip boarding queue";
            } else if (passenger.getAge() > 65 || passenger.isSpecialNeeds() || passenger.getMiles() > 1000){
                specialBoardingQueue.enqueue(passenger);
                boardingOrder++;
                passenger.setBoardingOrder(boardingOrder);
                return "The passenger " + passenger.getId() + " is registered in the special boarding queue";
            } else {
                boardingQueue.enqueue(passenger);
                boardingOrder++;
                passenger.setBoardingOrder(boardingOrder);
                return "The passenger " + passenger.getId() + " is registered in the boarding queue";
            }
        } else return "The passenger " + id + " is not registered";
    }

    public String printBoardingOrder(){
        int order = 1;
        String messageBoardingOrder = "Boarding order: \n";
        while (!vipBoardingQueue.isEmpty()){
            messageBoardingOrder += order+". "+vipBoardingQueue.dequeue().getName() + "\n";
            order++;
        }
        while (!specialBoardingQueue.isEmpty()){
            messageBoardingOrder += order+". "+specialBoardingQueue.dequeue().getName() + "\n";
            order++;
        }
        while (!boardingQueue.isEmpty()){
            messageBoardingOrder += order+". "+boardingQueue.dequeue().getName() + "\n";
            order++;
        }
        return messageBoardingOrder;
    }


    //Cambiar a collections.sort
    //o buscar la comparacion con las kesy en lugar de con i
    //debo validar si boardingOrder != 0;
    public String exitOrder(){
        String message = "Exit order: \n";
        for(int i = 0; i < passengers.getSize(); i++){
            if(passengers.get(ids[i])!=null){
                if(passengers.get(ids[i]).compareTo(passengers.get(ids[i+1]))>0){
                    System.out.println("Entra 2: "+passengers.get(ids[i]).getName());
                    message += (i+1)+". "+passengers.get(ids[i]).getName()+"\n";
                }
            }
        }
        return message;
    }
}