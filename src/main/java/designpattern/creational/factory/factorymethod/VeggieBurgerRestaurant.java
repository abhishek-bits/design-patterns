package designpattern.creational.factory.factorymethod;

import designpattern.creational.factory.Burger;
import designpattern.creational.factory.VeggieBurger;

public class VeggieBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new VeggieBurger();
    }
}
