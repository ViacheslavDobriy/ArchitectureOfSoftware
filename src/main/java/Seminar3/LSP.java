package Seminar3;

public class LSP {

    public static void main(String[] args) {

        Bird bird1 = new Bird();
        Bird bird2 = new Bird();
        Bird bird3 = new Bird();

        Duck duck1 = new Duck();
        Duck duck2 = new Duck();
        Duck duck3 = new Duck();

//        Bird bird = new Bird();
//        bird.fly();

        fly(bird1);
        fly(bird2);
        fly(bird3);

        fly(duck1);
        fly(duck2);
        fly(duck3);

        Penguin penguin1 = new Penguin();

        fly(penguin1);
    }

    public static void fly(Bird bird) {
        if (!(bird instanceof Penguin)) bird.fly();
    }
}

class Bird{
    private int flySpeed = 10;

    public void fly() {
        System.out.printf("Bird fly with speed = %d\n", flySpeed);
    }
}

class Duck extends Bird{
    @Override
    public void fly() {
        System.out.printf("Bird fly with speed = %d\n", 8);
    }
}

class Penguin extends Bird{
    @Override
    public void fly() {
        throw new RuntimeException("Penguin can not fly");
    }
}