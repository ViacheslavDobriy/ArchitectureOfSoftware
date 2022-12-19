package Homework4;

/**
 * Сущность карточка - упрощенная
 * Есть номер карты, состояние счета (сумма денег на счету - не может быть отрицательной)
 * И в нашем мире существует только один банк, который может выдавать карточки
 */
public class DebitCard implements ChangeAccountStatus {
    private String cardNo;
    private static int counterCardNo;
    private int accountStatus;

    {
        cardNo = Integer.toString(++counterCardNo);
        accountStatus = 0;
    }

    public String getCardNo() {
        return cardNo;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    @Override
    public void increaseStatus(int number) {
        this.accountStatus = accountStatus + number;
    }

    @Override
    public void decreaseStatus(int number) {
        if(this.accountStatus >= number) {
            this.accountStatus = accountStatus - number;
        } else throw new RuntimeException("Low money");
    }
}
