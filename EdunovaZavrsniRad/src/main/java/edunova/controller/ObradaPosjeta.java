/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Dijete;
import edunova.model.OdgovornaOsoba;
import edunova.model.Posjeta;
import edunova.util.EdunovaException;
import edunova.util.Pomocno;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Veky
 */
public class ObradaPosjeta extends Obrada<Posjeta> {

    private List<Dijete> djeca;
    private List<OdgovornaOsoba> odgovorneOsobe;
    
    public void crate() throws EdunovaException {
        kontrolaCreate();
        session.beginTransaction();
        session.persist(entitet);
        for (OdgovornaOsoba os :odgovorneOsobe) {
            os.setDjeca((List<Dijete>) entitet);
            session.persist(os);
        }
        entitet.setOdgovornaOsoba((OdgovornaOsoba) odgovorneOsobe);
        session.getTransaction().commit();
    }

    @Override
    public List<Posjeta> read() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaOdgovornaOsoba();
        kontrolaPlaceno();
        kontrolaBrojOrmarica();

    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        kontrolaCreate();
        kontrolaVrijemeOdlaska();
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        if (null != entitet.getOdgovornaOsoba()) {
            throw new EdunovaException("Ne može se obrisati posjeta koja ima odgovornu osobu");
        }

    }

    @Override
    protected String getNazivEntiteta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void kontrolaOdgovornaOsoba() throws EdunovaException {
        if (entitet.getOdgovornaOsoba() == null) {
            throw new EdunovaException("Obavezno unijeti odgovornu osobu");
        }

    }

    private void kontrolaPlaceno() throws EdunovaException {
        if (entitet.isPlaceno() && entitet.isGratis()) {
            throw new EdunovaException("Ne može istovremeno biti odabrano plaćeno i gratis");
        }

    }

    private void kontrolaVrijemeOdlaska() throws EdunovaException {
        GregorianCalendar k = (GregorianCalendar) Calendar.getInstance();
        k.setTime(new Date());
        k.set(Calendar.HOUR, 0);
        k.set(Calendar.MINUTE, 0);
        k.set(Calendar.SECOND, 0);
        k.set(Calendar.MILLISECOND, 0);
        if (entitet.getVrijemeOdlaska().before(entitet.getVrijemeDolaska())) {
            throw new EdunovaException("Vrijeme odlaska mora biti nakon " + entitet.getVrijemeDolaska());
        }
    }

    private void kontrolaBrojOrmarica() throws EdunovaException {
        if (entitet.getOrmaric() != null
                && entitet.getOrmaric() > 0) {
            if (entitet.getOrmaric() > 50) {
                throw new EdunovaException("Upisat broj ormarića između 1 i 50");
            }

        }

    }

}
