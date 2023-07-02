package designpattern.behavioral.command.without;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        house.addRoom(new LivingRoom());
        house.addRoom(new Bathroom());
        house.addRoom(new Kitchen());
        house.addRoom(new Bedroom());
        house.addRoom(new Bedroom());
        house.rooms.forEach(Room::switchLights);
    }
}
