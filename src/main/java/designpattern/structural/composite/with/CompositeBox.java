package designpattern.structural.composite.with;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeBox implements Box{
    private final List<Box> children = new ArrayList<>();

    public CompositeBox(Box... boxes) {
        children.addAll(Arrays.asList(boxes));
    }

    // But,
    // In the Box's implementation, this method
    // will iterate over all the boxes and collect the sum
    // total of all the box's price.
    // Here, a box could even add some extra cost
    // to its individual price such as a packaging cost.
    @Override
    public double calculatePrice() {
        return children
                .stream()
                .mapToDouble(Box::calculatePrice)
                .sum();
    }
}
