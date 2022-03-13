/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.diplomado.agendafaces.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mx.unam.diplomado.agendafaces.vo.MedioContacto;

@Named
@SessionScoped
public class MedioContactoBean implements Serializable {

    private static final long serialVersionUID = -4146681490006848089L;
    private List<MedioContacto> mediosContactoList = new ArrayList<>();

    public void addMedioContacto() {
        mediosContactoList.add(new MedioContacto());
    }

    public void persistAddresses() {
        // store the addressList filled with addresses
    }

    public List<MedioContacto> getMediosContactoList() {
        return mediosContactoList;
    }

    public void setMediosContactoList(List<MedioContacto> mediosContactoList) {
        this.mediosContactoList = mediosContactoList;
    }
    
}
