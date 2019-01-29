package soba;

import javax.persistence.*;

@Entity
@Table(name = "Soba")
public class Soba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int cena_nocenja;
    private String dodatne_usluge;
    private String popust;

    public long getId() {
        return id;
    }

    public int getCena_nocenja() {
        return cena_nocenja;
    }

    public void setCena_nocenja(int cena_nocenja) {
        this.cena_nocenja = cena_nocenja;
    }

    public String getDodatne_usluge() {
        return dodatne_usluge;
    }

    public void setDodatne_usluge(String dodatne_usluge) {
        this.dodatne_usluge = dodatne_usluge;
    }

    public String getPopust() {
        return popust;
    }

    public void setPopust(String popust) {
        this.popust = popust;
    }
}
