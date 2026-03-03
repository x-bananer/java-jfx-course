package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {
    private static Connection conn;

    public static Connection getConnection() {
        if  (conn == null) {
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/currency?user=appuser&password=password"
                );
            }  catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            return conn;
        }
        return conn;
    }

    public static void terminate() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
