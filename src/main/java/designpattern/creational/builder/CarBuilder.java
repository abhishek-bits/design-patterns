package designpattern.creational.builder;

// builder will have same properties
// as that of the Car object
public class CarBuilder {
    int id;
    String brand;
    String model;
    String color;
    int nbrDoors;
    String screenType;
    double weight;
    double height;

    public CarBuilder id(int id) {
        this.id = id;
        return this;
    }

    public CarBuilder brand(String brand)  {
        this.brand = brand;
        return this;
    }

    public CarBuilder model(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder color(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder nbrDoors(int nbrDoors) {
        this.nbrDoors = nbrDoors;
        return this;
    }

    public CarBuilder screenType(String screenType) {
        this.screenType = screenType;
        return this;
    }

    public CarBuilder weight(int weight) {
        this.weight =  weight;
        return this;
    }

    public CarBuilder height(int height) {
        this.height = height;
        return this;
    }

    public Car build() {
        return new Car(id, brand, model, color, nbrDoors, screenType, weight, height);
    }
}
