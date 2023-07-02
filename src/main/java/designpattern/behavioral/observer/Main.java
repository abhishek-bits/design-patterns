package designpattern.behavioral.observer;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        // add subscribers for email notification
        store.getNotificationService().subscribe(
                new EmailListener("email1@example.com"));
        store.getNotificationService().subscribe(
                new EmailListener("email2@example.com"));

        // add subscribers for push notification
        store.getNotificationService().subscribe(
                new MobileAppListener("store_user"));

        // promote the new item whenever it arrives.
        store.newItemPromotion();
    }
}
