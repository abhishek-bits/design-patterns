package designpattern.structural.composite.with;

public class VideoGame extends Product {
    public VideoGame(String title, double price) {
        super(title, price);
    }

    // In our Product's implementation
    // this method will simply return the product.
    @Override
    public double calculatePrice() {
        return getPrice();
    }
}
