package designpattern.structural.bridge;

public class AmericanRestaurant extends Restaurant {

    public AmericanRestaurant(Pizza pizza) {
        super(pizza);
    }

    @Override
    void addToppings() {
        pizza.setToppings("Everything");
    }

    @Override
    void addSauce() {
        pizza.setSauce("Super Secret Recipe");
    }

    @Override
    void makeCrust() {
        pizza.setCrust("Thick");
    }
}
