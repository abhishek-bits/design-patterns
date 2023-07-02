package designpattern.structural.flyweight.with;

import lombok.Data;

@Data
public class Book {
    private final String name;
    private final double price;
    private final BookType type;
}
