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
public class PokojeRezerwacje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long idKlienta;
    private long idPokoju;
    private String dataOd;
    private String dataDo;

}
