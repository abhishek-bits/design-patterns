package designpattern.structural.facade;

public class CryptoFactory {
    public static CryptoService getCryptoService(String currency) {
        switch (currency) {
            case "BTC":
                return new BitcoinService();
            case "ETH":
                return new EthereumService();
            default:
                return null;
        }
    }
}
