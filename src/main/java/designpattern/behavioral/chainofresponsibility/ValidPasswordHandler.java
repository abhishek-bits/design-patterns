package designpattern.behavioral.chainofresponsibility;

public class ValidPasswordHandler extends Handler {

    private Database db;

    public ValidPasswordHandler(Database db) {
        this.db = db;
    }

    @Override
    public boolean handle(String username, String password) {
        if(!db.isValidPassword(username, password)) {
            System.out.println("Wrong Password!");
            return false;
        }
        return handleNext(username, password);
    }
}
