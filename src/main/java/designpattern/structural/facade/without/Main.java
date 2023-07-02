package designpattern.structural.facade.without;

import designpattern.structural.facade.CryptoFactory;
import designpattern.structural.facade.DatabaseService;
import designpattern.structural.facade.User;

public class Main {
    public static void main(String[] args) {
        // In case we require to re-use the buyCurrency method
        // We will have to copy-paste this code everywhere.
        // Any modification to the business logic will
        // require us to make necessary changes in all the classes.

        // Get logged in user
        User user = new DatabaseService().getUser("");
        double amount = 1000.0;
        CryptoFactory
                .getCryptoService("BTC")
                .buyCurrency(user, amount);
    }
}
