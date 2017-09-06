package rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anggardagasta
 */
public class Model {

    private Connection conn;

    public Model(Connection conn) {
        this.conn = conn;
    }

    public List<UserMapping> AllUsers() throws SQLException {
        ResultSet rs = null;
        Statement st = null;
        List<UserMapping> users = new ArrayList<>();
        try {
            // our SQL SELECT query. 
            String query = "SELECT * FROM users";
            // execute the query, and get a java resultset
            st = this.getConn().createStatement();
            // execute the query, and get a java resultset
            rs = st.executeQuery(query);

            while (rs.next()) {
                UserMapping user = new UserMapping();
                user.setId(rs.getInt("id"));
                user.setFullName(rs.getString("nama_lengkap"));
                user.setRememberToken(rs.getString("remember_token"));
                user.setUpdatedAt(rs.getDate("updated_at"));
                users.add(user);
            }

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            if (this.getConn() != null) {
                try {
                    this.getConn().close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }

        return users;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
