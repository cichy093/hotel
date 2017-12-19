package com.pz.Converter;

import com.pz.DataBase.SLTypDokumentu;
import com.pz.Dto.SLTypDokumentuDto;
import org.springframework.stereotype.Component;

@Component
public class SLTypDokumentuConverterImpl implements SLTypDokumentuConverter {
    @Override
    public SLTypDokumentu convertToEntity(SLTypDokumentuDto slTypDokumentuDto) {

        return SLTypDokumentu.builder()
                .id(slTypDokumentuDto.getId())
                .nazwa(slTypDokumentuDto.getNazwa())
                .build();
    }

    @Override
    public SLTypDokumentuDto convertToDto(SLTypDokumentu slTypDokumentu) {

        return SLTypDokumentuDto.builder()
                .id(slTypDokumentu.getId())
                .nazwa(slTypDokumentu.getNazwa())
                .build();
    }
}
