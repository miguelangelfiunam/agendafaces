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
    public List<ContactoMedio> getContactoMediosPorUsuario(Integer id_usuario) {
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
            ps.setInt(1, id_usuario);
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
    public ContactoMedio getContactosMedios(Integer id_contacto_medios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
