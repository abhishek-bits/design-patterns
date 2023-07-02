package designpattern.behavioral.observer;

public class Store {

    private final NotificationService notificationService;

    public Store() {
        notificationService = new NotificationService();
    }

    // Promotion for new item arrived at store
    public void newItemPromotion() {
        notificationService.publish();
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }
}
