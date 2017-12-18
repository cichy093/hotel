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
public class PokojeRezerwacje {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private long idKlienta;
    private long idPokoju;
    private String dataOd;
    private String dataDo;

    public PokojeRezerwacje(long idKlienta, long idPokoju, String dataOd, String dataDo) {
        this.idKlienta = idKlienta;
        this.idPokoju = idPokoju;
        this.dataOd = dataOd;
        this.dataDo = dataDo;
    }

    public PokojeRezerwacje() {
    }

    public long getId() {
        return id;
    }

    ;
}
