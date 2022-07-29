package ru.netology.tickets;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket[] findAll(String from, String to) {
        if (repo.findByAirport(from, to) == null) {
            throw new NotFoundException("There is no flight tickets from " + from + " to " + to);
        }
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getAll()) {
            if ((ticket.getAirportNameFrom().equals(from)) && (ticket.getAirportNameTo().equals(to))) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;

    }
}

