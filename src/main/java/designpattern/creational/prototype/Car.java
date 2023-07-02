package designpattern.creational.prototype;

public class Car extends Vehicle {

    private final
    int topSpeed;
    private GpsSystem gpsSystem;

    public Car(String brand, String model, String  color, int topSpeed, GpsSystem gpsSystem) {
        super(brand, model, color);
        this.topSpeed = topSpeed;
        // HARD COPY
        this.gpsSystem = gpsSystem.clone();
    }

    // Copy Constructor
    public Car(Car car) {
        super(car);
        this.topSpeed = car.topSpeed;
        // SHALLOW COPY!
        // this newly created car will reference the
        // same 'GpsSystem' object in the memory,
        // and any change done on this object will
        // be reflected in both cars.
        this.gpsSystem = car.gpsSystem;

        // DEEP COPY!
        // any change done on the first 'GpsSystem'
        // object will not affect the second one
        // and vice versa.
        this.gpsSystem = gpsSystem.clone();
    }

    @Override
    public Car clone() {
        return new Car(this);
    }
}
