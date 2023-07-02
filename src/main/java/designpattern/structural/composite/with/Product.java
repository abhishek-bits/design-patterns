package designpattern.structural.composite.with;

import lombok.Data;

@Data
public abstract class Product implements Box {
    protected final String title;
    protected final double price;
}
