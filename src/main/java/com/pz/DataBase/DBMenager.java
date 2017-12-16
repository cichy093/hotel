package com.pz.DataBase;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Marcin on 07.12.2017.
 */
public class DBMenager {
    private static DBMenager ourInstance = new DBMenager();

    public static DBMenager getInstance() {
        return ourInstance;
    }

    /*@Autowired
    private KlienciRepository klienciRepository;
    @Autowired
    private PokojeRezerwacjeRepository pokojeRezerwacjeRepository;
    @Autowired
    private PokojeRepository pokojeRepository;
    @Autowired
    private PokojeZdjeciaRepository pokojeZdjeciaRepository;
    @Autowired
    SLTypyPokoiRepository slTypyPokoiRepository;
    @Autowired
    SLTypDokumentuRepository slTypDokumentuRepository;*/

    private DBMenager() {

    }
}
