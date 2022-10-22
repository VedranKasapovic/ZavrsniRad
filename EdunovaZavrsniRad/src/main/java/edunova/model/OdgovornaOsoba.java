package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.List;

@Entity
public class OdgovornaOsoba extends Osoba {

    private String email;
    private String rod;
    private String telefon;
    @ManyToOne
    private Dijete dijete;
    @ManyToMany 
    private List<Dijete> djeca;

    public List<Dijete> getDjeca() {
        return djeca;
    }

    public void setDjeca(List<Dijete> djeca) {
        this.djeca = djeca;
    }

    public Dijete getDijete() {
        return dijete;
    }

    public void setDijete(Dijete dijete) {
        this.dijete = dijete;
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

    public OdgovornaOsoba(String email, String rod, String telefon, List<Dijete> djeca) {
        this.email = email;
        this.rod = rod;
        this.telefon = telefon;
        this.djeca = djeca;
    }

    public OdgovornaOsoba() {
    }

}