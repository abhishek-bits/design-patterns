package designpattern.structural.decorator;

public class Main {
    public static void main(String[] args) {

        INotifier notifier = new FacebookDecorator(
                // The Wrapped object provided to the Facebook decorator
                // is itself a WhatsApp decorated one
                new WhatsAppDecorator(
                        // but the wrapped object provided to the WhatsApp decorator
                        // is a simple Notifier object.
                        new Notifier("username")
                )
        );

        notifier.send("message");
    }
}
