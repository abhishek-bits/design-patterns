package designpattern.behavioral.chainofresponsibility;

public class RoleCheckHandler extends Handler {

    private Database db;

    public RoleCheckHandler(Database db) {
        this.db = db;
    }

    @Override
    public boolean handle(String username, String password) {
        if("admin_username".equals(username)) {
            System.out.println("Loading Admin Page...");
            return true;
        }
        System.out.println("Loading Default Page....");
        return handleNext(username, password);
    }
}
