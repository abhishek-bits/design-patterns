package designpattern.structural.decorator;

public class FacebookDecorator extends BaseNotifierDecorator {
    public FacebookDecorator(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String message) {
        super.send(message);
        String fbName = databaseService.getFBNameFromUsername(getUsername());
        System.out.println("Sending " + message + " on Facebook to " + fbName);
    }
}
