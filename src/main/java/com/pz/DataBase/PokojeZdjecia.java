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
public class PokojeZdjecia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long idPokoju;
    private String zdjecie; //ścieżka do zdjęcia

    public PokojeZdjecia(long idPokoju, String zdjecie) {
        this.idPokoju = idPokoju;
        this.zdjecie = zdjecie;
    }

    public PokojeZdjecia() {
    }

}
