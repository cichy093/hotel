package com.pz.Dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PokojeDto {

    private long id;
    private int numer;
    private long idTypPokoju;
    private boolean niedostepny;
    private String opis;
}
