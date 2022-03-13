package mx.unam.diplomado.agenda.dao.interfaces;

import java.util.List;
import mx.unam.diplomado.agendafaces.vo.*;

public interface IMedioContactoDAO {

    List<MedioContacto> cargaMediosContacto();

    MedioContacto getMedioContacto(Integer id_medio_contacto);

}
