package designpattern.behavioral.strategy.with;

public class PaymentService {

    private int cost;
    private boolean includeDelivery;

    private PaymentStrategy strategy;

    // This class has NO VISIBILITY on how the
    // payment is being constructed as it is making use of
    // the Strategy Interface.
    public void processOrder() {
        strategy.collectPaymentDetails();
        if (strategy.validatePaymentDetails()) {
            strategy.pay(getTotal());
        }

    }

    private int getTotal() {
        return includeDelivery ? cost + 10 : cost;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
}
