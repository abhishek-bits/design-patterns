package designpattern.behavioral.memento;

import java.util.Deque;
import java.util.LinkedList;

// This is main editor tool/IDE to be used.
// which encapsulates both the TextArea and the typing history.
public class Editor {

    private Deque<TextArea.Memento> stateHistory;
    private TextArea textArea;

    public Editor() {
        stateHistory = new LinkedList<>();
        textArea = new TextArea();
    }

    public void write(String text) {
        textArea.set(text);
        stateHistory.add(textArea.takeSnapshot());
    }

    public void show() {
        System.out.println(textArea);
    }

    public void undo() {
        if(stateHistory.isEmpty()) {
            return;
        }
        textArea.restore(stateHistory.poll());
    }
}
