package designpattern.creational.builder;

public class Car {
    int id;
    String brand;
    String model;
    String color;
    int nbrDoors;
    String screenType;
    double weight;
    double height;

    // constructor may not be public
    // if the builder is not an inner builder
    Car(int id, String brand, String model, String color, int nbrDoors, String screenType, double weight, double height) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.nbrDoors = nbrDoors;
        this.screenType = screenType;
        this.weight = weight;
        this.height = height;
    }
}
