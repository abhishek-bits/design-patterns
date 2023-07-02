package designpattern.behavioral.chainofresponsibility;

public abstract class Handler {

    private Handler next;

    public void setNextHandler(Handler next) {
        this.next = next;
    }

    public Handler getNextHandler() {
        return next;
    }

    public abstract boolean handle(String username, String password);

    protected boolean handleNext(String username, String password) {
        if(next == null) {
            return true;
        }
        return next.handle(username, password);
    }
}
