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
public class Klienci {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String imie;
    private String nazwisko;
    private String email;
    private int telefon;
    private String nrDokumentu;
    private long _idTypDokumentu;

    Klienci(String imie, String nazwisko, String email, int telefon, String nrDokumentu, long idTypDokumentu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.telefon = telefon;
        this.nrDokumentu = nrDokumentu;
        this._idTypDokumentu = idTypDokumentu;
    }

    public Klienci() {
    }

    public long getId() {
        return id;
    }

    ;



}
