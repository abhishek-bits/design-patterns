package designpattern.creational.factorymethod;

public class MsiManufacturer extends Company {

    // If we want to add more components,
    // we will have to open these methods and
    // make changes to them
    // This violates the Open-Closed Principle.
    @Override
    public Component createComponent(String type) {
        Component component = null;
        if("GPU".equals(type)) {
            component = new AsusGpu();
        } else {
            component = new AsusMonitor();
        }
        return component;
    }
}
