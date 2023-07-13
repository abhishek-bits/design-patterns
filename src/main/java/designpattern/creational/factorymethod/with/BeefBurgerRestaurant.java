package designpattern.creational.factorymethod.with;

import designpattern.creational.factorymethod.BeefBurger;
import designpattern.creational.factorymethod.Burger;

public class BeefBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new BeefBurger();
    }
}
