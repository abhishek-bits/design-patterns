package designpattern.behavioral.strategy.with;

import designpattern.behavioral.strategy.CreditCard;

public class PaymentByCreditCard implements PaymentStrategy {

    private CreditCard card;

    @Override
    public void collectPaymentDetails() {
        // Pop-up to collect card details
        card = new CreditCard("cardNumber", "expiryDate", "cvv");
    }

    @Override
    public boolean validatePaymentDetails() {
        // Add logic to validate credit card
        return true;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using Credit Card");
        card.setAmount(card.getAmount() - amount);
    }
}
