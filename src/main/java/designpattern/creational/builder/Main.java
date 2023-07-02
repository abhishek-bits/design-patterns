package designpattern.creational.builder;

public class Main {
    public static void main(String[] args) {

        CarBuilder builder = new CarBuilder();
        builder.id(2122)
                .brand("Bugatti")
                .model("Chiron")
                .color("Blue");
        Car car = builder.build();

        Director director = new Director();
        CarBuilder builder1 = new CarBuilder();
        director.buildBugatti(builder1);
        Car car1 = builder1.build();
    }
}
