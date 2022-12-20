package Homework4;

import java.util.ArrayList;
import java.util.Collection;

/**
 * База данных пользователей приложения
 */
public class DatabaseOfPassengers {
    private static final Collection<PassengerAccount> allPassengers = new ArrayList<>();

    public static Collection<PassengerAccount> getAllPassengers() {
        return allPassengers;
    }

    public static void addAccount(PassengerAccount passengerAccount) {
        allPassengers.add(passengerAccount);
    }
}
