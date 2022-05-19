package auth;

import dal.dao.RolesDAO;
import pojo.User;

public class CurrentAuthUser {

    private static RolesDAO rolesDAO = new RolesDAO();

    private static AuthUser authUser = null;


    public static AuthUser getAuthUser() {
        return authUser;
    }

    public static void setAuthUser(User user) {

        if(user != null){

            authUser = new AuthUser(user);

            var userId = user.getId();

            var userRoles = rolesDAO.findByUser(userId);

            authUser.setRoles(userRoles);

            CurrentAuthUser.authUser = authUser;
        }



    }
}
