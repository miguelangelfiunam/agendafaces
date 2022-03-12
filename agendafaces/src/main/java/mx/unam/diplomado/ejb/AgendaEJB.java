package mx.unam.diplomado.ejb;

import java.util.List;
import jakarta.ejb.Stateless;
import mx.unam.diplomado.agenda.dao.AgendaDAOJDBC;
import mx.unam.diplomado.agenda.dao.IAgendaDAO;
import mx.unam.diplomado.agendafaces.vo.Contacto;

/**
 * Session Bean implementation class AgendaEJB
 */
@Stateless
public class AgendaEJB implements IAgendaEJBLocal {
	
	private IAgendaDAO daoAgenda;
    
    public List<Contacto> cargaContactos() {
    	daoAgenda = AgendaDAOJDBC.getInstance();
		return daoAgenda.cargaContactos();
	}

}
