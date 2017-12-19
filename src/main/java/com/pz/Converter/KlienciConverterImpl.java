package com.pz.Converter;

import com.pz.DataBase.Klienci;
import com.pz.Dto.KlienciDto;
import org.springframework.stereotype.Component;

@Component
public class KlienciConverterImpl implements KlienciConverter {
    @Override
    public Klienci convertToEntity(KlienciDto klienciDto) {
        return Klienci.builder()
                .imie(klienciDto.getImie())
                .nazwisko(klienciDto.getNazwisko())
                .email(klienciDto.getEmail())
                .telefon(klienciDto.getTelefon())
                .nrDokumentu(klienciDto.getNrDokumentu())
                ._idTypDokumentu(klienciDto.get_idTypDokumentu())
                .build();
    }

    @Override
    public KlienciDto convertToDto(Klienci klienci) {
        return KlienciDto.builder()
                .imie(klienci.getImie())
                .nazwisko(klienci.getNazwisko())
                .email(klienci.getEmail())
                .telefon(klienci.getTelefon())
                .nrDokumentu(klienci.getNrDokumentu())
                ._idTypDokumentu(klienci.get_idTypDokumentu())
                .build();
    }
}
