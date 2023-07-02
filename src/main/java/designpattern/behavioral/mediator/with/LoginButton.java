package designpattern.behavioral.mediator.with;

import designpattern.behavioral.mediator.JButton;

import java.awt.event.ActionEvent;


public class LoginButton extends JButton implements Component {

    private Mediator mediator;

    public LoginButton(String buttonType) {
        super("Log In");
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.login();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "Login Button";
    }
}
