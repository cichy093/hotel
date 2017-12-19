package com.pz.Dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KlienciDto {

    private long id;
    private String imie;
    private String nazwisko;
    private String email;
    private int telefon;
    private String nrDokumentu;
    private long _idTypDokumentu;
}
