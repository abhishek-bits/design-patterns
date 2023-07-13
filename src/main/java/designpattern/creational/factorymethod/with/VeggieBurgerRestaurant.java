package designpattern.creational.factorymethod.with;

import designpattern.creational.factorymethod.Burger;
import designpattern.creational.factorymethod.VeggieBurger;

public class VeggieBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new VeggieBurger();
    }
}
