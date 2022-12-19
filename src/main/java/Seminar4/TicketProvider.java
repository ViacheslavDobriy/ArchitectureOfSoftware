package Seminar4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TicketProvider {

    private final Database database;
    private final PaymentProvider paymentProvider;

    public TicketProvider(Database database, PaymentProvider paymentProvider) {
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    public Collection<Ticket> searchTicket(int clientId, Date date){
        Collection<Ticket> tickets = new ArrayList<>();
        for(Ticket ticket: database.getTickets()){
            if(ticket.getCustomerId() == clientId && ticket.getDate().equals(date))
                ticket.setQrCode("QRCode");
                tickets.add(ticket);
        }
        return tickets;
    }

    public boolean buyTicket(int clientId, String cardNo){

        int orderId = database.createTicketOrder(clientId);
        double amount = database.getTicketAmount();
        paymentProvider.buy(orderId,cardNo,amount);
        return true;
    }

    public boolean checkTicket(String qrCode) {
        for(Ticket ticket: database.getTickets()) {
            if (ticket.getQrCode().equals(qrCode)) {
                ticket.setEnable(false);
                //TODO: обновить базу данных
                return true;
            }
        }
        return false;
    }
}
