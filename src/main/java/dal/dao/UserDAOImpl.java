package dal.dao;

import pojo.User;

import java.util.HashSet;
import java.util.Set;

public class UserDAOImpl {

    Set<User> data;

    public UserDAOImpl() {

        data = new HashSet<>();
        data.add(new User(0,"user", "1234"));
    }

    public Boolean existUserByUsernameAndPassword(String username, String password) {
        return data.stream()
                .anyMatch(user -> user.equals(new User(username,password)));
    }
}
