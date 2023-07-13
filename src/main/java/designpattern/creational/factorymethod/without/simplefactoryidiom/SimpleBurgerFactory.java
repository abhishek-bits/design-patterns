package designpattern.creational.factorymethod.without.simplefactoryidiom;

import designpattern.creational.factorymethod.Burger;
import designpattern.creational.factorymethod.VeggieBurger;
import designpattern.creational.factorymethod.BeefBurger;

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
