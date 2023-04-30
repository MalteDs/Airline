package model;

public class Plane {
    private String flightNumber;
    private String originAirport;
    private String destinationAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int availableSeats;
    private List<Passenger> passengerList;

    public Plane(String flightNumber, String originAirport, String destinationAirport, LocalDateTime departureTime, LocalDateTime arrivalTime, int availableSeats, List<Passenger> passengerList) {
        this.flightNumber = flightNumber;
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = availableSeats;
        this.passengerList = passengerList;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }
    public boolean addPassenger(Passenger passenger) {
        if (availableSeats > 0) {
            passengerList.add(passenger);
            availableSeats--;
            return true;
        }
        return false;
    }

    public List<Passenger> getPassengers() {
        return passengerList;
    }

    public void sortPassengers() {
        Collections.sort(passengerList);
    }

    public List<Passenger> getSortedPassengers() {
        List<Passenger> sortedPassengers = new ArrayList<>(passengerList);
        Collections.sort(sortedPassengers);
        return sortedPassengers;
    }

    public List<Passenger> getPriorityPassengers() {
        List<Passeger> priorityPassengers = new Arraylist();
        for (Passenger passenger : passengerList) {
            if (passenger.isPriorityPassenger()) {
                priorityPassengers.add(passenger);
            }
        }
    }

}

