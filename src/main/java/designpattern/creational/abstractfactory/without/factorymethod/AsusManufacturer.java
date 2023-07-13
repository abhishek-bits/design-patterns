package designpattern.creational.abstractfactory.without.factorymethod;

public class AsusManufacturer extends Company {

    // The factory method is now open to modification
    // which we do not want to happen.
    // This violates the Open-Closed Principle.
    @Override
    public Component createComponent(String type) {
        Component component = null;
        if("GPU".equals(type)) {
            component = new AsusGpu();
        } else  {
            component = new MsiGpu();
        }
        return component;
    }
}
