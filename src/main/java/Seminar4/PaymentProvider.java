package Seminar4;

/**
 * Шлюз оплаты билетов
 * Принимает платежи
 */
public class PaymentProvider {
    // TODO: осуществить оплату
    public boolean buy(int orderId, String cardNo, double amount) {
        //ПРЕДУСЛОВИЕ
        return orderId > 0;
    }
}
