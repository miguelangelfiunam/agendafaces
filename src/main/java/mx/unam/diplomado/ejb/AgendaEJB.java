package mx.unam.diplomado.ejb;

import java.util.List;
import jakarta.ejb.Stateless;
import mx.unam.diplomado.agenda.dao.AgendaDAOJDBC;
import mx.unam.diplomado.agenda.dao.ContactoMedioDAOJDBC;
import mx.unam.diplomado.agenda.dao.interfaces.IAgendaDAO;
import mx.unam.diplomado.agenda.dao.interfaces.IContactoMedioDAO;
import mx.unam.diplomado.agenda.dao.interfaces.IMedioContactoDAO;
import mx.unam.diplomado.agenda.dao.interfaces.ITipoContactoDAO;
import mx.unam.diplomado.agenda.dao.MedioContactoDAOJDBC;
import mx.unam.diplomado.agenda.dao.TipoContactoDAOJDBC;
import mx.unam.diplomado.agendafaces.vo.Contacto;
import mx.unam.diplomado.agendafaces.vo.ContactoMedio;
import mx.unam.diplomado.agendafaces.vo.MedioContacto;
import mx.unam.diplomado.agendafaces.vo.TipoContacto;

/**
 * Session Bean implementation class AgendaEJB
 */
@Stateless
public class AgendaEJB implements IAgendaEJBLocal {

    private IAgendaDAO daoAgenda;
    private ITipoContactoDAO daoTipoContacto;
    private IMedioContactoDAO daoMedioContacto;
    private IContactoMedioDAO daoContactoMedio;

    public List<Contacto> cargaContactos() {
        daoAgenda = AgendaDAOJDBC.getInstance();
        daoTipoContacto = TipoContactoDAOJDBC.getInstance();
        daoContactoMedio = ContactoMedioDAOJDBC.getInstance();
        List<Contacto> contactos = daoAgenda.cargaContactos();
        for (Contacto contacto : contactos) {
            TipoContacto tipoContacto = daoTipoContacto.getTipoContactoUsuario(contacto.getId());
            contacto.setTipoContacto(tipoContacto);

            List<ContactoMedio> contactoMedios = daoContactoMedio.getContactoMediosPorContacto(contacto.getId());
            contacto.setMedios(contactoMedios);
        }
        return contactos;
    }

    @Override
    public List<TipoContacto> cargaTiposContacto() {
        daoTipoContacto = TipoContactoDAOJDBC.getInstance();
        return daoTipoContacto.cargaTiposContacto();
    }

    @Override
    public List<MedioContacto> cargaMediosContacto() {
        daoMedioContacto = MedioContactoDAOJDBC.getInstance();
        return daoMedioContacto.cargaMediosContacto();
    }

    @Override
    public Contacto cargaContacto(Integer id) {
        daoAgenda = AgendaDAOJDBC.getInstance();
        daoTipoContacto = TipoContactoDAOJDBC.getInstance();
        daoContactoMedio = ContactoMedioDAOJDBC.getInstance();
        Contacto contacto = daoAgenda.cargaContacto(id);

        TipoContacto tipoContacto = daoTipoContacto.getTipoContactoUsuario(contacto.getId());
        contacto.setTipoContacto(tipoContacto);

        List<ContactoMedio> contactoMedios = daoContactoMedio.getContactoMediosPorContacto(contacto.getId());
        contacto.setMedios(contactoMedios);

        return contacto;
    }

    @Override
    public void insertaContactoMedio(ContactoMedio contactoMedio) {
        daoContactoMedio = ContactoMedioDAOJDBC.getInstance();
        daoContactoMedio.insertaContactoMedio(contactoMedio);
    }

    @Override
    public List<ContactoMedio> getContactoMediosPorContacto(Integer id_contacto) {
        daoContactoMedio = ContactoMedioDAOJDBC.getInstance();
        return daoContactoMedio.getContactoMediosPorContacto(id_contacto);
    }

    @Override
    public ContactoMedio getContactoMedio(Integer id_contacto_medio) {
        daoContactoMedio = ContactoMedioDAOJDBC.getInstance();
        return daoContactoMedio.getContactoMedio(id_contacto_medio);
    }

    @Override
    public void actualizaContactoMedio(ContactoMedio contactoMedio) {
        daoContactoMedio = ContactoMedioDAOJDBC.getInstance();
        daoContactoMedio.actualizaContactoMedio(contactoMedio);
    }

    @Override
    public void borraContactoMedio(Integer id_contacto_medios) {
        daoContactoMedio = ContactoMedioDAOJDBC.getInstance();
        daoContactoMedio.borraContactoMedio(id_contacto_medios);
    }

}
