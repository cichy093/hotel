package com.pz.DataBase;

import com.pz.Converter.UzytkownicyConverter;
import com.pz.Dto.UzytkownicyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBMenager {

    private static DBMenager ourInstance = new DBMenager();

    public static DBMenager getInstance() {
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


    private DBMenager() {
    }


    public void submitUser(UzytkownicyDto uzytkownicyDto) {
        this.uzytkownicyRepository.save(this.uzytkownicyConverter.convertToEntity(uzytkownicyDto));
    }

}
