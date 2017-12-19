package com.pz.DataBase;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Uzytkownicy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nazwaUzytkownika;
    private String haslo;
    private boolean czyAdmin;
}
