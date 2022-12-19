package Seminar4;

import java.util.Collection;

/**
 * Сущность клиент
 */
public class Customer {

    private final int id;
    private static int counter;
    private Collection<Ticket> tickets;

    {
        id = ++counter;
    }

    public int getId() {
        return id;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }
}
