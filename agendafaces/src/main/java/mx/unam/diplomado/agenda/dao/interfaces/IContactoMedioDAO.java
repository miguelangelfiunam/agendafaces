package mx.unam.diplomado.agenda.dao.interfaces;

import java.util.List;
import mx.unam.diplomado.agendafaces.vo.*;

public interface IContactoMedioDAO {

    List<ContactoMedio> getContactoMediosPorUsuario(Integer id_usuario);

    ContactoMedio getContactosMedios(Integer id_contacto_medios);

}
