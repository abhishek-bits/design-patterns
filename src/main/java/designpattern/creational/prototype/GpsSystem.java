package designpattern.creational.prototype;

public class GpsSystem {

    private final double xCord;
    private final double yCord;

    public GpsSystem(double xCord, double yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    // Copy Constructor
    public GpsSystem(GpsSystem gpsSystem) {
        this.xCord = gpsSystem.xCord;
        this.yCord = gpsSystem.yCord;
    }

    @Override
    public GpsSystem clone() {
        return new GpsSystem(this);
    }
}
