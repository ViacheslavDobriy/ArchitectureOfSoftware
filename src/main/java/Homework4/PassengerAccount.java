package Homework4;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Аккаунт пассажира, зарегистрированного в приложении/веб-сайте транспортной системы города/страны
 */
public class PassengerAccount {
    private Person person;
    private int passID;
    private static int counterId;

    private String login;
    private String password;
    private Collection<Ticket> tickets = new ArrayList<>();

    {
        passID = ++counterId;
    }

    public PassengerAccount(Person person) {
        this.person = person;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "PassengerAccount{" +
                "passID=" + passID +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
