package designpattern.behavioral.visitor.without;

public class Restaurant extends Client {

    public final boolean availableAbroad;

    public Restaurant(String name, String address, String number, boolean availableAbroad) {
        super(name, address, number);
        this.availableAbroad = availableAbroad;
    }

    @Override
    public void sendMail() {
        // Logic to mail about Food Insurance
    }

}
