package designpattern.creational.builder.builderinterface;

// The builder interface will contain
// all construction steps common to all types of builders
public interface Builder {
    Builder id(int id);
    Builder brand(String brand);
    Builder model(String model);
    Builder color(String color);
    Builder nbrDoors(int doors);
    Builder engine(String engine);
    Builder height(int height);
    // more common construction steps here
}
