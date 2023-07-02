package designpattern.behavioral.command;

public class Light {

    private boolean switchedOn;

    public Light() {
        switchedOn = false;
    }

    // Light class should have its own logic
    // to switch lights to avoid code duplication.
    public void switchLights() {
        switchedOn = !switchedOn;
    }
}
