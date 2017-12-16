package com.pz.DataBase;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Marcin on 05.12.2017.
 */
@Entity
@Setter
@Getter
//@Builder
public class Pokoje {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int numer;
    private int idTypPokoju;
    private boolean niedostepny;
    private String opis;

    public Pokoje(int numer, int idTypPokoju, boolean niedostepny, String opis) {
        this.numer = numer;
        this.idTypPokoju = idTypPokoju;
        this.niedostepny = niedostepny;
        this.opis = opis;
    }

    //private Pokoje() {};

}
