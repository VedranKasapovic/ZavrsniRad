/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import com.github.javafaker.Faker;
import edunova.model.Dijete;
import edunova.model.Djelatnik;
import edunova.model.OdgovornaOsoba;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Veky
 */
public class PocetniInsert {
    
    private List<Dijete> djeca;
    private Session sess;
    private Faker faker;
    
    public PocetniInsert(){
        djeca = new ArrayList<>();
        sess.getTransaction().commit();
        faker = new Faker();
        sess.beginTransaction();
        kreirajDjecu(50);
        kreirajOdgovornuOsobu();
    }

//    public static void izvedi() {
////        Session s = HibernateUtil.getSession();
////        s.beginTransaction();
////
////        Faker f = new Faker();
////        OdgovornaOsoba odgovornaOsoba;
////        
////        for (int i = 0; i < 10; i++) {
////            odgovornaOsoba = new OdgovornaOsoba();
////            odgovornaOsoba.setIme(f.address().firstName());
////            odgovornaOsoba.setPrezime(f.address().lastName());
////            
////            s.persist(odgovornaOsoba);
////            
////        }
////        Dijete d;
////        for(int i=0; i<10;i++){
////            d= new Dijete();
////            d.setDatumRodjenja(f.date().birthday());
////            d.setIme(f.address().firstName());
////            d.setPrezime(f.address().lastName());
////           
////            s.persist(d);
////        }
////        s.getTransaction().commit();
////        kreirajDjelatnika();
//    }
//
//    private static void kreirajDjelatnika() {
//        Djelatnik d = new Djelatnik();
//        d.setIme("Marija");
//        d.setPrezime("Marić");
//        d.setLozinka("");
//        sess.persist(d);
//    }

    private void kreirajDjecu(int broj) {
        for (int i=0;i<broj;i++){
            djeca.add(kreirajDijete());
            
        }
        
        
    }

    private Dijete kreirajDijete() {
        Dijete d = new Dijete();
        d.setIme(faker.address().firstName());
        d.setPrezime(faker.address().lastName());
        d.setDatumRodjenja(faker.date().birthday(3, 13));
        sess.persist(d);
        return d;
    }

    private void kreirajOdgovornuOsobu(int broj) {
        for (int i=0;i<broj;i++){
           odgovorneOsobe.add(kreirajOdgovorneOsobe());        
        }
}

    private void kreirajOdgovorneOsobe() {
        OdgovornaOsoba os = new OdgovornaOsoba();
        os.setIme(faker.address().firstName());
        os.setPrezime(faker.address().lastName());
        os.setEmail(faker.internet().emailAddress());
        os.setTelefon(faker.phoneNumber().cellPhone().toString());
        sess.persist(os);
        return os;
    }
}
    
