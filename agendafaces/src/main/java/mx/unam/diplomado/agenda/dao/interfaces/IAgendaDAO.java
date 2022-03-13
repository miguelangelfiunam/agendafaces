package mx.unam.diplomado.agenda.dao.interfaces;

import java.util.List;
import mx.unam.diplomado.agendafaces.vo.*;

public interface IAgendaDAO {

    List<Contacto> cargaContactos();

    Contacto cargaContacto(Integer id);

}
