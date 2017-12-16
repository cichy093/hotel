package com.pz.DataBase;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Marcin on 08.12.2017.
 */
public class DataBaseTest {
    @Autowired
    private KlienciRepository klienciTabela;
    @Autowired
    private PokojeRepository pokojeTabela;
    @Autowired
    private PokojeRezerwacjeRepository pokojeRezerwacjeTabela;
    @Autowired
    private PokojeZdjeciaRepository pokojeZdjeciaTabela;
    @Autowired
    private SLTypDokumentuRepository slTypDokumentuTabela;
    @Autowired
    private SLTypyPokoiRepository slTypyPokoiTabela;

    public DataBaseTest(/*KlienciRepository klienciTabela, PokojeRepository pokojeTabela, PokojeRezerwacjeRepository pokojeRezerwacjeTabela, PokojeZdjeciaRepository pokojeZdjeciaTabela, SLTypDokumentuRepository slTypDokumentuTabela, SLTypyPokoiRepository slTypyPokoiTabela*/) {
        /*this.klienciTabela = klienciTabela;
        this.pokojeTabela = pokojeTabela;
        this.pokojeRezerwacjeTabela = pokojeRezerwacjeTabela;
        this.pokojeZdjeciaTabela = pokojeZdjeciaTabela;
        this.slTypDokumentuTabela = slTypDokumentuTabela;
        this.slTypyPokoiTabela = slTypyPokoiTabela;*/
    }

    public void loadTestData() {
        this.klienciTabela.deleteAll();
        this.pokojeTabela.deleteAll();
        this.pokojeRezerwacjeTabela.deleteAll();
        this.pokojeZdjeciaTabela.deleteAll();
        this.slTypDokumentuTabela.deleteAll();
        this.slTypyPokoiTabela.deleteAll();


        this.slTypDokumentuTabela.save(new SLTypDokumentu("dowód"));
        this.slTypDokumentuTabela.save(new SLTypDokumentu("paszport"));

        this.slTypyPokoiTabela.save(new SLTypyPokoi("jedynka"));
        this.slTypyPokoiTabela.save(new SLTypyPokoi("dwójka"));

        int idTypDokumentuPaszport = slTypDokumentuTabela.findSLTypDokumentuByNazwa("paszport").getId();
        int idTypDokumentuDowod = slTypDokumentuTabela.findSLTypDokumentuByNazwa("dowód").getId();

        int idTypPokojuJedynka = slTypyPokoiTabela.findSLTypyPokoiByNazwa("jedynka").getId();
        int idTypPokojuDwojka = slTypyPokoiTabela.findSLTypyPokoiByNazwa("dwójka").getId();

        this.klienciTabela.save(new Klienci("Jan", "Kowalski", "aaa@test.pl", 555, "22", idTypDokumentuDowod));
        this.klienciTabela.save(new Klienci("Marek", "Test", "bbb@test.pl", 111, "333", idTypDokumentuPaszport));

        this.pokojeTabela.save(new Pokoje(10, idTypPokojuDwojka, false, "Pokoj tesotwy 1"));
        this.pokojeTabela.save(new Pokoje(20, idTypPokojuJedynka, false, "Pokoj tesotwy 2"));

        int idPokoj1 = pokojeTabela.findPokojeByNumer(10).getId();
        int idPokoj2 = pokojeTabela.findPokojeByNumer(20).getId();

        this.pokojeZdjeciaTabela.save(new PokojeZdjecia(idPokoj1, "C://a.jpg"));
        this.pokojeZdjeciaTabela.save(new PokojeZdjecia(idPokoj2, "C://b.jpg"));

        int idJanKowalski = klienciTabela.findKlienciByNrdokumentu("22").getId();
        int idMarekTest = klienciTabela.findKlienciByNrdokumentu("333").getId();


        this.pokojeRezerwacjeTabela.save(new PokojeRezerwacje(idJanKowalski, idPokoj1, "22.12.2017", "24.12.2017"));
        this.pokojeRezerwacjeTabela.save(new PokojeRezerwacje(idMarekTest, idPokoj2, "12.07.2017", "22.07.2017"));
    }

    public void printTestData() {
        System.out.println("Słownik Typu pokoi");
        System.out.println("---------------------------------------");
        for (SLTypyPokoi slTypyPokoi : this.slTypyPokoiTabela.findAll()) {
            System.out.println(slTypyPokoi);
        }
        System.out.println();

        System.out.println("Słownik typu dokumentów");
        System.out.println("---------------------------------------");
        for (SLTypDokumentu slTypDokumentu : this.slTypDokumentuTabela.findAll()) {
            System.out.println(slTypDokumentu);
        }
        System.out.println();

        System.out.println("Klienci");
        System.out.println("---------------------------------------");
        for (Klienci klienci : this.klienciTabela.findAll()) {
            System.out.println(klienci);
        }
        System.out.println();

        System.out.println("Pokoje");
        System.out.println("---------------------------------------");
        for (Pokoje pokoje : this.pokojeTabela.findAll()) {
            System.out.println(pokoje);
        }
        System.out.println();

        System.out.println("pokoje rezerwacje");
        System.out.println("---------------------------------------");
        for (PokojeRezerwacje pokojeRezerwacje : this.pokojeRezerwacjeTabela.findAll()) {
            System.out.println(pokojeRezerwacje);
        }
        System.out.println();


        System.out.println("pokoje zdjecia");
        System.out.println("---------------------------------------");
        for (PokojeZdjecia pokojeZdjecia : this.pokojeZdjeciaTabela.findAll()) {
            System.out.println(pokojeZdjecia);
        }
        System.out.println();

    }
}
