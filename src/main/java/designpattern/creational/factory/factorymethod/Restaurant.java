package designpattern.creational.factory.factorymethod;

import designpattern.creational.factory.Burger;

public abstract class Restaurant {

    // Notice that the orderBurger() method is no longer
    // dependent on the request object.
    public Burger orderBurger() {
        Burger burger = createBurger();
        burger.prepare();
        return burger;
    }

    // Here is our Factory method
    // This will be implemented by the
    // subclasses of the Restaurant class.
    public abstract Burger createBurger();
}
