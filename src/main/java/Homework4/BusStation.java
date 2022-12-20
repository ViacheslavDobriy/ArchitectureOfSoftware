package Homework4;

/**
 * Сущность автобусная остановка
 */
public class BusStation {
    private MobileApp mobileApp;

    public boolean takeBus(String showedQrCode){
        for(Ticket ticket: mobileApp.getPassengerAccount().getTickets()) {
            if(ticket.getQrCode().equals(showedQrCode)){
                if(ticket.isVerified()) {
                    ticket.usingTicket();
                    System.out.println("Take your seat");
                    return true;
                }
            }
        }
        System.out.println("Ticket is expired");
        return false;
    }

    public void userComeToBusStop(MobileApp mobileApp) {
        this.mobileApp = mobileApp;
    }

}
