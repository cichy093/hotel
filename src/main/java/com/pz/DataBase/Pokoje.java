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
@NoArgsConstructor
@AllArgsConstructor
public class Pokoje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int numer;
    private long idTypPokoju;
    private boolean niedostepny;
    private String opis;

}
