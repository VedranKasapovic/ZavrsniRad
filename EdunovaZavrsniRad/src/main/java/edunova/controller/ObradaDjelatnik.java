/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Djelatnik;
import edunova.model.Osoba;
import edunova.util.EdunovaException;
import jakarta.persistence.NoResultException;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;
import java.util.List;

/**
 *
 * @author Veky
 */
public class ObradaDjelatnik extends ObradaOsoba<Djelatnik> {

    private List<Djelatnik> noviDjelatnici;

    public Djelatnik autoriziraj(Integer sifra, char[] lozinka) {
        Djelatnik d;
        try {

            d = session.createQuery("from Djelatnik d where "
                    + " d.sifra=:sifra and d.aktivan=true",
                    Djelatnik.class)
                    .setParameter("sifra", sifra)
                    .getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

        if (BCrypt.checkpw(new String(lozinka), d.getLozinka())) {
            Djelatnik vrati = new Djelatnik();
            vrati.setSifra(d.getSifra());
            vrati.setLozinka(d.getLozinka());
            vrati.setIme(d.getIme());
            vrati.setPrezime(d.getPrezime());
            vrati.setAktivan(d.isAktivan());

            // ne postavljamo lozinku da ne bude u memoriji
            return vrati;
        }

        return null;
    }

    @Override
    public List<Djelatnik> read() {
        List<Djelatnik> lista = new ArrayList<>();
        List<Djelatnik> izBaze = session.createQuery("from Djelatnik", Djelatnik.class).list();

        Djelatnik d;
        for (Djelatnik db : izBaze) {
            d = new Djelatnik();
            d.setSifra(db.getSifra());
            d.setLozinka(db.getLozinka());
            d.setIme(db.getIme());
            d.setPrezime(db.getPrezime());
            d.setAktivan(db.isAktivan());
            lista.add(d);
        }

        return lista;
    }
   
    @Override
    protected String getNazivEntiteta() {
        return "Djelatnik";
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        super.kontrolaCreate();
        kontrolaIme();
        kontrolaPrezime();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        kontrolaCreate();
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }

    private void kontrolaIme() throws EdunovaException {
        kontrolaImeMoraBitiUneseno();
    }

    private void kontrolaImeMoraBitiUneseno() throws EdunovaException {
        if (entitet.getIme() == null || entitet.getIme().trim().isEmpty()) {
            throw new EdunovaException("Ime obavezno");
        }
    }

    private void kontrolaPrezime() throws EdunovaException {
        kontrolaPrezimeMoraBitiUneseno();
    }

    private void kontrolaPrezimeMoraBitiUneseno() throws EdunovaException {
        if (entitet.getPrezime() == null || entitet.getPrezime().trim().isEmpty()) {
            throw new EdunovaException("Prezime obavezno");
        }
    }

}
