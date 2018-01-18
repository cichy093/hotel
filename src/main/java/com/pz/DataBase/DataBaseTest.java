package com.pz.DataBase;


import com.pz.Converter.UzytkownicyConverter;
import com.pz.Dto.UzytkownicyDto;
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
    private UzytkownicyRepository uzytkownicyRepository;

    @Autowired
    public DataBaseTest(KlienciRepository klienciTabela, PokojeRepository pokojeTabela, PokojeRezerwacjeRepository pokojeRezerwacjeTabela, PokojeZdjeciaRepository pokojeZdjeciaTabela, SLTypDokumentuRepository slTypDokumentuTabela, SLTypyPokoiRepository slTypyPokoiTabela, UzytkownicyRepository uzytkownicyRepository) {
        this.klienciRepository = klienciTabela;
        this.pokojeRepository = pokojeTabela;
        this.pokojeRezerwacjeRepository = pokojeRezerwacjeTabela;
        this.pokojeZdjeciaRepository = pokojeZdjeciaTabela;
        this.slTypDokumentuRepository = slTypDokumentuTabela;
        this.slTypyPokoiRepository = slTypyPokoiTabela;
        this.uzytkownicyRepository = uzytkownicyRepository;
    }

    public void loadTestData() {
        this.klienciRepository.deleteAll();
        this.pokojeRepository.deleteAll();
        this.pokojeRezerwacjeRepository.deleteAll();
        this.pokojeZdjeciaRepository.deleteAll();
        this.slTypDokumentuRepository.deleteAll();
        this.slTypyPokoiRepository.deleteAll();
        this.uzytkownicyRepository.deleteAll();

        this.uzytkownicyRepository.save(Uzytkownicy.builder().nazwaUzytkownika("admin").haslo("admin").czyAdmin(true).build());
        this.uzytkownicyRepository.save(Uzytkownicy.builder().nazwaUzytkownika("user").haslo("user").czyAdmin(false).build());

        this.slTypDokumentuRepository.save(SLTypDokumentu.builder().nazwa("Dowód osobisty").build());
        this.slTypDokumentuRepository.save(SLTypDokumentu.builder().nazwa("Paszport").build());

        this.slTypyPokoiRepository.save(SLTypyPokoi.builder().nazwa("jedynka").build());
        this.slTypyPokoiRepository.save(SLTypyPokoi.builder().nazwa("dwójka").build());

        long idTypDokumentuPaszport = this.slTypDokumentuRepository.findSLTypDokumentuByNazwa("Paszport").getId();
        long idTypDokumentuDowod = this.slTypDokumentuRepository.findSLTypDokumentuByNazwa("Dowód osobisty").getId();

        long idTypPokojuJedynka = this.slTypyPokoiRepository.findSLTypyPokoiByNazwa("jedynka").getId();
        long idTypPokojuDwojka = this.slTypyPokoiRepository.findSLTypyPokoiByNazwa("dwójka").getId();

        this.klienciRepository.save(Klienci.builder().imie("Jan").nazwisko("Kowalski").email("aaa@test.pl").telefon(555).nrDokumentu("22")._idTypDokumentu(idTypDokumentuDowod).build());
        this.klienciRepository.save(Klienci.builder().imie("Marek").nazwisko("Test").email("bbb@test.pl").telefon(111).nrDokumentu("333")._idTypDokumentu(idTypDokumentuPaszport).build());

        this.pokojeRepository.save(Pokoje.builder().numer(10).idTypPokoju(idTypPokojuDwojka).niedostepny(false).opis("Pokoj tesotwy 1").build());
        this.pokojeRepository.save(Pokoje.builder().numer(20).idTypPokoju(idTypPokojuJedynka).niedostepny(false).opis("Pokoj tesotwy 2").build());

        long idPokoj1 = this.pokojeRepository.findPokojeByNumer(10).getId();
        long idPokoj2 = this.pokojeRepository.findPokojeByNumer(20).getId();

        this.pokojeZdjeciaRepository.save(PokojeZdjecia.builder().idPokoju(idPokoj1).zdjecie("/images/Circuit.png").build());
        this.pokojeZdjeciaRepository.save(PokojeZdjecia.builder().idPokoju(idPokoj2).zdjecie("/images/Circuit.png").build());
        this.pokojeZdjeciaRepository.save(PokojeZdjecia.builder().idPokoju(idPokoj1).zdjecie("/images/nebula.png").build());
        this.pokojeZdjeciaRepository.save(PokojeZdjecia.builder().idPokoju(idPokoj1).zdjecie("/images/nebula.png").build());
        this.pokojeZdjeciaRepository.save(PokojeZdjecia.builder().idPokoju(idPokoj1).zdjecie("/images/Circuit.png").build());
        this.pokojeZdjeciaRepository.save(PokojeZdjecia.builder().idPokoju(idPokoj1).zdjecie("/images/nebula.png").build());
        this.pokojeZdjeciaRepository.save(PokojeZdjecia.builder().idPokoju(idPokoj1).zdjecie("/images/Circuit.png").build());

        long idJanKowalski = this.klienciRepository.findKlienciByNrDokumentu("22").getId();
        long idMarekTest = this.klienciRepository.findKlienciByNrDokumentu("333").getId();


        this.pokojeRezerwacjeRepository.save(PokojeRezerwacje.builder().idKlienta(idJanKowalski).idPokoju(idPokoj1).dataOd("2017-12-22").dataDo("2017-12-24").build());
        this.pokojeRezerwacjeRepository.save(PokojeRezerwacje.builder().idKlienta(idMarekTest).idPokoju(idPokoj2).dataOd("2017-07-12").dataDo("2017-07-22").build());
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
            System.out.println(pokoje.getId());
        }
        System.out.println();

        System.out.println("pokoje rezerwacje");
        System.out.println("---------------------------------------");
        for (PokojeRezerwacje pokojeRezerwacje : this.pokojeRezerwacjeRepository.findAll()) {
            System.out.println(pokojeRezerwacje.getDataOd());
            System.out.println(pokojeRezerwacje.getDataDo());
            System.out.println(pokojeRezerwacje.getIdPokoju());
            System.out.println(pokojeRezerwacje.getIdKlienta());
        }
        System.out.println();


        System.out.println("pokoje zdjecia");
        System.out.println("---------------------------------------");
        for (PokojeZdjecia pokojeZdjecia : this.pokojeZdjeciaRepository.findAll()) {
            System.out.println(pokojeZdjecia.getIdPokoju());
        }
        System.out.println();

        System.out.println("uzytkownicy");
        System.out.println("---------------------------------------");
        for (Uzytkownicy uzytkownicy : this.uzytkownicyRepository.findAll()) {
            System.out.println(uzytkownicy);
        }
        System.out.println();

    }
}
