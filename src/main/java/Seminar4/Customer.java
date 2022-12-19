package Seminar4;

import java.util.Collection;

/**
 * Сущность клиент
 */
public class Customer {

    private final int id;
    private final int cardNo;
    private static int counterId;
    private static int counterCardNo = 1000000;
    private Collection<Ticket> tickets;

    {
        id = ++counterId;
        cardNo = ++counterCardNo;
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
