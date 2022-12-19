package Homework4;

/**
 * Интерфейс реализующий пополнение или вычет материальных средств клиента
 */
public interface ChangeAccountStatus {
    public void increaseStatus(int number);
    public void decreaseStatus(int number);
}
