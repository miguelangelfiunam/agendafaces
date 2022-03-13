package mx.unam.diplomado.agenda.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCUtil implements DBConnection {

    private static JDBCUtil instance;

    private JDBCUtil() {
    }

    public static JDBCUtil getInstance() {
        if (instance == null) {
            instance = new JDBCUtil();
        }
        return instance;
    }

    @Override
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(ResourceBundle.getBundle("agenda").getString("datasource.driverClassName"));
            conn = DriverManager
                    .getConnection(ResourceBundle.getBundle("agenda").getString("datasource.jdbcUrl"),
                            ResourceBundle.getBundle("agenda").getString("datasource.username"),
                            ResourceBundle.getBundle("agenda").getString("datasource.password"));
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERROR AL OBTENER LA CONEXION POSTGRESQL=="
                    + ex.getMessage());
        }

        return conn;
    }

    @Override
    public void closeConnection(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

}
