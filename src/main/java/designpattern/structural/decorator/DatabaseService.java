package designpattern.structural.decorator;

import designpattern.structural.facade.User;

public class DatabaseService {

    public User getUser(String userId) {
        return new User();
    }
    public String getEmailByUsername(String username) {
        return username + "@Mail";
    }

    public String getFBNameFromUsername(String username) {
        return username + "@Facebook";
    }

    public String getPhoneNbrFromUsername(String username) {
        return username + "@WhatsApp";
    }
}
