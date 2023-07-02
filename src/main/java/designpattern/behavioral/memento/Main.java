package designpattern.behavioral.memento;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.write("Like and");
        editor.write("Like and Subscribe");
        editor.show();
        editor.undo();
        editor.write("Like and Comment");
        editor.show();
    }
}
