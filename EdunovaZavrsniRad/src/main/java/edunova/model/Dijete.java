package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Dijete extends Osoba {

    private Date datumRodjenja;

    @ManyToMany(mappedBy = "djeca")
    private List<OdgovornaOsoba> odgovorneOsobe ;

    public List<OdgovornaOsoba> getOdgovorneOsobe() {
        return odgovorneOsobe;
    }

    public void setOdgovorneOsobe(List<OdgovornaOsoba> odgovorneOsobe) {
        this.odgovorneOsobe = odgovorneOsobe;
    }
    
    public Dijete() {
    }

    public Dijete(Integer sifra, String ime, String prezime) {
        super(sifra, ime, prezime);
    }

    public Dijete(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Dijete(Date datumRodjenja, Integer sifra, String ime, String prezime) {
        super(sifra, ime, prezime);
        this.datumRodjenja = datumRodjenja;
    }

    
    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    


    @Override
    public String toString() {
        return ime + " " + prezime;
    }
}
