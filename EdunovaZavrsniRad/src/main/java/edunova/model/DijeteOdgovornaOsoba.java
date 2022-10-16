/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.model;

import jakarta.persistence.ManyToOne;

/**
 *
 * @author Veky
 */
public class DijeteOdgovornaOsoba extends Entitet {

    @ManyToOne
    private Dijete dijete;
    @ManyToOne
    private OdgovornaOsoba odgovornaOsoba;

    public DijeteOdgovornaOsoba() {
        super();
    }

    public DijeteOdgovornaOsoba(Dijete dijete, OdgovornaOsoba odgovornaOsoba, Integer sifra) {
        super(sifra);
        this.dijete = dijete;
        this.odgovornaOsoba = odgovornaOsoba;
    }

    
    
    public Dijete getDijete() {
        return dijete;
    }

    public void setDijete(Dijete dijete) {
        this.dijete = dijete;
    }

    public OdgovornaOsoba getOdgovornaOsoba() {
        return odgovornaOsoba;
    }

    public void setOdgovornaOsoba(OdgovornaOsoba odgovornaOsoba) {
        this.odgovornaOsoba = odgovornaOsoba;
    }

 

}
