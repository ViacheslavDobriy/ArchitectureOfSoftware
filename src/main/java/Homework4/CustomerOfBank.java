package Homework4;

/**
 * Сущность клиент банка
 */
public class CustomerOfBank implements GettingSalary, Purchasing{
    private Person person;
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
    public void buyTicket(int price) {
        debitCard.decreaseStatus(price);
    }

    @Override
    public void getSalary(int salary) {
        debitCard.increaseStatus(salary);
    }

    @Override
    public String toString() {
        return "CustomerOfBank{" +
                "debitCard=" + debitCard.getCardNo() + " " + debitCard.getAccountStatus() +
                ", id=" + id +
                '}';
    }

    public Person getPerson() {
        return person;
    }

    public DebitCard getDebitCard() {
        return debitCard;
    }
}
