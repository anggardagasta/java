package rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author anggardagasta
 */
public class Model {

    private Connection conn;

    public Model(Connection conn) {
        this.conn = conn;
    }

    public void AllUsers() throws SQLException {
        try {
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM users";

            // execute the query, and get a java resultset
            try ( // create the java statement
                    Statement st = this.getConn().createStatement()) {
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String fullName = rs.getString("nama_lengkap");
                    String rememberToken = rs.getString("remember_token");
                    Date createdAt = rs.getDate("updated_at");
//                boolean isAdmin = rs.getBoolean("is_admin");
//                int numPoints = rs.getInt("num_points");
//
//                // print the results
                    System.out.format("%s, %s, %s, %s\n", id, fullName, rememberToken, createdAt);
                }
            }
        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
