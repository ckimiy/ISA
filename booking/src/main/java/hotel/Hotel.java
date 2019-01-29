package hotel;

import soba.Soba;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String naziv;
    private String adresa;
    private String opis;
    private String cenovnik;
    private List<Soba> konfiguracijaSoba;
    private int prosecnaOcena;
    private int prosecnaOcenaSoba;
    private int prihodi;

    public long getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getCenovnik() {
        return cenovnik;
    }

    public void setCenovnik(String cenovnik) {
        this.cenovnik = cenovnik;
    }

    public List<Soba> getKonfiguracijaSoba() {
        return konfiguracijaSoba;
    }

    public void setKonfiguracijaSoba(List<Soba> konfiguracijaSoba) {
        this.konfiguracijaSoba = konfiguracijaSoba;
    }

    public int getProsecnaOcena() {
        return prosecnaOcena;
    }

    public void setProsecnaOcena(int prosecnaOcena) {
        this.prosecnaOcena = prosecnaOcena;
    }

    public int getProsecnaOcenaSoba() {
        return prosecnaOcenaSoba;
    }

    public void setProsecnaOcenaSoba(int prosecnaOcenaSoba) {
        this.prosecnaOcenaSoba = prosecnaOcenaSoba;
    }

    public int getPrihodi() {
        return prihodi;
    }

    public void setPrihodi(int prihodi) {
        this.prihodi = prihodi;
    }
}

