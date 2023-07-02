package designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Giving the ability to the customer to
// subscribe if:
// - a new item has arrived
// - a sale is announced at store
// - both
public class NotificationServiceV2 {

    private final Map<EventType, List<EventListener>> customers;

    public NotificationServiceV2() {
        customers = new HashMap<>();
        Arrays.stream(EventType.values())
                .forEach(eventType ->
                        customers.put(
                                eventType,
                                new ArrayList<>()));
    }

    public void subscribe(EventType eventType, EventListener eventListener) {
        customers.get(eventType).add(eventListener);
    }

    public void unsubscribe(EventType eventType, EventListener eventListener) {
        customers.get(eventType).remove(eventListener);
    }
    
    public void notify(EventType eventType) {
        customers.get(eventType).forEach(eventListener -> eventListener.update(eventType));
    }
}
