package mx.unam.diplomado.agenda.dao.interfaces;

import java.util.List;
import mx.unam.diplomado.agendafaces.vo.*;

public interface IContactoMedioDAO {

    List<ContactoMedio> getContactoMediosPorContacto(Integer id_usuario);

    ContactoMedio getContactoMedio(Integer id_contacto_medios);

    void insertaContactoMedio(ContactoMedio contactoMedio);
    
    void actualizaContactoMedio(ContactoMedio contactoMedio);
    
    void borraContactoMedio(Integer id_contacto_medios);

}
