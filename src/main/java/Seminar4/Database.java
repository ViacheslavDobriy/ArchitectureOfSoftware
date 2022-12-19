package Seminar4;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Сущность сервер
 * Здесь хранятся данные о всех существующих билетах и клиентах.
 */
public class Database {

    private static Collection<Ticket> tickets = new ArrayList<>();
    private static Collection<Customer> customers = new ArrayList<>();

    private static int count;

    /**
     * Получить актуальную стоимость билета.
     * @return
     */
    public double getTicketAmount() {
        return 45;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     * @return
     */
    public int createTicketOrder(){
        return ++count;
    }
}
