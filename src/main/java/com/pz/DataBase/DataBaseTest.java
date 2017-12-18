package com.pz.DataBase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataBaseTest {


    private KlienciRepository klienciRepository;
    private PokojeRepository pokojeRepository;
    private PokojeRezerwacjeRepository pokojeRezerwacjeRepository;
    private PokojeZdjeciaRepository pokojeZdjeciaRepository;
    private SLTypDokumentuRepository slTypDokumentuRepository;
    private SLTypyPokoiRepository slTypyPokoiRepository;

    @Autowired
    public DataBaseTest(KlienciRepository klienciTabela, PokojeRepository pokojeTabela, PokojeRezerwacjeRepository pokojeRezerwacjeTabela, PokojeZdjeciaRepository pokojeZdjeciaTabela, SLTypDokumentuRepository slTypDokumentuTabela, SLTypyPokoiRepository slTypyPokoiTabela) {
        this.klienciRepository = klienciTabela;
        this.pokojeRepository = pokojeTabela;
        this.pokojeRezerwacjeRepository = pokojeRezerwacjeTabela;
        this.pokojeZdjeciaRepository = pokojeZdjeciaTabela;
        this.slTypDokumentuRepository = slTypDokumentuTabela;
        this.slTypyPokoiRepository = slTypyPokoiTabela;
    }

    public void loadTestData() {
        this.klienciRepository.deleteAll();
        this.pokojeRepository.deleteAll();
        this.pokojeRezerwacjeRepository.deleteAll();
        this.pokojeZdjeciaRepository.deleteAll();
        this.slTypDokumentuRepository.deleteAll();
        this.slTypyPokoiRepository.deleteAll();


        this.slTypDokumentuRepository.save(new SLTypDokumentu("dowód"));
        this.slTypDokumentuRepository.save(new SLTypDokumentu("paszport"));

        this.slTypyPokoiRepository.save(new SLTypyPokoi("jedynka"));
        this.slTypyPokoiRepository.save(new SLTypyPokoi("dwójka"));

        long idTypDokumentuPaszport = slTypDokumentuRepository.findSLTypDokumentuByNazwa("paszport").getId();
        long idTypDokumentuDowod = slTypDokumentuRepository.findSLTypDokumentuByNazwa("dowód").getId();

        long idTypPokojuJedynka = slTypyPokoiRepository.findSLTypyPokoiByNazwa("jedynka").getId();
        long idTypPokojuDwojka = slTypyPokoiRepository.findSLTypyPokoiByNazwa("dwójka").getId();

        this.klienciRepository.save(new Klienci("Jan", "Kowalski", "aaa@test.pl", 555, "22", idTypDokumentuDowod));
        this.klienciRepository.save(new Klienci("Marek", "Test", "bbb@test.pl", 111, "333", idTypDokumentuPaszport));

        this.pokojeRepository.save(new Pokoje(10, idTypPokojuDwojka, false, "Pokoj tesotwy 1"));
        this.pokojeRepository.save(new Pokoje(20, idTypPokojuJedynka, false, "Pokoj tesotwy 2"));

        long idPokoj1 = pokojeRepository.findPokojeByNumer(10).getId();
        long idPokoj2 = pokojeRepository.findPokojeByNumer(20).getId();

        this.pokojeZdjeciaRepository.save(new PokojeZdjecia(idPokoj1, "C://a.jpg"));
        this.pokojeZdjeciaRepository.save(new PokojeZdjecia(idPokoj2, "C://b.jpg"));

        long idJanKowalski = klienciRepository.findKlienciByNrDokumentu("22").getId();
        long idMarekTest = klienciRepository.findKlienciByNrDokumentu("333").getId();


        this.pokojeRezerwacjeRepository.save(new PokojeRezerwacje(idJanKowalski, idPokoj1, "22.12.2017", "24.12.2017"));
        this.pokojeRezerwacjeRepository.save(new PokojeRezerwacje(idMarekTest, idPokoj2, "12.07.2017", "22.07.2017"));
    }

    public void printTestData() {
        System.out.println("Słownik Typu pokoi");
        System.out.println("---------------------------------------");
        for (SLTypyPokoi slTypyPokoi : this.slTypyPokoiRepository.findAll()) {
            System.out.println(slTypyPokoi.getNazwa());
        }
        System.out.println();

        System.out.println("Słownik typu dokumentów");
        System.out.println("---------------------------------------");
        for (SLTypDokumentu slTypDokumentu : this.slTypDokumentuRepository.findAll()) {
            System.out.println(slTypDokumentu);
        }
        System.out.println();

        System.out.println("Klienci");
        System.out.println("---------------------------------------");
        for (Klienci klienci : this.klienciRepository.findAll()) {
            System.out.println(klienci);
        }
        System.out.println();

        System.out.println("Pokoje");
        System.out.println("---------------------------------------");
        for (Pokoje pokoje : this.pokojeRepository.findAll()) {
            System.out.println(pokoje);
        }
        System.out.println();

        System.out.println("pokoje rezerwacje");
        System.out.println("---------------------------------------");
        for (PokojeRezerwacje pokojeRezerwacje : this.pokojeRezerwacjeRepository.findAll()) {
            System.out.println(pokojeRezerwacje);
        }
        System.out.println();


        System.out.println("pokoje zdjecia");
        System.out.println("---------------------------------------");
        for (PokojeZdjecia pokojeZdjecia : this.pokojeZdjeciaRepository.findAll()) {
            System.out.println(pokojeZdjecia);
        }
        System.out.println();

    }
}
