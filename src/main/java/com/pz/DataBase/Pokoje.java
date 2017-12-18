package com.pz.DataBase;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Setter
@Getter
//@Builder
public class Pokoje {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private int numer;
    private long idTypPokoju;
    private boolean niedostepny;
    private String opis;

    public Pokoje(int numer, long idTypPokoju, boolean niedostepny, String opis) {
        this.numer = numer;
        this.idTypPokoju = idTypPokoju;
        this.niedostepny = niedostepny;
        this.opis = opis;
    }

    public Pokoje() {
    }

    public long getId() {
        return id;
    }

    ;

}
