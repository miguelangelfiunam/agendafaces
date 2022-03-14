/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.diplomado.agendafaces.bean;

//import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.diplomado.agendafaces.vo.ContactoMedio;
import mx.unam.diplomado.ejb.IAgendaEJBLocal;

/**
 *
 * @author unam
 */
@Named
@SessionScoped
public class ContactoMedioBean implements Serializable {

    private static final long serialVersionUID = -1146681490006048089L;

    private List<ContactoMedio> listaContactosMedioBD;
    private int id_contacto;

    public ContactoMedioBean() {
    }

    public List<ContactoMedio> getListaContactosMedioBD() {
        return listaContactosMedioBD;
    }

    public void setListaContactosMedioBD(List<ContactoMedio> listaContactosMedioBD) {
        this.listaContactosMedioBD = listaContactosMedioBD;
    }

    public int getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(int id_contacto) {
        this.id_contacto = id_contacto;
    }

    public String editarContactosMedio(int idContacto) {
        IAgendaEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (IAgendaEJBLocal) ctx.lookup("java:global/agendafaces/AgendaEJB!mx.unam.diplomado.ejb.IAgendaEJBLocal");
            if (service != null) {
                listaContactosMedioBD = service.getContactoMediosPorContacto(idContacto);
                this.id_contacto = idContacto;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "contactomedio";
    }

    public String removeMedioContacto(int id_contacto_medio) {
        IAgendaEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (IAgendaEJBLocal) ctx.lookup("java:global/agendafaces/AgendaEJB!mx.unam.diplomado.ejb.IAgendaEJBLocal");
            if (service != null) {
                service.borraContactoMedio(id_contacto_medio);
                listaContactosMedioBD = service.getContactoMediosPorContacto(this.id_contacto);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "contactomedio";
    }

}
