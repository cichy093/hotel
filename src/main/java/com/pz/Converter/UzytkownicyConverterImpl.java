package com.pz.Converter;


import com.pz.DataBase.Uzytkownicy;
import com.pz.Dto.UzytkownicyDto;

public class UzytkownicyConverterImpl implements UzytkownicyConverter {

    @Override
    public Uzytkownicy convertToEntity(UzytkownicyDto uzytkownicyDto) {
        return Uzytkownicy.builder()
                .id(uzytkownicyDto.getId())
                .nazwaUzytkownika(uzytkownicyDto.getNazwaUzytkownika())
                .haslo(uzytkownicyDto.getHaslo())
                .build();
    }

    @Override
    public UzytkownicyDto convertToDto(Uzytkownicy uzytkownicy) {
        return UzytkownicyDto.builder()
                .id(uzytkownicy.getId())
                .nazwaUzytkownika(uzytkownicy.getNazwaUzytkownika())
                .haslo(uzytkownicy.getHaslo())
                .build();
    }
}
