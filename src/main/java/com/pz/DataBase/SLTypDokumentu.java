package com.pz.DataBase;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class SLTypDokumentu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nazwa;

    public SLTypDokumentu(String nazwa) {
        this.nazwa = nazwa;
    }

    public SLTypDokumentu() {
    }
}
