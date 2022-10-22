package edunova.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Osoba extends Entitet {

    public String ime;
    public String prezime;

    public Osoba() {
        super();
    }

    public Osoba(Integer sifra, String ime, String prezime) {
        super(sifra);
        this.ime = ime;
        this.prezime = prezime;

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
        return ime +" "+ prezime;
    }

}
