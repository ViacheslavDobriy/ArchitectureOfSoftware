package Homework4;

/**
 * Здесь main
 */
public class SimplyWorld {
    public static void main(String[] args) {
        Person person1 = new Person("Slava", "Dobrov", 27);
        Person person2 = new Person("Roma", "Obuhov", 17);
        CustomerOfBank customerOfBank1 = new CustomerOfBank(person1);
        CustomerOfBank customerOfBank2 = new CustomerOfBank(person2);
        System.out.println(customerOfBank1.toString());
        System.out.println(customerOfBank2.toString());
        customerOfBank1.getSalary(5000);
        System.out.println(customerOfBank1);
    }
}
