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

    @Override
    public List<Posjeta> read() {
        return session.createQuery("from Posjeta", Posjeta.class).list();

    }

    public Posjeta readOne(Integer sifraPosjeta) {
        return session.get(Posjeta.class, sifraPosjeta);
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaOdgovornaOsoba();
        kontrolaPlaceno();
        kontrolaBrojOrmarica();
        kontrolaDijeteNaListi();

    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        kontrolaCreate();
        kontrolaVrijemeOdlaska();
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
       

    }

    @Override
    protected String getNazivEntiteta() {

        return "Posjeta";
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
        if (!entitet.getOrmaric().toString().matches("[0-9]+") && entitet.getOrmaric() != null) {
            try {
                
            } catch (Exception e) {
            }
 throw new EdunovaException("Upisati samo brojčanu vrijednost ormarića!");
        }
        if (entitet.getOrmaric() != null
                && entitet.getOrmaric() > 0) {
            if (entitet.getOrmaric() > 50) {
                throw new EdunovaException("Upisat broj ormarića između 1 i 50");
            }

        }

    }

    private void kontrolaDijeteNaListi() throws EdunovaException{
if (entitet.getDjeca().isEmpty() || entitet.getDjeca() ==null) {
            throw new EdunovaException("Obavezno dodati dijete!");
}

    }
}
