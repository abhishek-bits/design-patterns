package designpattern.behavioral.memento;

public class TextArea {

    private String text;

    public void set(String text) {
        this.text = text;
    }

    public Memento takeSnapshot() {
        return new Memento(this.text);
    }

    public void restore(Memento memento) {
        this.text = memento.getSavedText();
    }

    @Override
    public String toString() {
        return text;
    }

    // ...

    // The MEMENTO will have the same attributes
    // as the TextArea
    public static class Memento {

        private final String text;

        private Memento(String textToSave) {
            text = textToSave;
        }

        // The getter should only be accessible
        // to the outer class (TextArea class) only.
        // Hence, the private keyword.
        private String getSavedText() {
            return text;
        }

    }
}
