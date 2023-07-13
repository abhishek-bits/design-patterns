package designpattern.creational.factorymethod.without.simplefactoryidiom;

import designpattern.creational.factorymethod.Burger;

public class Restaurant {
    public Burger orderBurger(String request) {
        SimpleBurgerFactory factory = new SimpleBurgerFactory();
        Burger burger = factory.createBurger(request);
        burger.prepare();
        return burger;
    }
}
