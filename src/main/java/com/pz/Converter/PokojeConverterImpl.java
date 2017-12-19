package com.pz.Converter;

import com.pz.DataBase.Pokoje;
import com.pz.Dto.PokojeDto;
import org.springframework.stereotype.Component;

@Component
public class PokojeConverterImpl implements PokojeConverter {
    @Override
    public Pokoje convertToEntity(PokojeDto pokojeDto) {
        return Pokoje.builder()
                .numer(pokojeDto.getNumer())
                .idTypPokoju(pokojeDto.getIdTypPokoju())
                .niedostepny(pokojeDto.isNiedostepny())
                .opis(pokojeDto.getOpis())
                .build();
    }

    @Override
    public PokojeDto convertToDto(Pokoje pokoje) {
        return PokojeDto.builder()
                .numer(pokoje.getNumer())
                .idTypPokoju(pokoje.getIdTypPokoju())
                .niedostepny(pokoje.isNiedostepny())
                .opis(pokoje.getOpis())
                .build();
    }
}
