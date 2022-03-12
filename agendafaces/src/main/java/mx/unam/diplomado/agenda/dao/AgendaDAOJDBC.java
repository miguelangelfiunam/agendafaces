package mx.unam.diplomado.agenda.dao;

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
	
	private AgendaDAOJDBC() {}
	
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
		try 
		(Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(query.toString());
				ResultSet rs = ps.executeQuery();) {			
			contactos = new ArrayList<>();
            while (rs.next()) {
            	Contacto contacto = new Contacto();
            	contacto.setNombre(rs.getString("vc_nombre"));
            	contacto.setApellidos(rs.getString("vc_apellidos"));
            	contacto.setEdad(rs.getInt("vi_edad"));
            	contactos.add(contacto);
            }                
		} catch (SQLException sqlx) {
			
		}
		
		return contactos;
	}
	
	

}
