package com.driver;

public class Boat implements WaterVehicle
{
    private String name;
    private int capcity;
    public Boat(String name,int capcity)
    {
        this.name=name;
        this.capcity=capcity;
    }
    public String getVehicleName(){
        return this.name;
    }

    public int getVehicleCapacity()
    {
        return this.capcity;
    }
}
