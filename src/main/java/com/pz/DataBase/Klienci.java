package com.pz.DataBase;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Klienci {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String imie;
    private String nazwisko;
    private String email;
    private int telefon;
    private String nrDokumentu;
    private long _idTypDokumentu;

}
