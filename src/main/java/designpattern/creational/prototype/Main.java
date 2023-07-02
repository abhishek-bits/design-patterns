package designpattern.creational.prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }

    public static List<Vehicle> clone(List<Vehicle> vehicles) {
        List<Vehicle> copyList = new ArrayList<>();
        // This is the advantage of Prototype pattern
        // We can easily create deep copies of objects
        // of exact type (car or bus).
        for(Vehicle vehicle : vehicles) {
            copyList.add(vehicle.clone());
        }
        return copyList;
    }

    public static List<Vehicle> badClone(List<Vehicle> vehicles) {
        List<Vehicle> copyList = new ArrayList<>();
        // Without the prototype pattern,
        // we would have to check for specific instances
        // in the list whether it is a car or a vehicle.
        // i.e. we are coupled with the concrete classes
        // if we don't make use of the prototype pattern
        for(Vehicle vehicle : vehicles) {
            if(vehicle instanceof Car) {
                // Add copy of Car object to list
            } else if(vehicle instanceof Bus) {
                // Add copy of Bus object to List
            } else {
                // ...
            }
        }
        return copyList;
    }
}
