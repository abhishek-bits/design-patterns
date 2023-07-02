package designpattern.structural.facade;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private double balance;
    private String currency;
    private String accountNbr;
}
