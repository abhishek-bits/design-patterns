package designpattern.behavioral.visitor.without;

public class Resident extends Client {

    private final String insuranceClass;

    public Resident(String name, String address, String number, String insuranceClass) {
        super(name, address, number);
        this.insuranceClass = insuranceClass;
    }

    @Override
    public void sendMail() {
        // Logic to send mail about Medical Insurance
    }
}
