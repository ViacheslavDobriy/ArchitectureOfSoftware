package Homework;

import java.util.Random;

public class Homework {

    static Employee generateEmployee() {

        Random random = new Random();
        int randInt = random.nextInt(0,2); // рандомайзер для типа рабочего
        int randName = random.nextInt(0,PopularNames.values().length); // рандомайзер для имени -> enum PopularNames
        int randSurname = random.nextInt(0,PopularSurnames.values().length); // рандомайзер для фамилии -> enum PopularSurnames
        if(randInt == 0) {
            return new Worker(PopularNames.values()[randName].getName(), PopularSurnames.values()[randSurname].getSurname(), 3000);
        }
        return new Freelancer(PopularNames.values()[randName].getName(), PopularSurnames.values()[randSurname].getSurname(), 3000);
    }
    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i] = generateEmployee());
        }
    }
}
