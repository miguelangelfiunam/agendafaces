package mx.unam.diplomado.ejb;

import java.util.List;

import jakarta.ejb.Local;
import mx.unam.diplomado.agendafaces.vo.Contacto;
import mx.unam.diplomado.agendafaces.vo.ContactoMedio;
import mx.unam.diplomado.agendafaces.vo.MedioContacto;
import mx.unam.diplomado.agendafaces.vo.TipoContacto;

@Local
public interface IAgendaEJBLocal {

    List<Contacto> cargaContactos();

    Contacto cargaContacto(Integer id);

    List<TipoContacto> cargaTiposContacto();

    List<MedioContacto> cargaMediosContacto();

    void insertaContactoMedio(ContactoMedio contactoMedio);

    List<ContactoMedio> getContactoMediosPorContacto(Integer idContacto);

    ContactoMedio getContactoMedio(Integer id_contacto_medio);
    
    void actualizaContactoMedio(ContactoMedio contactoMedio);
    
    void borraContactoMedio(Integer id_contacto_medios);

}
