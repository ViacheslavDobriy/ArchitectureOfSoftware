package Seminar3;

import java.awt.*;

public abstract class Car {

    //region Private Fields

    private String make;
    private String model;
    private Color color;
    protected CarType type;
    protected int wheelCount;
    protected FuelType fuelType;
    private GearBox gearboxType;
    private double engineCapacity;
    private Refueling refuelingStation;
    //endregion

    //region Public Methods

    public void setRefuelingStation(Refueling refuelingStation){
        this.refuelingStation = refuelingStation;
        fuel();
    }

    public void fuel(){
        refuelingStation.fuel(fuelType);
    }
    public abstract void movement();
    public abstract void maintenance();
    public abstract boolean gearShifting();
    public abstract boolean switchHeadLights();
    public abstract boolean switchWipers();

    public void shipping() {
        System.out.println("Transfer cargo");
    }

    public int getWheelCount() {
        return wheelCount;
    }


    //endregion

}
