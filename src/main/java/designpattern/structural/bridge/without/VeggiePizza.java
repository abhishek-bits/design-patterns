package designpattern.structural.bridge.without;

public class VeggiePizza extends Pizza {

    @Override
    public void deliver() {
        System.out.println("Adding Sauce");
        System.out.println("Adding Different Toppings");
        System.out.println("Adding Cheese");
        System.out.println("Order in Progress!");
    }
}
