package Homework4;

import java.util.Collection;

/**
 * Сущность банк
 */
public class Bank {

    public void becomeCustomer(Person person) {
        CustomerOfBank customerOfBank = new CustomerOfBank(person);
        DatabaseOfCustomersOfBank.addCustomer(customerOfBank);
    }

    public Collection<CustomerOfBank> getAllCustomers() {
        return DatabaseOfCustomersOfBank.getAllCustomers();
    }

}
