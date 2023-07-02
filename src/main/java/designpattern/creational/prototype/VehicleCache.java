package designpattern.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class VehicleCache {

    // Prototype Registry
    private final Map<String, Vehicle> cache = new HashMap<>();

    public VehicleCache() {
        Car car = new Car(
                "Bugatti",
                "Chiron",
                "Blue",
                261,
                new GpsSystem(
                        1.567,
                        2.456
                ));

        Bus bus = new Bus(
                "Mercedes",
                "Setra",
                "White",
                48);

        cache.put("Bugatti Cheron", car);
        cache.put("Mercedes Setra", bus);
    }

    public Vehicle get(String key) {
        if(cache.containsKey(key)) {
            // Clone it and then return
            return cache.get(key).clone();
        }
        return null;
    }
}
