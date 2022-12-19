package Homework4;

/**
 * Сущность клиент банка
 */
public class CustomerOfBank implements GettingSalary{
    private Person person;

    @Override
    public void getSalary(int salary) {
        debitCard.increaseStatus(salary);
    }

    private static int counter;
    private DebitCard debitCard;
    private int id;
    {
        this.id = ++this.counter;
    }

    public CustomerOfBank(Person person) {
        this.person = person;
        this.debitCard = new DebitCard();
    }

    @Override
    public String toString() {
        return "CustomerOfBank{" +
                "debitCard=" + debitCard.getCardNo() + " " + debitCard.getAccountStatus() +
                ", id=" + id +
                '}';
    }
}
