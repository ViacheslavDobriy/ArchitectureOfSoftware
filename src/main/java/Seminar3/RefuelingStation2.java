package Seminar3;

public class RefuelingStation2 implements Refueling{
    @Override
    public void fuel(FuelType fuelType) {
        switch (fuelType) {
            case DIESEL -> System.out.println("Fuel diesel");
            case GASOLINE -> System.out.println("Fuel gasoline");
        }
    }
}
