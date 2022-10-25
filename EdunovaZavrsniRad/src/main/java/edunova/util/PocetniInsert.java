/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import com.github.javafaker.Faker;
import edunova.model.Dijete;
import edunova.model.Djelatnik;
import edunova.model.OdgovornaOsoba;
import edunova.model.Osoba;
import edunova.model.Posjeta;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Veky
 */
public class PocetniInsert {

    private List<Dijete> djeca;
    private List<Djelatnik> djelatnici;
    private List<OdgovornaOsoba> odgovorneOsobe;
    private List<Posjeta> posjete;
    private List<Osoba> osobe;
    private Session sess;
    private Faker faker;

    public PocetniInsert() {
        djeca = new ArrayList<>();
        djelatnici = new ArrayList<>();
        odgovorneOsobe = new ArrayList<>();
        osobe = new ArrayList<>();

        sess = HibernateUtil.getSession();
        faker = new Faker();
        sess.beginTransaction();
        kreirajDjecu(10);
        kreirajOdgovorneOsobe(20);
        kreirajAdministratora();
        kreirajDjelatnika1();
        kreirajDjelatnika2();
        kreirajDjelatnika3();
        kreirajPosjete(2);
        sess.getTransaction().commit();

    }

    private void kreirajDjelatnika1() {
        Djelatnik d = new Djelatnik();
        d.setIme("Marija");
        d.setPrezime("Marić");
        d.setLozinka(BCrypt.hashpw("m", BCrypt.gensalt()));
        d.setAktivan(true);
        sess.persist(d);
    }

    private void kreirajDjelatnika2() {
        Djelatnik d = new Djelatnik();
        d.setIme("Ana");
        d.setPrezime("Anić");
        d.setLozinka(BCrypt.hashpw("a", BCrypt.gensalt()));
        d.setAktivan(true);
        sess.persist(d);
    }

    private void kreirajDjelatnika3() {
        Djelatnik d = new Djelatnik();
        d.setIme("Ivana");
        d.setPrezime("Ivić");
        d.setLozinka(BCrypt.hashpw("i", BCrypt.gensalt()));
        d.setAktivan(false);
        sess.persist(d);
    }
private void kreirajAdministratora(){
        Djelatnik d = new Djelatnik();
        d.setIme("Admin");
        d.setPrezime("Administrator");
        d.setLozinka(BCrypt.hashpw("admin", BCrypt.gensalt()));
        d.setAktivan(true);
        sess.persist(d);
}

private void kreirajDjecu(int broj) {
        for (int i = 0; i < broj; i++) {
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

    private void kreirajOdgovorneOsobe(int broj) {
        for (int i = 0; i < broj; i++) {
            odgovorneOsobe.add(kreirajOdgovornuOsobu());

        }
    }

    private OdgovornaOsoba kreirajOdgovornuOsobu() {
        OdgovornaOsoba os = new OdgovornaOsoba();
        os.setIme(faker.address().firstName());
        os.setPrezime(faker.address().lastName());
        os.setEmail(faker.internet().emailAddress());
        os.getDjeca().add(djeca.get(1));
        os.getDjeca().add(djeca.get(3));
        os.getDjeca().add(djeca.get(6));
        sess.persist(os);
        return os;
    }

    private void kreirajPosjete(int broj) {
        for (int i = 0; i < broj; i++) {
            kreirajPosjetu(broj);

        }
    }

    private void kreirajPosjetu(int i) {
        Posjeta p = new Posjeta();
        if (i % 2 == 1) {
            p.setOdgovornaOsoba(odgovorneOsobe.get(i - 1));
        } else {
            p.setOdgovornaOsoba(odgovorneOsobe.get(i));
        }
        
            
            
            
       
        
        

        sess.persist(p);

    }

}
