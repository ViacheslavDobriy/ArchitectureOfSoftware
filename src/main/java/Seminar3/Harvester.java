package Seminar3;

public class Harvester extends Car {

    public Harvester() {
        wheelCount = 5;
        this.fuelType = FuelType.DIESEL;
    }
    public void sweeping(){
        System.out.println("Car is sweeping the road");
    }
    @Override
    public void movement() {
        System.out.println("move");
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
