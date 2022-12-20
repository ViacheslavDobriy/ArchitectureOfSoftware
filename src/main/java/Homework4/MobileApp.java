package Homework4;

import java.util.Scanner;

/**
 * Сущность 'Приложения транспортной системы города/страны'
 */
public class MobileApp {
    private PassengerAccount passengerAccount;

    public PassengerAccount registration(String login, String password){
        this.passengerAccount = new PassengerAccount(new Person("Slava", "Dobrov", 27));
        this.passengerAccount.setLogin(login);
        this.passengerAccount.setPassword(password);
        return passengerAccount;
    }

    public MobileApp() {
        Scanner iScanner = new Scanner(System.in);
        String login = iScanner.nextLine();
        String password = iScanner.nextLine();
        DatabaseOfPassengers.addAccount(registration(login,password));
    }

    public void buyTicket(Bank bank) {
        new PaymentProvider(bank, passengerAccount);
    }

    public PassengerAccount getPassengerAccount() {
        return passengerAccount;
    }
}
