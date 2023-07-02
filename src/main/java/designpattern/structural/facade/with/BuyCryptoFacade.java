package designpattern.structural.facade.with;

import designpattern.structural.decorator.DatabaseService;
import designpattern.structural.facade.User;
import designpattern.structural.facade.UIService;
import designpattern.structural.facade.CryptoFactory;

public class BuyCryptoFacade {

    // In this method, we add as many parameters
    // as the optimal needed information
    // to proceed with the transaction.
    // As Simple as Possible!
    public void buyCryptoCurrency(double amount, String currency) {
        DatabaseService dbService = new DatabaseService();
        User user = dbService.getUser(UIService.getLoggedInUserId());
        if(user.getBalance() < amount) {
            System.out.println("Insufficient balance to perform transaction");
            return;
        }
        CryptoFactory.getCryptoService(currency).buyCurrency(user, amount);
        // Send confirmation mail to user
    }
}
