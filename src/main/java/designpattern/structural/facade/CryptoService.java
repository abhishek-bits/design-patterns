package designpattern.structural.facade;

public abstract class CryptoService {

    private CryptoDatabase cryptoDatabase;

    public abstract void buyCurrency(User user, double amount);
}
