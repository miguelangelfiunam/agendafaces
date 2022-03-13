package mx.unam.diplomado.agenda.dao;

import mx.unam.diplomado.agenda.dao.interfaces.IMedioContactoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.unam.diplomado.agenda.db.DBConnection;
import mx.unam.diplomado.agenda.db.JDBCUtil;
import mx.unam.diplomado.agendafaces.vo.MedioContacto;

public class MedioContactoDAOJDBC implements IMedioContactoDAO {

    private static MedioContactoDAOJDBC instance;

    private MedioContactoDAOJDBC() {
    }

    public static MedioContactoDAOJDBC getInstance() {
        if (instance == null) {
            instance = new MedioContactoDAOJDBC();
        }
        return instance;
    }

    @Override
    public List<MedioContacto> cargaMediosContacto() {
        DBConnection db = JDBCUtil.getInstance();
        List<MedioContacto> medioContactos = null;
        String query = "SELECT * FROM c_medio_contacto";
        try ( Connection conn = db.getConnection();  PreparedStatement ps = conn.prepareStatement(query);  ResultSet rs = ps.executeQuery();) {
            medioContactos = new ArrayList<>();
            while (rs.next()) {
                MedioContacto medioContacto = new MedioContacto();
                int i = 1;
                medioContacto.setId(rs.getInt(i++));
                medioContacto.setNombre(rs.getString(i++));
                medioContacto.setEstatus(rs.getString(i++));
                medioContactos.add(medioContacto);
            }
        } catch (SQLException sqlx) {

        }

        return medioContactos;
    }

    @Override
    public MedioContacto getMedioContacto(Integer id_medio_contacto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
