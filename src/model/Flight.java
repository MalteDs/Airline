package model;

public class Flight {
    private String flightNumber;
    private String originAirport;
    private String destinationAirport;
    private int rowsSeat;
    private int columnsSeat;

    public Flight(String flightNumber, String originAirport, String destinationAirport, int rowsSeat, int columnsSeat) {
        this.flightNumber = flightNumber;
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.rowsSeat = rowsSeat;
        this.columnsSeat = columnsSeat;
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

    public int getRowsSeat() {
        return rowsSeat;
    }

    public void setRowsSeat(int rowsSeat) {
        this.rowsSeat = rowsSeat;
    }

    public int getColumnsSeat() {
        return columnsSeat;
    }

    public void setColumnsSeat(int columnsSeat) {
        this.columnsSeat = columnsSeat;
    }
}
