package com.pz.Converter;

import com.pz.DataBase.PokojeZdjecia;
import com.pz.Dto.PokojeZdjeciaDto;
import org.springframework.stereotype.Component;

@Component
public class PokojeZdjeciaConverterImpl implements PokojeZdjeciaConverter {
    @Override
    public PokojeZdjecia convertToEntity(PokojeZdjeciaDto pokojeZdjeciaDto) {
        return PokojeZdjecia.builder()
                .id(pokojeZdjeciaDto.getId())
                .idPokoju(pokojeZdjeciaDto.getIdPokoju())
                .zdjecie(pokojeZdjeciaDto.getZdjecie())
                .build();
    }

    @Override
    public PokojeZdjeciaDto convertToDto(PokojeZdjecia pokojeZdjecia) {
        return PokojeZdjeciaDto.builder()
                .id(pokojeZdjecia.getId())
                .idPokoju(pokojeZdjecia.getIdPokoju())
                .zdjecie(pokojeZdjecia.getZdjecie())
                .build();
    }
}
