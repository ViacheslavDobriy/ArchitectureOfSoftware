package Homework4;

import java.util.Date;

/**
 * Сущность билет
 */
public class Ticket {
    private int id;
    private static int counterId;
    private int amount;
    private String qrCode;
    private Date date;
    private boolean isVerified = true;

    {
        id = ++counterId;
    }

    public Ticket(Date date) {
        this.date = date;
        setAmount();
        setQrCode();
    }

    private void setAmount(){
        this.amount = 40;
    }

    public int getAmount() {
        return amount;
    }

    private void setQrCode() {
        this.qrCode = "qrCode" + id;
    }

    public String getQrCode() {
        return qrCode;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void usingTicket(){
        this.isVerified = false;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", amount=" + amount +
                ", qrCode='" + qrCode + '\'' +
                ", date=" + date +
                ", isVerified=" + isVerified +
                '}';
    }
}

