package mx.unam.diplomado.agenda.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnection {

    Connection getConnection();

    void closeConnection(Connection conn) throws SQLException;

}
