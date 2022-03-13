package mx.unam.diplomado.agenda.dao;

import mx.unam.diplomado.agenda.dao.interfaces.IAgendaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.unam.diplomado.agenda.db.DBConnection;
import mx.unam.diplomado.agenda.db.JDBCUtil;
import mx.unam.diplomado.agendafaces.vo.Contacto;

public class AgendaDAOJDBC implements IAgendaDAO {

    private static AgendaDAOJDBC instance;

    private AgendaDAOJDBC() {
    }

    public static AgendaDAOJDBC getInstance() {
        if (instance == null) {
            instance = new AgendaDAOJDBC();
        }
        return instance;
    }

    @Override
    public List<Contacto> cargaContactos() {
        DBConnection db = JDBCUtil.getInstance();
        List<Contacto> contactos = null;
        String query = "SELECT * FROM t_contacto";
        try ( Connection conn = db.getConnection();  PreparedStatement ps = conn.prepareStatement(query);  ResultSet rs = ps.executeQuery();) {
            contactos = new ArrayList<>();
            while (rs.next()) {
                Contacto contacto = new Contacto();
                contacto.setId(rs.getInt("id_contacto"));
                contacto.setNombre(rs.getString("vc_nombre"));
                contacto.setApellidos(rs.getString("vc_apellidos"));
                contacto.setEdad(rs.getInt("vi_edad"));
                contacto.setDireccion(rs.getString("vc_direccion"));
                contactos.add(contacto);
            }
        } catch (SQLException sqlx) {

        }
        return contactos;
    }

    @Override
    public Contacto cargaContacto(Integer id) {
        DBConnection db = JDBCUtil.getInstance();
        Contacto contacto = null;
        String query = "SELECT * FROM t_contacto WHERE id_contacto = ?;";
        try ( Connection conn = db.getConnection();  PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, id);
            try ( ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    contacto = new Contacto();
                    contacto.setId(rs.getInt("id_contacto"));
                    contacto.setNombre(rs.getString("vc_nombre"));
                    contacto.setApellidos(rs.getString("vc_apellidos"));
                    contacto.setEdad(rs.getInt("vi_edad"));
                    contacto.setDireccion(rs.getString("vc_direccion"));
                }
            }
        } catch (SQLException sqlx) {

        }
        return contacto;
    }

}
