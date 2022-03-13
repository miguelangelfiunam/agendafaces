/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.diplomado.agendafaces.vo;

/**
 *
 * @author unam
 */
public class ContactoMedio {

    private Integer id_contacto_medio;
    private String valor;
    private Integer id_contacto;
    private Integer id_medio_contacto;

    public ContactoMedio() {
    }

    public ContactoMedio(Integer id_contacto_medio, String valor, Integer id_contacto, Integer id_medio_contacto) {
        this.id_contacto_medio = id_contacto_medio;
        this.valor = valor;
        this.id_contacto = id_contacto;
        this.id_medio_contacto = id_medio_contacto;
    }

    public Integer getId_contacto_medio() {
        return id_contacto_medio;
    }

    public void setId_contacto_medio(Integer id_contacto_medio) {
        this.id_contacto_medio = id_contacto_medio;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(Integer id_contacto) {
        this.id_contacto = id_contacto;
    }

    public Integer getId_medio_contacto() {
        return id_medio_contacto;
    }

    public void setId_medio_contacto(Integer id_medio_contacto) {
        this.id_medio_contacto = id_medio_contacto;
    }

}
