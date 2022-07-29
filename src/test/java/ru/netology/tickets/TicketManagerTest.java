package ru.netology.tickets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    Ticket ticket1 = new Ticket(1, 12_000, "SRM", "CDG");
    Ticket ticket2 = new Ticket(2, 25_000, "VKO", "JFK");
    Ticket ticket3 = new Ticket(3, 5_500, "SVO", "DEL");
    Ticket ticket4 = new Ticket(4, 100_000, "UUS", "ZIA");
    Ticket ticket5 = new Ticket(5, 38_000, "CGH", "AAQ");
    Ticket ticket6 = new Ticket(6, 15_000, "VKO", "JFK");
    Ticket ticket7 = new Ticket(7, 80_000, "VKO", "JFK");
    Ticket ticket8 = new Ticket(8, 25_000, "VKO", "JFK");

    @Test
    public void managerShouldFindSomeTicketsAndSort() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.addTicket(ticket6);
        repo.addTicket(ticket7);
        repo.addTicket(ticket8);
        Ticket[] actual = manager.findAll("VKO", "JFK");
        Ticket[] expected = {ticket6, ticket2, ticket8, ticket7};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void managerShouldFindOnlyOneTicket() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.addTicket(ticket6);
        repo.addTicket(ticket7);
        repo.addTicket(ticket8);
        Ticket[] actual = manager.findAll("CGH", "AAQ");
        Ticket[] expected = {ticket5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void managerShouldNotFindTicketsAndSort() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.addTicket(ticket6);
        repo.addTicket(ticket7);
        assertThrows(NotFoundException.class, () -> {
            manager.findAll("KLM", "TRF");
        });
    }
}
