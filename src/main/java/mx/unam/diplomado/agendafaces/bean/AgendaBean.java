package mx.unam.diplomado.agendafaces.bean;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import mx.unam.diplomado.agendafaces.vo.Contacto;
import mx.unam.diplomado.agendafaces.vo.MedioContacto;
import mx.unam.diplomado.agendafaces.vo.TipoContacto;
import mx.unam.diplomado.ejb.IAgendaEJBLocal;

@Model
public class AgendaBean {

    @Produces
    @Model
    public List<Contacto> cargaContactos() {
        List<Contacto> contactos = null;
        IAgendaEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (IAgendaEJBLocal) ctx.lookup("java:global/agendafaces/AgendaEJB!mx.unam.diplomado.ejb.IAgendaEJBLocal");
            if (service != null) {
                contactos = service.cargaContactos();
            } else {
                contactos = new ArrayList();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contactos;
    }
    
    @Produces
    @Model
    public List<TipoContacto> cargaTiposContacto() {
        List<TipoContacto> tipoContactos = null;
        IAgendaEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (IAgendaEJBLocal) ctx.lookup("java:global/agendafaces/AgendaEJB!mx.unam.diplomado.ejb.IAgendaEJBLocal");
            if (service != null) {
                tipoContactos = service.cargaTiposContacto();
            } else {
                tipoContactos = new ArrayList();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tipoContactos;
    }
    
    @Produces
    @Model
    public List<MedioContacto> cargaMedioContacto() {
        List<MedioContacto> medioContactos = null;
        IAgendaEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (IAgendaEJBLocal) ctx.lookup("java:global/agendafaces/AgendaEJB!mx.unam.diplomado.ejb.IAgendaEJBLocal");
            if (service != null) {
                medioContactos = service.cargaMediosContacto();
            } else {
                medioContactos = new ArrayList();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return medioContactos;
    }

}
