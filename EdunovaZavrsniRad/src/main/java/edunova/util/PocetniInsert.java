/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import com.github.javafaker.Faker;
import edunova.model.Dijete;
import edunova.model.OdgovornaOsoba;
import org.hibernate.Session;

/**
 *
 * @author Veky
 */
public class PocetniInsert {

    public static void izvedi() {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();

        Faker f = new Faker();
        OdgovornaOsoba odgovornaOsoba;
        
        for (int i = 0; i < 10; i++) {
            odgovornaOsoba = new OdgovornaOsoba();
            odgovornaOsoba.setIme(f.address().firstName());
            odgovornaOsoba.setPrezime(f.address().lastName());
            
            s.persist(odgovornaOsoba);
        }
        Dijete d;
        for(int i=0; i<10;i++){
            d= new Dijete();
            d.setDatumRodjenja(f.date().birthday());
            d.setIme(f.address().firstName());
            d.setPrezime(f.address().lastName());
           
            s.persist(d);
        }
    }
}
