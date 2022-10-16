package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Posjeta extends Entitet {

    private Boolean gratis;
    private Boolean placeno;
    private Boolean roditeljskaPratnja;
    private Date vrijemeDolaska;
    private Date vrijemeOdlaska;
    private Integer ormaric;
    @OneToOne
    private OdgovornaOsoba odgovornaOsoba;
    @ManyToMany
    private List<Dijete> djeca = new ArrayList<>();

    public Boolean isGratis() {
        return gratis;
    }

    public void setGratis(Boolean gratis) {
        this.gratis = gratis;
    }

    public Boolean isPlaceno() {
        return placeno;
    }

    public void setPlaceno(Boolean placeno) {
        this.placeno = placeno;
    }

    public Boolean isRoditeljskaPratnja() {
        return roditeljskaPratnja;
    }

    public void setRoditeljskaPratnja(Boolean roditeljskaPratnja) {
        this.roditeljskaPratnja = roditeljskaPratnja;
    }

    public Date getVrijemeDolaska() {
        return vrijemeDolaska;
    }

    public void setVrijemeDolaska(Date vrijemeDolaska) {
        this.vrijemeDolaska = vrijemeDolaska;
    }

    public Date getVrijemeOdlaska() {
        return vrijemeOdlaska;
    }

    public void setVrijemeOdlaska(Date vrijemeOdlaska) {
        this.vrijemeOdlaska = vrijemeOdlaska;
    }

    public OdgovornaOsoba getOdgovornaOsoba() {
        return odgovornaOsoba;
    }

    public void setOdgovornaOsoba(OdgovornaOsoba odgovornaOsoba) {
        this.odgovornaOsoba = odgovornaOsoba;
    }

    public List<Dijete> getDjeca() {
        return djeca;
    }

    public void setDjeca(List<Dijete> djeca) {
        this.djeca = djeca;
    }

    public Integer getOrmaric() {
        return ormaric;
    }

    public void setOrmaric(Integer ormaric) {
        this.ormaric = ormaric;
    }

    public Posjeta() {
    }

    public Posjeta(Boolean gratis, Boolean placeno, Boolean roditeljskaPratnja, Date vrijemeDolaska, Date vrijemeOdlaska, Integer ormaric, OdgovornaOsoba odgovornaOsoba) {
        super();
        this.gratis = gratis;
        this.placeno = placeno;
        this.roditeljskaPratnja = roditeljskaPratnja;
        this.vrijemeDolaska = vrijemeDolaska;
        this.vrijemeOdlaska = vrijemeOdlaska;
        this.ormaric = ormaric;
        this.odgovornaOsoba = odgovornaOsoba;
    }

}
