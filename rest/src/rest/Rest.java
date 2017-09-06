package rest;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author anggardagasta
 */
public class Rest {

    public static void main(String args[]) throws SQLException {
        Config config = new Config();
        config.Connection();

        Model model = new Model(config.getConn());
        List<UserMapping> allUsers = model.AllUsers();

        allUsers.forEach((UserMapping user) -> {
            System.out.format("%s, %s, %s, %s\n", user.getId(), user.getFullName(), user.getRememberToken(), user.getUpdatedAt());
        });
    }

}
