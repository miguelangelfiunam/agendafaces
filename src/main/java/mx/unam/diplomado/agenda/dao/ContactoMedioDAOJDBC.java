package mx.unam.diplomado.agenda.dao;

import mx.unam.diplomado.agenda.dao.interfaces.IContactoMedioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.unam.diplomado.agenda.db.DBConnection;
import mx.unam.diplomado.agenda.db.JDBCUtil;
import mx.unam.diplomado.agendafaces.vo.ContactoMedio;

public class ContactoMedioDAOJDBC implements IContactoMedioDAO {

    private static ContactoMedioDAOJDBC instance;

    private ContactoMedioDAOJDBC() {
    }

    public static ContactoMedioDAOJDBC getInstance() {
        if (instance == null) {
            instance = new ContactoMedioDAOJDBC();
        }
        return instance;
    }

    @Override
    public List<ContactoMedio> getContactoMediosPorContacto(Integer id_contacto) {
        DBConnection db = JDBCUtil.getInstance();
        List<ContactoMedio> contactoMedios = null;
        String query = "SELECT "
                + " tcm.id_contactos_medios, "
                + " tcm.id_contacto, "
                + " tcm.id_medio_contacto, "
                + " tcm.vc_valor "
                + "FROM "
                + " t_contacto AS c, "
                + " t_contactos_medios AS tcm, "
                + " c_medio_contacto cmc "
                + "WHERE "
                + " c.id_contacto = tcm.id_contacto "
                + "AND tcm.id_medio_contacto = cmc.id_medio_contacto "
                + "AND c.id_contacto = ?;";
        try ( Connection conn = db.getConnection();  PreparedStatement ps = conn.prepareStatement(query);) {
            contactoMedios = new ArrayList<>();
            ps.setInt(1, id_contacto);
            try ( ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    ContactoMedio contactoMedio = new ContactoMedio();
                    int i = 1;
                    contactoMedio.setId_contacto_medio(rs.getInt(i++));
                    contactoMedio.setId_contacto(rs.getInt(i++));
                    contactoMedio.setId_medio_contacto(rs.getInt(i++));
                    contactoMedio.setValor(rs.getString(i++));
                    contactoMedios.add(contactoMedio);
                }
            }
        } catch (SQLException sqlx) {

        }

        return contactoMedios;
    }

    @Override
    public ContactoMedio getContactoMedio(Integer id_contacto_medios) {
        DBConnection db = JDBCUtil.getInstance();
        ContactoMedio contactoMedio = null;
        String query = "SELECT "
                + " tcm.id_contactos_medios, "
                + " tcm.id_contacto, "
                + " tcm.id_medio_contacto, "
                + " tcm.vc_valor "
                + "FROM "
                + " t_contactos_medios AS tcm "
                + "WHERE "
                + " tcm.id_contactos_medios = ?";
        try ( Connection conn = db.getConnection();  PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, id_contacto_medios);
            try ( ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    contactoMedio = new ContactoMedio();
                    int i = 1;
                    contactoMedio.setId_contacto_medio(rs.getInt(i++));
                    contactoMedio.setId_contacto(rs.getInt(i++));
                    contactoMedio.setId_medio_contacto(rs.getInt(i++));
                    contactoMedio.setValor(rs.getString(i++));
                }
            }
        } catch (SQLException sqlx) {

        }
        return contactoMedio;
    }

    @Override
    public void insertaContactoMedio(ContactoMedio contactoMedio) {
        DBConnection db = JDBCUtil.getInstance();
        String query = "INSERT INTO t_contactos_medios (id_contacto, id_medio_contacto, vc_valor)"
                + "VALUES (?, ?, ?);";
        try ( Connection conn = db.getConnection();  PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, contactoMedio.getId_contacto());
            ps.setInt(2, contactoMedio.getId_medio_contacto());
            ps.setString(3, contactoMedio.getValor());

            ps.executeUpdate();
        } catch (SQLException sqlx) {

        }
    }

    @Override
    public void actualizaContactoMedio(ContactoMedio contactoMedio) {
        DBConnection db = JDBCUtil.getInstance();
        String query = "UPDATE  t_contactos_medios SET  id_medio_contacto = ?, vc_valor = ? WHERE id_contactos_medios = ?";
        try ( Connection conn = db.getConnection();  PreparedStatement stUpdate = conn.prepareStatement(query);) {
            stUpdate.setInt(1, contactoMedio.getId_medio_contacto());
            stUpdate.setString(2, contactoMedio.getValor());
            stUpdate.setInt(3, contactoMedio.getId_contacto_medio());

            if (stUpdate.executeUpdate() == 0) {
                throw new IllegalStateException("Error al actualizar contactoMedio");
            }
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    @Override
    public void borraContactoMedio(Integer id_contacto_medios) {
        DBConnection db = JDBCUtil.getInstance();
        String query = "DELETE FROM t_contactos_medios WHERE id_contactos_medios = ?;";
        try ( Connection conn = db.getConnection();  PreparedStatement stUpdate = conn.prepareStatement(query);) {
            stUpdate.setInt(1, id_contacto_medios);
            if (stUpdate.executeUpdate() == 0) {
                throw new IllegalStateException("Error al borrar contactoMedio");
            }
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

}
