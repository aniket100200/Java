package com.driver;

public class Car extends Vehicle {
    private int wheels;
    private String type;
    private int doors;
    private int gears;
    private boolean isManual;
    private int currentGear;
    private int seats;

    public Car(String name, int wheels, int doors, int gears, boolean isManual, String type, int seats)
    {
        super(name);
        //Hint: Car extends Vehicle
        this.wheels=wheels;
        this.gears=gears;
        this.doors=doors;
        this.isManual=isManual;
        this.type=type;
        this.seats=seats;

    }
    public Car(String name,boolean isManual)
    {
        super(name);
        this.isManual=isManual;
    }

    public void changeGear(int newGear){
        this.currentGear=newGear;
        System.out.println("changeGear method called - The gear is changed to: " + currentGear);
    }

    public void changeSpeed(int newSpeed, int newDirection)
    {
        super.move(newSpeed,newDirection);
        System.out.println("changeSpeed method called - The speed is changed to: " + newSpeed + ", and the direction is changed to: " + newDirection + " degrees");
    }

}
