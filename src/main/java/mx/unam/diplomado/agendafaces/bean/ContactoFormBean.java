package mx.unam.diplomado.agendafaces.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import mx.unam.diplomado.agendafaces.bean.MedioBean;
import mx.unam.diplomado.agendafaces.vo.Contacto;
import mx.unam.diplomado.agendafaces.vo.ContactoMedio;
import mx.unam.diplomado.ejb.IAgendaEJBLocal;

/**
 *
 * @author unam
 */
@Named
@SessionScoped
public class ContactoFormBean implements Serializable {

    private static final long serialVersionUID = -1146681490006848089L;
    private Integer id;
    private String nombre;
    private String apellidos;
    private Integer edad;
    private String direccion;
    private List<MedioBean> medios;
    private Integer tipoContacto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(Integer tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    public List<MedioBean> getMedios() {
        return medios;
    }

    public void setMedios(List<MedioBean> medios) {
        this.medios = medios;
    }

    public String actualizaContacto(Integer id) {
        Contacto contacto = null;
        IAgendaEJBLocal service = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (IAgendaEJBLocal) ctx.lookup("java:global/agendafaces/AgendaEJB!mx.unam.diplomado.ejb.IAgendaEJBLocal");
            if (service != null) {
                contacto = service.cargaContacto(id);
                this.id = contacto.getId();
                this.apellidos = contacto.getApellidos();
                this.direccion = contacto.getDireccion();
                this.edad = contacto.getEdad();
                this.tipoContacto = contacto.getTipoContacto().getId();
                this.nombre = contacto.getNombre();
                this.medios = new ArrayList<>();
//                contactoMedioBean = new ContactoMedioBean(id);
                for (ContactoMedio medio : contacto.getMedios()) {
                    MedioBean m = new MedioBean(medio.getId_medio_contacto(), medio.getValor());
                    this.medios.add(m);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "contacto";
    }

    public void addMedioContacto(String ejemplo) {
        MedioBean m = new MedioBean(0, "");
        this.medios.add(m);
    }

    public void removeMedioContacto(int key) {
        int i = 0;
        this.medios.remove(key);
        int j = 0;
    }

    public void actualizaIdMedioContacto(int index) {
//        for (MedioBean medio : medios) {
//            
//        }
//        this.medios.set(index, 0);
    }
}
