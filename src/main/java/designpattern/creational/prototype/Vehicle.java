package designpattern.creational.prototype;

public abstract class Vehicle {
    private final String brand;
    private final String model;
    private final String color;

    protected Vehicle(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    // Copy constructor
    protected Vehicle(Vehicle vehicle) {
        this.brand = vehicle.brand;
        this.model = vehicle.model;
        this.color = vehicle.color;
    }

    public abstract Vehicle clone();
}
