package Seminar4;

import java.util.Date;

/**
 * Сущность билет
 */
public class Ticket {
    private int id;
    private int customerId;
    private Date date;
    private String qrCode;
    private boolean enable = true;

    public int getId() {
        return id;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
