package designpattern.creational.factorymethod.with;

import designpattern.creational.factorymethod.Burger;

public class Main {
    public static void main(String[] args) {

        Restaurant beefResto = new BeefBurgerRestaurant();
        Burger beefBurger = beefResto.orderBurger();

        Restaurant veggieResto = new VeggieBurgerRestaurant();
        Burger veggieBurger = veggieResto.orderBurger();
    }
}
