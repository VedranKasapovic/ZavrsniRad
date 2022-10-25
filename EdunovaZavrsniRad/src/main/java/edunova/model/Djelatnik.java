/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

/**
 *
 * @author Veky
 */
@Entity
public class Djelatnik extends Osoba{
    
    
    private String lozinka;
    private Boolean aktivan;
    
    @OneToMany
    private List<Djelatnik> djelatnici;

    public List<Djelatnik> getDjelatnici() {
        return djelatnici;
    }

    public void setDjelatnici(List<Djelatnik> djelatnici) {
        this.djelatnici = djelatnici;
    }
    

    public Boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }
    
    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

}
