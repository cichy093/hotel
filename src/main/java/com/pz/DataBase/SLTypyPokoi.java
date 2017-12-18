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
public class SLTypyPokoi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nazwa;

    public SLTypyPokoi(String nazwa) {
        this.nazwa = nazwa;
    }

    public SLTypyPokoi() {
    }

}
