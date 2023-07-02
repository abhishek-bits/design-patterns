package designpattern.behavioral.command.without;

import designpattern.behavioral.command.Light;

public class Room {

    private final Light light;

    public Room() {
        this.light = new Light();
    }

    public void switchLights() {
        light.switchLights();
    }
}
