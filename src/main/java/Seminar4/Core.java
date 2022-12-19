package Seminar4;

public class Core {
    private final CustomerProvider customerProvider;
    private final TicketProvider ticketProvider;
    private final PaymentProvider paymentProvider;
    private final Database database;

    public Core() {
        this.database = new Database();
        this.paymentProvider = new PaymentProvider();
        this.ticketProvider = new TicketProvider(database, paymentProvider);
        this.customerProvider = new CustomerProvider(database);
    }

    public CustomerProvider getCustomerProvider() {
        return customerProvider;
    }

    public TicketProvider getTicketProvider() {
        return ticketProvider;
    }
}
