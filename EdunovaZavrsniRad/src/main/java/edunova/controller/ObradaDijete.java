/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Dijete;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author Veky
 */
public class ObradaDijete extends ObradaOsoba<Dijete> {

    @Override
    public List<Dijete> read() {

        return session.createQuery("from Dijete", Dijete.class).list();
    }

     public List<Dijete> read(String uvjet) {
        return session.createQuery("from Dijete d where "
                + " lower(concat(d.ime,' ', d.prezime)) like :uvjet", 
                Dijete.class)
                .setParameter("uvjet", "%" + uvjet.toLowerCase() + "%")
                .setMaxResults(10)
                .list();
    }
    
    @Override
    protected void kontrolaCreate() throws EdunovaException {
        super.kontrolaCreate();
        if (entitet == null) {
            throw new EdunovaException("Dijete nije konstruirano");
        }
        kontrolaNaziv();

    }

    private void kontrolaNaziv() throws EdunovaException {

        if (entitet.getIme() == null || entitet.getIme().isEmpty()) {
            throw new EdunovaException("Naziv djeteta obavezan");
        }
        if(entitet.getIme().length()>20){
            throw new EdunovaException("Ime dijeteta ne smije imati više od 20 znakova");
        }
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String getNazivEntiteta() {
        return "Dijete";
    }

}
