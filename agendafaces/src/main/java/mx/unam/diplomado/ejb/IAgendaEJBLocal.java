package mx.unam.diplomado.ejb;

import java.util.List;

import jakarta.ejb.Local;
import mx.unam.diplomado.agendafaces.vo.Contacto;

@Local
public interface IAgendaEJBLocal {
	
	List<Contacto> cargaContactos();

}
