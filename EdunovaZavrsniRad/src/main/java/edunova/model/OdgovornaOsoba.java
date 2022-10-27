package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OdgovornaOsoba extends Osoba {

    private String email;
    private String rod;
    private String telefon;

    @ManyToMany 
    private List<Dijete> djeca = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRod() {
        return rod;
    }

    public void setRod(String rod) {
        this.rod = rod;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public List<Dijete> getDjeca() {
        return djeca;
    }

    public void setDjeca(List<Dijete> djeca) {
        this.djeca = djeca;
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

    public OdgovornaOsoba() {
        super();
    }

    public OdgovornaOsoba(Integer sifra, String ime, String prezime) {
        super(sifra, ime, prezime);
    }

    @Override
    public String toString(){
        return ime + " " + prezime;
    }
  

   
}