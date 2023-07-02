package designpattern.structural.bridge.without;

public class PepperoniPizza extends Pizza {

    @Override
    public void deliver() {
        System.out.println("Adding Sauce");
        System.out.println("Adding Toppings");
        System.out.println("Adding Pepperoni");
        System.out.println("Order in progress!");
    }
}
