package designpattern.structural.flyweight.without;

import lombok.Data;

// The problem here is that each book object that
// will be created at run-time will hold all these properties
// which may not always be useful.
// And, here we are trying to render millions of such books.
@Data
public class Book {
    private final String name;
    private final double price;
    private final String type;
    private final String distributor;
    private final String otherData;
}
