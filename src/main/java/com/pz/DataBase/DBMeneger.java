package com.pz.DataBase;

import com.pz.Converter.UzytkownicyConverter;
import com.pz.Dto.UzytkownicyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBMeneger {

    private static DBMeneger ourInstance = new DBMeneger();

    public static DBMeneger getInstance() {
        return ourInstance;
    }


    @Autowired
    private KlienciRepository klienciRepository;
    @Autowired
    private PokojeRezerwacjeRepository pokojeRezerwacjeRepository;
    @Autowired
    private PokojeRepository pokojeRepository;
    @Autowired
    private PokojeZdjeciaRepository pokojeZdjeciaRepository;
    @Autowired
    private SLTypyPokoiRepository slTypyPokoiRepository;
    @Autowired
    private SLTypDokumentuRepository slTypDokumentuRepository;
    @Autowired
    private UzytkownicyRepository uzytkownicyRepository;
    @Autowired
    private UzytkownicyConverter uzytkownicyConverter;
    @Autowired
    private DataBaseTest dataBaseTest;


    private DBMeneger() {
    }

    public Boolean submitUser(UzytkownicyDto uzytkownicyDto) {
        Uzytkownicy uzytkownicy;
        try {
            uzytkownicy = this.uzytkownicyConverter.convertToEntity(uzytkownicyDto);
            this.uzytkownicyRepository.save(uzytkownicy);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void loadTestData() {
        dataBaseTest.loadTestData();
    }

    public void printTestData() {
        dataBaseTest.printTestData();
    }

    public Boolean isUser(UzytkownicyDto uzytkownicyDto) {
        Boolean isUser = false;
        try {
            if (this.uzytkownicyRepository.exists(this.uzytkownicyRepository.findUzytkownicyByNazwaUzytkownikaAndHaslo(uzytkownicyDto.getNazwaUzytkownika(), uzytkownicyDto.getHaslo()).getId())) {
                isUser = true;
            }
        } catch (Exception ex) {
            isUser = false;
        }
        return isUser;
    }
}
