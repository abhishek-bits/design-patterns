package designpattern.structural.flyweight.with;

import lombok.AllArgsConstructor;
import lombok.Getter;

// This is a Flyweight class.
@Getter
@AllArgsConstructor
public class BookType {
    private final String type;
    private final String distributor;
    private final String otherData;
}
