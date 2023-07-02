package designpattern.behavioral.chainofresponsibility;

public class AuthService {

    private final Handler handler;

    public AuthService(Handler handler) {
        this.handler = handler;
    }

    public boolean logIn(String username, String password) {
        if(handler.handle(username, password)) {
            System.out.println("Authorization was successful!");

            // Do stuff for authorized users

            return true;
        }
        return false;
    }
}
