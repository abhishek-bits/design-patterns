package designpattern.structural.bridge;

public class ItalianRestaurant extends Restaurant {

    public ItalianRestaurant(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void addToppings() {
        pizza.setToppings(null);
    }

    @Override
    void addSauce() {
        pizza.setSauce("Oil");
    }

    @Override
    void makeCrust() {
        pizza.setCrust("Thin");
    }
}
