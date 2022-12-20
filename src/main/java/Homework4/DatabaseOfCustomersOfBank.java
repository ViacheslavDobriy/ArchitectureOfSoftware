package Homework4;

import java.util.ArrayList;
import java.util.Collection;

/**
 * База данных клиентов банка
 */
public class DatabaseOfCustomersOfBank {
    private static final Collection<CustomerOfBank> allCustomers = new ArrayList<>();

    public static Collection<CustomerOfBank> getAllCustomers(){
        return allCustomers;
    }

    public static void addCustomer(CustomerOfBank customerOfBank){
        allCustomers.add(customerOfBank);
    }
}
