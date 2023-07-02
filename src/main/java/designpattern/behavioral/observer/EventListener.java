package designpattern.behavioral.observer;

// SUBSCRIBER:
public interface EventListener {
    void update();
    void update(EventType eventType);
}
