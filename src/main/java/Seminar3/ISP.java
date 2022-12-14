package Seminar3;

public class ISP {
    public static void main(String[] args) {

    }

}

interface Animal{
    void run();
    void swim();
}

interface Flying{
    void fly();
}
class Cat implements Animal, Flying{
    @Override
    public void run() {
        System.out.println("Cat is running");
    }

    @Override
    public void swim() {
        System.out.println("Cat is swimmimg");
    }

    @Override
    public void fly() {

    }
}
class DuckV2 implements Animal{
    @Override
    public void run() {
        System.out.println("Duck is running");
    }

    @Override
    public void swim() {
        System.out.println("Duck is swimming");
    }

}
