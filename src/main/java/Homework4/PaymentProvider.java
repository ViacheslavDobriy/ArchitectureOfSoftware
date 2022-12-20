package Homework4;

import java.util.Date;
import java.util.Objects;

/**
 * Шлюз для покупки билета
 */
public class PaymentProvider {
    private Bank bank;
    private Ticket ticket;
    private PassengerAccount passengerAccount;
    private CustomerOfBank customerOfBank;

    public PaymentProvider(Bank bank, PassengerAccount passengerAccount) {
        this.bank = bank;
        this.passengerAccount = passengerAccount;
        this.ticket = new Ticket(new Date());
        if (isCustomer()) {
            buyTicket();
        } else {
            throw new RuntimeException("He doesn't have a debit card");
        }
    }

    public boolean isCustomer() {
        for(CustomerOfBank customer: bank.getAllCustomers()) {
            if(Objects.equals(customer.getPerson().getName(), this.passengerAccount.getPerson().getName())) {
                this.customerOfBank = customer;
                return true;
            }
        }
        return false;
    }

    public void buyTicket() {
        customerOfBank.buyTicket(ticket.getAmount());
        this.passengerAccount.addTicket(this.ticket);
    }
}
