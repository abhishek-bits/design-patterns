package designpattern.creational.factory.simplefactoryidiom;

import designpattern.creational.factory.Burger;
import designpattern.creational.factory.VeggieBurger;
import designpattern.creational.factory.BeefBurger;

public class SimpleBurgerFactory {
    public Burger createBurger(String request) {
        Burger burger = null;
        if("BEEF".equals(request)) {
            burger = new BeefBurger();
        } else if("VEGGIE".equals(request)) {
            burger = new VeggieBurger();
        }
        return burger;
    }
}
