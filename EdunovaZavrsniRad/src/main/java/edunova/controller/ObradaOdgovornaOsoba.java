/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.OdgovornaOsoba;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author Veky
 */
public class ObradaOdgovornaOsoba extends ObradaOsoba<OdgovornaOsoba> {

    @Override
    public List<OdgovornaOsoba> read() {
        return session.createQuery("from OdgovrnaOsoba", OdgovornaOsoba.class).list();
    }

    public List<OdgovornaOsoba> read(String uvjet) {
        return session.createQuery("from OdgovornaOsoba oo where "
                + " lower(concat(oo.ime,' ',oo.prezime)) like :uvjet", OdgovornaOsoba.class)
                .setParameter("uvjet", "%" + uvjet.toLowerCase() + "%")
                .list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaEmail();
        kontrolaBrojTelefona();

    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        kontrolaCreate();
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        kontrolaDeleteDjete();
    }

    @Override
    protected String getNazivEntiteta() {
        return "OdgovornaOsoba";
    }

    private void kontrolaIme() throws EdunovaException {
        kontrolaImeMoraBitiUneseno();
        kontrolaSamoSlovaIme();
    }

    private void kontrolaImeMoraBitiUneseno() throws EdunovaException {
        if (entitet.getIme() == null || entitet.getIme().trim().isEmpty()) {
            throw new EdunovaException("Ime obavezno");
        }

    }

    private void kontrolaPrezime() throws EdunovaException {
        kontrolaPrezimeMoraBitiUneseno();
        kontrolaSamoSlovaPrezime();
    }

    private void kontrolaPrezimeMoraBitiUneseno() throws EdunovaException {
        if (entitet.getPrezime() == null || entitet.getPrezime().trim().isEmpty()) {
            throw new EdunovaException("Prezime obavezno");
        }
    }

    private void kontrolaSamoSlovaIme() throws EdunovaException {
        if (!entitet.getIme().matches("\\p{L}+")) {
            throw new EdunovaException("Mora sadržavati samo slova!");
        }
    }

    private void kontrolaSamoSlovaPrezime() throws EdunovaException {
        if (!entitet.getPrezime().matches("\\p{L}+")) {
            throw new EdunovaException("Mora sadržavati samo slova!");
        }
    }

    private void kontrolaDeleteDjete() throws EdunovaException {
        if (entitet.getDjeca() != null && !entitet.getDjeca().isEmpty()) {
            throw new EdunovaException("Prvo uklonite dijecu sa popisa");
        }

    }

    private void kontrolaEmail() throws EdunovaException {
        kontrolaEmailMoraSadrzavatiAt();
    }

    private void kontrolaBrojTelefona() throws EdunovaException {
        kontrolaBrojTelefonaMoraSadržavatiSamoBrojeve();
    }

    private void kontrolaEmailMoraSadrzavatiAt() throws EdunovaException {
        if (entitet.getEmail() != null && !entitet.getEmail().trim().isEmpty()) {
            if (!entitet.getEmail().contains("@")) {
                throw new EdunovaException("Email mora obavezno sadržavati znak @");
            }
        }

    }

    private void kontrolaBrojTelefonaMoraSadržavatiSamoBrojeve() throws EdunovaException {
        if (!entitet.getTelefon().matches("[0-9]+") && entitet.getTelefon().length() < 6) {
            throw new EdunovaException("Telefon mora sadržavati samo brojeve i imati više od 6 znamenaka!");
        }
    }
}
