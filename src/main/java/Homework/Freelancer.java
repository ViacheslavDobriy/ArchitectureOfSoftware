package Homework;

public class Freelancer extends Employee{
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public void setSalary(double salary) {
        super.setSalary(salary);
    }

    public Freelancer(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    public double calculateSalary() {
        return 15 * salary;

    }

    @Override
    public String toString() {
        return String.format("%s %s; Freelancer; Average salary: %.2f (roubles);", name,surname,calculateSalary());
    }
}
