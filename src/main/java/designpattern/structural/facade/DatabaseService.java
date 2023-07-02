package designpattern.structural.facade;

import designpattern.structural.facade.User;

public class DatabaseService {
    public User getUser(String userId) {
        return new User();
    }
}
