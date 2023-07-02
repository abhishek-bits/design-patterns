package designpattern.behavioral.command.with;

import designpattern.behavioral.command.Light;

// Handles the repeated behaviors in our application.
// Similarly, we can have CloseCurtainsCommand or CloseDoorsCommand
public class SwitchLightsCommand implements Command {

    private Light light;

    public SwitchLightsCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchLights();
    }
}
