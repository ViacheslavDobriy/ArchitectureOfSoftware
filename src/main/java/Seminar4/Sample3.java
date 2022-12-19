package Seminar4;

import java.util.Date;

public class Sample3 {
    /**
     * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик".
     *
     * 5,6,7,8 - необязательные, опциональные задания
     *
     * 1. Предусловия
     * 2. Постусловия
     * 3. Инвариант
     * 4. Определить абстрактные и конкретные классы
     * 5. Определить интерфейсы
     * 6. Реализовать наследование
     * 7. Выявить компоненты
     * 8. Разработать Диаграмму компонент используя нотацию UML 2.0. Общая без деталей
     */
    public static void main(String[] args) {
        Core core = new Core();

        MobileApp mobileApp = new MobileApp(core.getCustomerProvider(),core.getTicketProvider());

        mobileApp.searchTicket(new Date());
        mobileApp.buyTicket("1001010101000");

        BusStation busStation = new BusStation();
//        busStation.useTicket(core.getCustomerProvider().getCustomer("ewf", "cac").getTickets().stream().);
    }
}
