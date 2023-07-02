package designpattern.creational.factory.simplefactoryidiom;

import designpattern.creational.factory.Burger;

public class Restaurant {
    public Burger orderBurger(String request) {
        SimpleBurgerFactory factory = new SimpleBurgerFactory();
        Burger burger = factory.createBurger(request);
        burger.prepare();
        return burger;
    }
}
