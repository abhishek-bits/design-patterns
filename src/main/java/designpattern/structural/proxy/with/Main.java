package designpattern.structural.proxy.with;

import designpattern.structural.proxy.Internet;

public class Main {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        internet.connectTo("google.com");
        internet.connectTo("banned.com");
    }
}
