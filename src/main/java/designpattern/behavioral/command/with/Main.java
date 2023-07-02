package designpattern.behavioral.command.with;

import designpattern.behavioral.command.Light;

public class Main {
    public static void main(String[] args) {
        Room livingRoom = new LivingRoom();
        livingRoom.setCommand(new SwitchLightsCommand(new Light()));
        livingRoom.executeCommand();
    }
}
