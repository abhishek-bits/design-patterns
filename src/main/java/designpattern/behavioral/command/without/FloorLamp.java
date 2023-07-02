package designpattern.behavioral.command.without;

import designpattern.behavioral.command.Light;

// DUPLICATION ISSUE:
// Since FloorLamp is not a Room,
// We cannot extend Room class here.
// Here, floor Lamp needs to have
// its own logic to switch lights on/off.
public class FloorLamp {

    private final Light light;

    public FloorLamp() {
        this.light = new Light();
    }

    public void switchLights() {
        light.switchLights();
    }
}
