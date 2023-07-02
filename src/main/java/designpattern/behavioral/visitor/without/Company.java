package designpattern.behavioral.visitor.without;

public class Company extends Client {

    private final int nbrOfEmployees;

    public Company(String name, String address, String number, int nbrOfEmployees) {
        super(name, address, number);
        this.nbrOfEmployees = nbrOfEmployees;
    }

    @Override
    public void sendMail() {
        // Logic to send mail about Equipment Insurance.
    }
}
