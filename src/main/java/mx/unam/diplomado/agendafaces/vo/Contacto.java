package mx.unam.diplomado.agendafaces.vo;

import java.util.ArrayList;
import java.util.List;

public class Contacto {
    private Integer id;
    private String nombre;
    private String apellidos;
    private Integer edad;
    private String direccion;
    private List<ContactoMedio> medios;
    private TipoContacto tipoContacto;

    public Contacto() {
        medios = new ArrayList<>();
        tipoContacto = new TipoContacto();
    }

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

    public List<ContactoMedio> getMedios() {
        return medios;
    }

    public void setMedios(List<ContactoMedio> medios) {
        this.medios = medios;
    }

    public TipoContacto getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(TipoContacto tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

}
