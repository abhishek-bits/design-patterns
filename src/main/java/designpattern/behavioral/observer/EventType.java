package designpattern.behavioral.observer;

// Giving the customers (subscribers) the ability to
// subscribe to either when a new item is available, or
// when sale is announced, or both.
public enum EventType {
    /** Promotion for new item */
    NEW_ITEM,

    /** Promotion for a sale announcement */
    SALE
}
