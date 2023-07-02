package designpattern.behavioral.strategy.without;

import designpattern.behavioral.strategy.CreditCard;

public class PaymentService {

    private int cost;
    private boolean includeDelivery;

    // PROBLEM with this approach:
    // What if we try to add more payment methods?
    // 1.
    // We would be creating a chain of if-else.
    // This will be a BAD Implementation and HARD to MAINTAIN.
    // This violates the Open-Closed Principle.
    // 2.
    // This class handles several Responsibilities
    // This  violates the Single-Responsibility principle.
    public void processOrder(String paymentMethod) {
        if("CreditCard".equals(paymentMethod)) {
            // STEP 1: Pop-up to collect card details
            CreditCard card = new CreditCard("cardNumber", "expiryDate", "cvv");
            // STEP 2: Validate Credit card
            System.out.println("Paying " + getTotal() + " using Credit Card");
            card.setAmount(card.getAmount() - getTotal());
        }  else if("PayPal".equals(paymentMethod)) {
            // STEP 1; Pop-up to collect PayPal mail and password...
            String email = "...";
            String password = "***";
            // STEP 2: Validate  account.
            System.out.println("Paying " + getTotal() + " using PayPal");
        }
    }

    private int getTotal() {
        return  includeDelivery ? cost *  10 : cost;
    }
}
