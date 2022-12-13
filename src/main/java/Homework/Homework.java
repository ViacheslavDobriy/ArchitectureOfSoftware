package Homework;

public class Homework {

    static Employee generateEmployee() {
        //TODO: Proceed
        Employee employee = new Worker("Slava", "Dobrov", 3000);
        return employee;
    }
    public static void main(String[] args) {
        Worker worker1 = new Worker("Anatoliy", "Shestakov", 7000);
        System.out.println(worker1);
        Freelancer worker2 = new Freelancer("Stas", "Dobrov", 3500);
        System.out.println(worker2);

        // TODO:
        // 1. Доработать метод generateEmployee(), вернуть сотрудника определенного типа
        // 2***. метод generateEmployee() должен быть без входных параметров,
        // тип сотрудника, фио и ставка генерируются автоматически

        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i] = generateEmployee());
        }
    }
}
