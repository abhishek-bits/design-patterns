package designpattern.behavioral.memento.without;

// The snapshot object needs to show all the details of the text.
// This lets the application expose its information.
// Other classes will become "DEPENDENT" on Snapshot class
// and will be affected by every little change.
public class Snapshot {
    String text;
    boolean bold;
    private boolean italic;
    private boolean underline;
}
