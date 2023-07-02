package designpattern.behavioral.visitor;

public abstract class Client {

    private final String name;
    private final String address;
    private final String number;

    protected Client(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    // Once, the underlying Visitor's implementation will be plugged in
    // Then, the respective Client's implementation can call their visit() to
    // send the required notification.
    public abstract void accept(Visitor visitor);
}
