package Seminar3;

public class SuperCar extends Car implements Wiping{
    @Override
    public void wipMirrors() {

    }

    @Override
    public void wipWindShield() {

    }

    @Override
    public void wipHeadLights() {

    }

    public SuperCar() {
        wheelCount = 3;
        this.fuelType = FuelType.GASOLINE;
    }

    public void fly() {
        System.out.println("Car is flying");
    }
    @Override
    public void movement() {
        fly();
    }

    @Override
    public void maintenance() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadLights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }
}
