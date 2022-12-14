package Seminar3;

/**
 * Заправочная станция - Объект
 */
public class RefuelingStation1 implements Refueling{
    @Override
    public void fuel(FuelType fuelType) {
        switch (fuelType) {
            case DIESEL -> throw new RuntimeException("There is no diesel");
            case GASOLINE -> System.out.println("Fuel gasoline");
        }
    }
}
