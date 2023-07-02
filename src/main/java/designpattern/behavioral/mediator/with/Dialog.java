package designpattern.behavioral.mediator.with;

import designpattern.behavioral.mediator.without.LoginButton;
import designpattern.behavioral.mediator.TextBox;

// Here, the dependencies between our different objects or
// in this case, different UI components will sit.
// As a result, the components will depend only on a single mediator class instead.
public class Dialog implements Mediator {

    private TextBox userTxtBox;
    private TextBox passTxtBox;
    private LoginButton button;

    @Override
    public void login() {
        String username = userTxtBox.getText();
        String password = passTxtBox.getText();
        // validate username and password
        // logs in the user or pops error message.
    }

}
