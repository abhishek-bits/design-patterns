package designpattern.behavioral.state;

public abstract class State {

    protected Phone phone;

    public State(Phone phone) {
        this.phone = phone;
    }

    // what happens when we click on the HOME button
    public abstract String onHome();

    // what happens when we click on the OFF button
    public abstract String onOffOn();
}
