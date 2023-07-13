package designpattern.creational.abstractfactory.without.factorymethod;

public abstract class Company {

    // Here is our Factory method
    public abstract Component createComponent(String type);
}
