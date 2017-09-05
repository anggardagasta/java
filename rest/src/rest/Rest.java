package rest;

import java.sql.SQLException;

/**
 *
 * @author anggardagasta
 */
public class Rest {

    public static void main(String args[]) throws SQLException {
        Config config = new Config();
        config.Connection();

        Model model = new Model(config.getConn());
        model.AllUsers();
    }

}
