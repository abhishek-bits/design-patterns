package designpattern.behavioral.strategy.with;

public class PaymentByPayPal implements PaymentStrategy {
    private String email;
    private String password;

    @Override
    public void collectPaymentDetails() {
        // Pop-up to collect PayPal  mail and password.
        email  = "...";
        password = "***";
    }

    @Override
    public boolean validatePaymentDetails() {
        // Add logic to validate/authenticate account details
        return true;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using PayPal");
    }
}
