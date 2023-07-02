package designpattern.structural.proxy.without;

import designpattern.structural.proxy.Internet;

public class RealInternet implements Internet {
    @Override
    public void connectTo(String host) {
        if("banned.com".equals(host)) {
            System.out.println("Access Denied!");
            return;
        }
        System.out.println("Opened connection to " + host);
    }
}
