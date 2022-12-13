package Homework;

public class Worker extends Employee{
    @Override
    public double calculateSalary() {
        return salary*30;
    }

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

    @Override
    public String toString() {
        return String.format("%s %s; Worker; Summary salary: %.2f", name,surname,calculateSalary());
    }

    public Worker(String name, String surname, double salary) {
        super(name, surname, salary);
    }
}
