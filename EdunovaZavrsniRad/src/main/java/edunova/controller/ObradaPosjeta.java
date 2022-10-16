/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Posjeta;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author Veky
 */
public class ObradaPosjeta extends Obrada<Posjeta> {

    @Override
    public List<Posjeta> read() {
        return session.createQuery("from Posjeta", Posjeta.class).list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
       
        kotrolaOdgovornaOsoba();

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

    private void kotrolaOdgovornaOsoba() throws EdunovaException {
        if (entitet.getOdgovornaOsoba() == null) {
            throw new EdunovaException("Obavezno unijeti odgovornu osobu");
        }
    }

}
