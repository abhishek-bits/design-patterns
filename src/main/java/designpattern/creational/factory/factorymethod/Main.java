package designpattern.creational.factory.factorymethod;

import designpattern.creational.factory.Burger;

public class Main {
    public static void main(String[] args) {

        Restaurant beefResto = new BeefBurgerRestaurant();
        Burger beefBurger = beefResto.orderBurger();

        Restaurant veggieResto = new VeggieBurgerRestaurant();
        Burger veggieBurger = veggieResto.orderBurger();
    }
}
