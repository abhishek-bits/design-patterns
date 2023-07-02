package designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

// PUBLISHER:
public class NotificationService {

    private final List<EventListener> eventListeners;

    public NotificationService() {
        eventListeners = new ArrayList<>();
    }

    public void subscribe(EventListener listener) {
        eventListeners.add(listener);
    }

    public void unsubscribe(EventListener listener) {
        eventListeners.remove(listener);
    }

    public void publish() {
        eventListeners.forEach(EventListener::update);
    }
}
