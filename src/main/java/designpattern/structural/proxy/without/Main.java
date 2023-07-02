package designpattern.structural.proxy.without;

import designpattern.structural.proxy.Internet;

public class Main {
    public static void main(String[] args) {
        Internet internet = new RealInternet();
        internet.connectTo("google.com");
    }
}
