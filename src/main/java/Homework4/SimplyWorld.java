package Homework4;

/**
 * Здесь main
 */
public class SimplyWorld {
    public static void main(String[] args) {
        Bank bank = new Bank();                                                                               // стоит банк
        Person person1 = new Person("Slava", "Dobrov", 27);                                 // стоит человек
        bank.becomeCustomer(person1);                                                                         // person1 захотел оформить карточку и стать клиентом банка bank
        DatabaseOfCustomersOfBank.getAllCustomers().stream().findFirst().get().getSalary(3000);               // клиент банка получил зп
        System.out.println(DatabaseOfCustomersOfBank.getAllCustomers());                                      // в консоли все клиенты банка (по умолчанию 1)
        MobileApp mobileApp = new MobileApp();                                                                // Первый вход в приложение, для онлайн покупки билетов - введите логин и пароль
        System.out.println(DatabaseOfPassengers.getAllPassengers());                                          // в консоли все пользователи приложения (по умолчанию 1)
        mobileApp.buyTicket(bank);                                                                            // пользователь приложения покупает билет
        System.out.println(DatabaseOfCustomersOfBank.getAllCustomers());                                      // в консоли изменение состояния счета
        System.out.println(DatabaseOfPassengers.getAllPassengers().stream().findFirst().get().getTickets());  // в консоли все билеты пользователя
        BusStation busStation = new BusStation();                                                             // стоит остановка
        busStation.userComeToBusStop(mobileApp);                                                              // пользователь подошел к остановке и открыл приложение
        busStation.takeBus("qrCode1");                                                            // пользователь пытается сесть в автобус (правильный qrCode: qrCode1)
        System.out.println(DatabaseOfPassengers.getAllPassengers().stream().findFirst().get().getTickets());  // в консоли наблюдаем изменение состояния билета
    }
}
