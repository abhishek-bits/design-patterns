package designpattern.structural.composite.without;

import java.util.List;

public class Box {

    private List<Box> boxes;
    private List<Product> products;

    // OPEN TO MODIFICATION:-
    // The Problem with this approach is:
    // If we try to introduce more complex pricing mechanisms
    // What if we need to add more properties (or components)
    // inside the Box class.
    // The whole logic we wrote will have to be revisited.
    public double calculatePrice() {
        double sum = products
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();
        // Use recursion to do the same for all boxes
        for(Box box : boxes) {
            sum = sum + box.calculatePrice();
        }
        return sum;
    }

}
