package designpattern.behavioral.observer;

// sends push notifications to the customers
// with the store's mobile app in their mobile phone
public class MobileAppListener implements EventListener {

    private final String username;

    public MobileAppListener(String username) {
        this.username = username;
    }

    @Override
    public void update() {
        // Actually sends push notifications to the customers
    }

    @Override
    public void update(EventType eventType) {

    }
}
