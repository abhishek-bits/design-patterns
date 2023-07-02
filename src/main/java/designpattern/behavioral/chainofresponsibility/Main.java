package designpattern.behavioral.chainofresponsibility;

public class Main {
    public static void main(String[] args) {

        Database database = new Database();

        // Initialize handlers
        Handler handler = new UserExistsHandler(database);
        ValidPasswordHandler handler2 = new ValidPasswordHandler(database);
        RoleCheckHandler handler3 = new RoleCheckHandler(database);

        // Prepare Chain
        handler2.setNextHandler(handler3);
        handler.setNextHandler(handler2);

        AuthService service = new AuthService(handler);
        service.logIn("admin_username", "admin_password");
    }
}
