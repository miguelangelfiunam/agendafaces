/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.diplomado.agendafaces.bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import javax.naming.InitialContext;
import mx.unam.diplomado.agendafaces.vo.ContactoMedio;
import mx.unam.diplomado.ejb.IAgendaEJBLocal;

/**
 *
 * @author unam
 */
@Named
@RequestScoped
public class ContactoMedioFormBean implements Serializable {

    private static final long serialVersionUID = -1146681490006048089L;
    private Integer id = 0;
    private String valor;
    private Integer idContacto = 0;
    private Integer idMedio = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public Integer getIdMedio() {
        return idMedio;
    }

    public void setIdMedio(Integer idMedio) {
        this.idMedio = idMedio;
    }

    public String getContactosMedioPorUsuario(int idUsuario) {
        IAgendaEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (IAgendaEJBLocal) ctx.lookup("java:global/agendafaces/AgendaEJB!mx.unam.diplomado.ejb.IAgendaEJBLocal");
            if (service != null) {

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "contactomedio";
    }

    public String vistaInsertaContactoMedio(int id_contacto) {
        IAgendaEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (IAgendaEJBLocal) ctx.lookup("java:global/agendafaces/AgendaEJB!mx.unam.diplomado.ejb.IAgendaEJBLocal");
            if (service != null) {
                this.idContacto = id_contacto;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "contactomedioform";
    }

    public String cancelarEditarContactoMedio() {
        IAgendaEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (IAgendaEJBLocal) ctx.lookup("java:global/agendafaces/AgendaEJB!mx.unam.diplomado.ejb.IAgendaEJBLocal");
            if (service != null) {
                this.id = 0;
                this.idMedio = 0;
                this.valor = "";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "contactomedio";
    }

    public String editarContactoMedio(int id_contacto_medio) {
        IAgendaEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (IAgendaEJBLocal) ctx.lookup("java:global/agendafaces/AgendaEJB!mx.unam.diplomado.ejb.IAgendaEJBLocal");
            if (service != null) {
                ContactoMedio contactoMedio = service.getContactoMedio(id_contacto_medio);
                this.id = id_contacto_medio;
                this.idContacto = contactoMedio.getId_contacto();
                this.idMedio = contactoMedio.getId_medio_contacto();
                this.valor = contactoMedio.getValor();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "contactomedioform";
    }

    public String insertaContactoMedio() {
        IAgendaEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (IAgendaEJBLocal) ctx.lookup("java:global/agendafaces/AgendaEJB!mx.unam.diplomado.ejb.IAgendaEJBLocal");
            if (service != null) {
                service.insertaContactoMedio(new ContactoMedio(0, valor, idContacto, idMedio));
                valor = "";
                idMedio = 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "contactomedio";
    }

    public String actualizaContactoMedio() {
        IAgendaEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (IAgendaEJBLocal) ctx.lookup("java:global/agendafaces/AgendaEJB!mx.unam.diplomado.ejb.IAgendaEJBLocal");
            if (service != null) {
                service.actualizaContactoMedio(new ContactoMedio(id, valor, idContacto, idMedio));
                this.id = 0;
                this.valor = "";
                this.idMedio = 0;
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
                this.id = 0;
                this.idMedio = 0;
                this.valor = "";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "contactomedio";
    }

}
