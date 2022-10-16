package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class OdgovornaOsoba extends Osoba {

    private String email;
    private String rod;
    private String telefon;
    @ManyToOne
    private Dijete dijete;

    public Dijete getDijete() {
        return dijete;
    }

    public void setDijete(Dijete dijete) {
        this.dijete = dijete;
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

    public OdgovornaOsoba(String email, String rod, String telefon, Dijete dijete) {
        this.email = email;
        this.rod = rod;
        this.telefon = telefon;
        this.dijete = dijete;
    }

    public OdgovornaOsoba() {
    }

}
