package com.pz.Dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UzytkownicyDto {
    private long id;
    private String nazwaUzytkownika;
    private String haslo;
    private boolean czyAdmin;
}
