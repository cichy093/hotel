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
public class SLTypyPokoi {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String nazwa;

    public SLTypyPokoi(String nazwa) {
        this.nazwa = nazwa;
    }

    //private SLTypyPokoi() {};
}
