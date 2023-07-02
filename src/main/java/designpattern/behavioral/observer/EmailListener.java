package designpattern.behavioral.observer;

// Sends emails to the subscribed customers
public class EmailListener implements EventListener{

    private final String email;

    public EmailListener(String email) {
        this.email = email;
    }

    @Override
    public void update() {
        // Actually send the mail to the subscriber
    }

    @Override
    public void update(EventType eventType) {
        // Actually sends the email to the subscribers of the given event type.
    }
}
