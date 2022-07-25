package ru.netology.tickets;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int cost;
    private String airportNameFrom;
    private String airportNameTo;
    private int time;

    public Ticket(int id, int cost, String airportNameFrom, String airportNameTo) {
        this.id = id;
        this.cost = cost;
        this.airportNameFrom = airportNameFrom;
        this.airportNameTo = airportNameTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getAirportNameFrom() {
        return airportNameFrom;
    }

    public void setAirportNameFrom(String airportNameFrom) {
        this.airportNameFrom = airportNameFrom;
    }

    public String getAirportNameTo() {
        return airportNameTo;
    }

    public void setAirportNameTo(String airportNameTo) {
        this.airportNameTo = airportNameTo;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(Ticket otherTicketCost) {
        if (cost > otherTicketCost.getCost()) {
            return 1;
        }
        if (cost < otherTicketCost.getCost()) {
            return -1;
        }
        return 0;
    }

}
