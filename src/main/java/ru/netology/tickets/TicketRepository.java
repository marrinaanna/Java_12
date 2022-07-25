package ru.netology.tickets;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public void addTicket(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }
    public void removeTicketById(int id) {
        if(findById(id)==null){
            throw new NotFoundException("There is no ticket with "+id+" id");
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int i = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[i] = ticket;
                i++;
            }
            tickets = tmp;
        }
    }
    public Ticket findByAirport(String from, String to) {
        for (Ticket ticket : tickets) {
            if ((ticket.getAirportNameFrom() == from) && (ticket.getAirportNameTo() == to)){
                return ticket;
            }
        }
        return null;
    }
    public Ticket[] getAll() {
        return tickets;
    }
}
