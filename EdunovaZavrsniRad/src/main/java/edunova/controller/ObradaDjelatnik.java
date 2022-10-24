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

    public Djelatnik autoriziraj(Integer sifra, char[] lozinka) {
        Djelatnik d;
        try {
            //zadnji pokušaj prije predavanja
           d= session.createQuery("from Djelatnik d where "
                    + " sifra=:sifra", 
                Djelatnik.class)
                .setParameter("sifra", sifra)
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
            vrati.setSifra(d.getSifra());
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
        List<Djelatnik> lista = new ArrayList<>();
        List<Djelatnik> izBaze = session.createQuery("from Djelatnik", Djelatnik.class).list();
        
        Djelatnik d;
        for(Djelatnik db : izBaze){
            d=new Djelatnik();
            d.setSifra(db.getSifra());
            d.setLozinka(db.getLozinka());
            d.setIme(db.getIme());
            d.setPrezime(db.getPrezime());
            lista.add(d);
        }
        
        return lista;
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
