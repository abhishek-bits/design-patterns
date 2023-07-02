package designpattern.structural.decorator;

// We shall keep the initial Notifier class as it is.
public class Notifier implements INotifier {
    private final String username;
    private final DatabaseService databaseService;

    public Notifier(String username) {
        this.username = username;
        databaseService = new DatabaseService();
    }

    @Override
    public void send(String message) {
        String email = databaseService.getEmailByUsername(username);
        System.out.println("Sending " + message + " by Email to " + email);
    }

    @Override
    public String getUsername() {
        return username;
    }
}
