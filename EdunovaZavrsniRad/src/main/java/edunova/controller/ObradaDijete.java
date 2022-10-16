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
public class ObradaDijete extends Obrada<Dijete> {

    @Override
    public List<Dijete> read() {

        return session.createQuery("from Dijete", Dijete.class).list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
