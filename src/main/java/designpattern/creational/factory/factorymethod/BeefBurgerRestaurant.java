package designpattern.creational.factory.factorymethod;

import designpattern.creational.factory.BeefBurger;
import designpattern.creational.factory.Burger;

public class BeefBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new BeefBurger();
    }
}
