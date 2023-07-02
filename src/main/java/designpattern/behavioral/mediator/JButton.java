package designpattern.behavioral.mediator;

import java.awt.event.ActionEvent;

public abstract class JButton {

    private final String buttonType;

    public JButton(String buttonType) {
        this.buttonType = buttonType;
    }

    protected abstract void fireActionPerformed(ActionEvent actionEvent);
}
