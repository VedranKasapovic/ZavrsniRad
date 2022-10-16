/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Osoba;
import edunova.util.EdunovaException;

/**
 *
 * @author Veky
 */
public abstract class ObradaOsoba<T extends Osoba> extends Obrada<T> {

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        //implementirajte kontrolu ime obavezno
        kontrolaIme();
        kontrolaPrezime();
    }

    private void kontrolaIme() throws EdunovaException {
        kontrolaImeMoraBitiUneseno();
    }

    private void kontrolaPrezime() throws EdunovaException {
        kontrolaPrezimeMoraBitiUneseno();
    }

    private void kontrolaImeMoraBitiUneseno() throws EdunovaException {

        if (entitet.getIme() == null || entitet.getIme().trim().isEmpty()) {
            throw new EdunovaException("Ime obavezno");
        }
    }

    private void kontrolaPrezimeMoraBitiUneseno() throws EdunovaException {

        if (entitet.getPrezime() == null || entitet.getPrezime().trim().isEmpty()) {
            throw new EdunovaException("Prezime obavezno");
        }
    }

}
