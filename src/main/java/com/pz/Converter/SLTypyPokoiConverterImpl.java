package com.pz.Converter;

import com.pz.DataBase.SLTypyPokoi;
import com.pz.Dto.SLTypyPokoiDto;
import org.springframework.stereotype.Component;

@Component
public class SLTypyPokoiConverterImpl implements SLTypyPokoiConverter{
    @Override
    public SLTypyPokoi convertToEntity(SLTypyPokoiDto slTypyPokoiDto) {
        return SLTypyPokoi.builder()
                .id(slTypyPokoiDto.getId())
                .nazwa(slTypyPokoiDto.getNazwa())
                .build();
    }

    @Override
    public SLTypyPokoiDto convertToDto(SLTypyPokoi slTypyPokoi) {
        return SLTypyPokoiDto.builder()
                .id(slTypyPokoi.getId())
                .nazwa(slTypyPokoi.getNazwa())
                .build();
    }
}
