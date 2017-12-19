package com.pz.Converter;

import com.pz.DataBase.PokojeRezerwacje;
import com.pz.Dto.PokojeRezerwacjeDto;
import org.springframework.stereotype.Component;

@Component
public class PokojeRezerwacjeConverterImpl implements PokojeRezerwacjeConverter {
    @Override
    public PokojeRezerwacje convertToEntity(PokojeRezerwacjeDto pokojeRezerwacjeDto) {
        return PokojeRezerwacje.builder()
                .idKlienta(pokojeRezerwacjeDto.getIdKlienta())
                .idPokoju(pokojeRezerwacjeDto.getIdPokoju())
                .dataOd(pokojeRezerwacjeDto.getDataOd())
                .dataDo(pokojeRezerwacjeDto.getDataDo())
                .build();
    }

    @Override
    public PokojeRezerwacjeDto convertToDto(PokojeRezerwacje pokojeRezerwacje) {
        return PokojeRezerwacjeDto.builder()
                .idKlienta(pokojeRezerwacje.getIdKlienta())
                .idPokoju(pokojeRezerwacje.getIdPokoju())
                .dataOd(pokojeRezerwacje.getDataOd())
                .dataDo(pokojeRezerwacje.getDataDo())
                .build();
    }
}
