package model;

public class Passenger implements Comparable<Passenger>{
    String name;
    int id;
    int age;
    String seatNumber;
    int miles;
    boolean isVip; //Podemos agregar varias clases en un enum
    boolean specialNeeds;
    int boardingOrder;
    Flight flight;

    public Passenger(String name, int id, int age, String seatNumber, int miles, boolean isVip, boolean specialNeeds, Flight flight){
        this.name = name;
        this.id = id;
        this.age = age;
        this.seatNumber = seatNumber;
        this.miles = miles;
        this.isVip = isVip;
        this.specialNeeds = specialNeeds;
        this.boardingOrder = 0;
        this.flight = flight;
    }



    public String getName() {
        return name;
    }

    public String getBoardingInformation(){
        return name+"                          "+boardingOrder+"                       "+seatNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public boolean isSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(boolean specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public int getBoardingOrder() {
        return boardingOrder;
    }

    public void setBoardingOrder(int boardingOrder) {
        this.boardingOrder = boardingOrder;
    }

    public int getRow(){
        return Integer.parseInt(String.valueOf(seatNumber.charAt(1)));
    }

    public char getColumn(){
        return seatNumber.charAt(0);
    }

    public int corridorProximity(){
        int corridor = flight.getColumnsSeat()/2;
        if(getColumn() == 'A'){
            return 3;
        }
        if(getColumn() == 'B'){
            return 2;
        }
        if(getColumn() == 'C'){
            return 1;
        }
        if(getColumn() == 'D'){
            return 0;
        }
        if(getColumn() == 'E'){
            return 0;
        }
        if(getColumn() == 'F'){
            return 1;
        }
        if(getColumn() == 'G'){
            return 2;
        }
        if(getColumn() == 'H'){
            return 3;
        }
        return 0;
    }

    @Override
    public String toString() {
        return " Passenger: \n" +
                " Name:'" + name + '\'' +
                ", Id: " + id +
                ", Age: " + age +
                ", Seat Number: " + seatNumber +
                ", Miles: " + miles +
                ", IsVip: " + isVip +
                ", Special Needs: " + specialNeeds +
                ".";
    }

    @Override
    public int compareTo(Passenger passenger){
        if(passenger!=null){
            if (getRow()!=passenger.getRow()){
                return Integer.compare(passenger.getRow(), getRow());
            } else if (corridorProximity()!=passenger.corridorProximity()){
                return Integer.compare(passenger.corridorProximity(), corridorProximity());
            } else{
                return Integer.compare(passenger.getBoardingOrder(), getBoardingOrder());
            }
        }
        return 0;
    }
}
