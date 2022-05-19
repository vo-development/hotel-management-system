package auth;

import pojo.Roles;
import pojo.User;

import java.util.ArrayList;

public class AuthUser {

    private ArrayList<Roles> roles;
    private User user;

    public User getUser() {
        return user;
    }

    public AuthUser(User user) {
        this.user = user;
    }

    public ArrayList<Roles> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Roles> roles) {
        this.roles = roles;
    }
}
