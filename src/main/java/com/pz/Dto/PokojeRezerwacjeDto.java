package com.pz.Dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PokojeRezerwacjeDto {

    private long id;
    private long idKlienta;
    private long idPokoju;
    private String dataOd;
    private String dataDo;
}
