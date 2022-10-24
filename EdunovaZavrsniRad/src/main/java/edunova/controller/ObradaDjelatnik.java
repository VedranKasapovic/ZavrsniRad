/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Djelatnik;
import edunova.model.Osoba;
import edunova.util.EdunovaException;
import jakarta.persistence.NoResultException;
import org.mindrot.jbcrypt.BCrypt;
import java.util.List;

/**
 *
 * @author Veky
 */
public class ObradaDjelatnik extends ObradaOsoba<Djelatnik> {

    public Djelatnik autoriziraj(String djelatnik, char[] lozinka) {
        Djelatnik d;
        try {
            //zadnji pokušaj prije predavanja
           d= session.createQuery("from Djelatnik d where "
                    + " lower(concat(d.ime,' ', d.prezime)) like :djelatnik", 
                Djelatnik.class)
                .setParameter("djelatnik", "%" + djelatnik.toLowerCase() + "%")
                    .setMaxResults(1)
                    .getSingleResult();

// baca grešku prazan entitet
            /*   d = session.createQuery("from Djelatnik d where d.getIme=:ime AND d.getPrezime=:prezime", Djelatnik.class)
                    .setParameter("ime"' '"prezime", Djelatnik
                    .getSingleResult();
             */
// treba popraviti. povlači samo za prvoga
//           d = session.createQuery("from Djelatnik", Djelatnik.class).setMaxResults(1).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

        if (BCrypt.checkpw(new String(lozinka), d.getLozinka())) {
            Djelatnik vrati = new Djelatnik();
            vrati.setLozinka(d.getLozinka());
            vrati.setIme(d.getIme());
            vrati.setPrezime(d.getPrezime());

            // ne postavljamo lozinku da ne bude u memoriji
            return vrati;
        }

        return null;
    }

    @Override
    public List<Djelatnik> read() {
        return session.createQuery("from Djelatnik", Djelatnik.class).list();
    }

    @Override
    protected String getNazivEntiteta() {
        return "Djelatnik";
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
