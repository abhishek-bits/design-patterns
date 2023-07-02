package designpattern.behavioral.chainofresponsibility;

public class UserExistsHandler extends Handler {

    private Database db;

    public UserExistsHandler(Database db) {
        this.db = db;
    }

    @Override
    public boolean handle(String username, String password) {
        if(!db.isValidUser(username)) {
            System.out.println("Username not registered!");
            return false;
        }
        // Now, go and run the next check
        return handleNext(username, password);
    }
}
