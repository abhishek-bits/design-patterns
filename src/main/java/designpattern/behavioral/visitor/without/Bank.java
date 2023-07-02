package designpattern.behavioral.visitor.without;

public class Bank extends Client {

    private final int branchesInsured;

    public Bank(String name, String address, String number, int branchesInsured) {
        super(name, address, number);
        this.branchesInsured = branchesInsured;
    }

    @Override
    public void sendMail() {
        // Logic to send mail about Theft Insurance.
    }
}
