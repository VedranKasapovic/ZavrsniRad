/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Dijete;
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
        kontrolaDatumRodjenja();
    }

    private void kontrolaNaziv() throws EdunovaException {

        if (entitet.getIme() == null || entitet.getIme().isEmpty()) {
            throw new EdunovaException("Ime djeteta obavezno");
        }
        if (entitet.getIme().length() > 20) {
            throw new EdunovaException("Ime dijeteta ne smije imati više od 20 znakova");
        }
        if (entitet.getPrezime() == null || entitet.getPrezime().isEmpty()) {
            throw new EdunovaException("Prezime djeteta obavezno");
        }
       
            
        
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        kontrolaCreate();
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        if (entitet.getOdgovorneOsobe() != null && !entitet.getOdgovorneOsobe().isEmpty()) {
            throw new EdunovaException("Dijete je dodano odgovornoj osobi");

        }
    }

    @Override
    protected String getNazivEntiteta() {
        return "Dijete";
    }

    private void kontrolaDatumRodjenja() throws EdunovaException {
        kontrolaDatumRodjenjaObavezno();
        kontrolaDatumRodjenjaVeciOdDanas();
    }

    private void kontrolaDatumRodjenjaObavezno() throws EdunovaException {
        if (entitet.getDatumRodjenja() == null) {
            throw new EdunovaException("Datum rođenja obavezan. npr "
                    + Pomocno.getPrimjerDatuma());
        }
    }

    private void kontrolaDatumRodjenjaVeciOdDanas() throws EdunovaException {
GregorianCalendar k = (GregorianCalendar) Calendar.getInstance();
        k.setTime(new Date());
        k.set(Calendar.HOUR, 0);
        k.set(Calendar.MINUTE, 0);
        k.set(Calendar.SECOND, 0);
        k.set(Calendar.MILLISECOND, 0);
        if (entitet.getDatumRodjenja().after(k.getTime())) {
            throw new EdunovaException("Datum rođenja ne može biti poslije danas "
                    + Pomocno.getPrimjerDatuma());
        }    }

}
