package com.pz.Dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokojeZdjeciaDto {

    private long id;
    private long idPokoju;
    private String zdjecie;

}
