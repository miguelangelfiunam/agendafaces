package mx.unam.diplomado.agenda.dao;

import mx.unam.diplomado.agenda.dao.interfaces.ITipoContactoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.unam.diplomado.agenda.db.DBConnection;
import mx.unam.diplomado.agenda.db.JDBCUtil;
import mx.unam.diplomado.agendafaces.vo.Contacto;
import mx.unam.diplomado.agendafaces.vo.MedioContacto;
import mx.unam.diplomado.agendafaces.vo.TipoContacto;

public class TipoContactoDAOJDBC implements ITipoContactoDAO {

    private static TipoContactoDAOJDBC instance;

    private TipoContactoDAOJDBC() {
    }

    public static TipoContactoDAOJDBC getInstance() {
        if (instance == null) {
            instance = new TipoContactoDAOJDBC();
        }
        return instance;
    }

    @Override
    public List<TipoContacto> cargaTiposContacto() {
        DBConnection db = JDBCUtil.getInstance();
        List<TipoContacto> tipoContactos = null;
        String query = "SELECT * FROM c_tipo_contacto";
        try ( Connection conn = db.getConnection();  PreparedStatement ps = conn.prepareStatement(query);  ResultSet rs = ps.executeQuery();) {
            tipoContactos = new ArrayList<>();
            while (rs.next()) {
                TipoContacto tipoContacto = new TipoContacto();
                tipoContacto.setId(rs.getInt(1));
                tipoContacto.setNombre(rs.getString(2));
                tipoContacto.setEstatus(rs.getString(3));
                tipoContactos.add(tipoContacto);
            }
        } catch (SQLException sqlx) {

        }
        return tipoContactos;
    }

    @Override
    public TipoContacto getTipoContactoUsuario(Integer idContacto) {
        DBConnection db = JDBCUtil.getInstance();
        TipoContacto tipoContacto = null;
        String query = "SELECT "
                + " tc.id_tipo_contacto, "
                + " tc.vc_nombre, "
                + " tc.vc_estatus "
                + "FROM "
                + " t_contacto AS c, "
                + " c_tipo_contacto AS tc "
                + "WHERE "
                + " c.id_tipo_contacto = tc.id_tipo_contacto "
                + "AND c.id_contacto = ?;";
        try ( Connection conn = db.getConnection();  PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, idContacto);
            try ( ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    tipoContacto = new TipoContacto();
                    tipoContacto.setId(rs.getInt(1));
                    tipoContacto.setNombre(rs.getString(2));
                    tipoContacto.setEstatus(rs.getString(3));
                }
            }
        } catch (SQLException sqlx) {

        }
        return tipoContacto;
    }

    @Override
    public TipoContacto getTipoContacto(Integer idTipoContacto) {
        DBConnection db = JDBCUtil.getInstance();
        TipoContacto tipoContacto = null;
        String query = "SELECT "
                + " tc.id_tipo_contacto, "
                + " tc.vc_nombre, "
                + " tc.vc_estatus "
                + "FROM "
                + " t_contacto AS c, "
                + " c_tipo_contacto AS tc "
                + "WHERE "
                + " c.id_tipo_contacto = tc.id_tipo_contacto "
                + "AND c.id_contacto = ?;";
        try ( Connection conn = db.getConnection();  PreparedStatement ps = conn.prepareStatement(query);  ResultSet rs = ps.executeQuery();) {
            if (rs.next()) {
                tipoContacto = new TipoContacto();
                tipoContacto.setId(rs.getInt(1));
                tipoContacto.setNombre(rs.getString(2));
                tipoContacto.setEstatus(rs.getString(3));
            }
        } catch (SQLException sqlx) {

        }
        return tipoContacto;
    }

}
