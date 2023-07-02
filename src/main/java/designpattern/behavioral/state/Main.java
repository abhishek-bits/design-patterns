package designpattern.behavioral.state;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        JButton home = new JButton("Home");
        home.addActionListener(e -> phone.getState().onHome());
        JButton off = new JButton("On/Off");
        off.addActionListener(e -> phone.getState().onOffOn());


    }
}
