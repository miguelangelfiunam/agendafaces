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

            List<ContactoMedio> contactoMedios = daoContactoMedio.getContactoMediosPorUsuario(contacto.getId());
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
    public void insertaContacto(Contacto contacto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contacto cargaContacto(Integer id) {
        daoAgenda = AgendaDAOJDBC.getInstance();
        daoTipoContacto = TipoContactoDAOJDBC.getInstance();
        daoContactoMedio = ContactoMedioDAOJDBC.getInstance();
        Contacto contacto = daoAgenda.cargaContacto(id);

        TipoContacto tipoContacto = daoTipoContacto.getTipoContactoUsuario(contacto.getId());
        contacto.setTipoContacto(tipoContacto);

        List<ContactoMedio> contactoMedios = daoContactoMedio.getContactoMediosPorUsuario(contacto.getId());
        contacto.setMedios(contactoMedios);

        return contacto;
    }

}
