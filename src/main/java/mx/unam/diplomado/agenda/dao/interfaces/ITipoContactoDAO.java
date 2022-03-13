package mx.unam.diplomado.agenda.dao.interfaces;

import java.util.List;
import mx.unam.diplomado.agendafaces.vo.*;

public interface ITipoContactoDAO {

    List<TipoContacto> cargaTiposContacto();

    TipoContacto getTipoContactoUsuario(Integer idContacto);

    TipoContacto getTipoContacto(Integer idTipoContacto);

}
