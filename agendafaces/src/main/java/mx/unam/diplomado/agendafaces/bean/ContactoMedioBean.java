/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.diplomado.agendafaces.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author unam
 */
@Named
@SessionScoped
public class ContactoMedioBean implements Serializable {
    
    private static final long serialVersionUID = -1146681490006848089L;
    private Integer id;
    private String valor;
    private Integer idContacto;
    private Integer idMedio;

    public ContactoMedioBean(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public ContactoMedioBean() {
    }

    public ContactoMedioBean(Integer id, String valor) {
        this.id = id;
        this.valor = valor;
    }

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
    
    public String addContactoMedio(){
        int i = 0;
        return "contacto";
    }
}
