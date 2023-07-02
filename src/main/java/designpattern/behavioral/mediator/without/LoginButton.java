package designpattern.behavioral.mediator.without;

import designpattern.behavioral.mediator.JButton;
import designpattern.behavioral.mediator.TextBox;
import java.awt.event.ActionEvent;

public class LoginButton extends JButton {

    private final TextBox userTxt;
    private final TextBox passTxt;

    public LoginButton(TextBox userTxt, TextBox passTxt) {
        super("Log In");
        this.userTxt = userTxt;
        this.passTxt = passTxt;
    }

    // This Login button that we have created,
    // contains the logic to extract data from our text fields.
    // So, this button is actually tied to these text fields (userTxt and passTxt)
    // and cannot be used without them.
    // BUT
    // This button should be **reusable** across several parts of our app.
    // To solve this problem we will have to create a Mediator.
    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        String username = userTxt.getText();
        String password = passTxt.getText();
        // validates username and password
        // logs in the user or pops error message
    }
}
