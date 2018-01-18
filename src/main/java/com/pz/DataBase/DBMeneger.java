package com.pz.DataBase;

import com.pz.Converter.*;
import com.pz.Dto.*;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    @Autowired
    private PokojeConverter pokojeConverter;
    @Autowired
    private PokojeZdjeciaConverter pokojeZdjeciaConverter;
    @Autowired
    private KlienciConverter klienciConverter;
    @Autowired
    private PokojeRezerwacjeConverter pokojeRezerwacjeConverter;

    private PokojeZdjecia pokojeZdjecia;


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

    public Boolean isAdmin(UzytkownicyDto uzytkownicyDto) {
        Boolean isAdmin = false;
        Long idUser = this.uzytkownicyRepository.findUzytkownicyByNazwaUzytkownikaAndHaslo(uzytkownicyDto.getNazwaUzytkownika(), uzytkownicyDto.getHaslo()).getId();
        try {
            if (this.uzytkownicyRepository.exists(idUser) && this.uzytkownicyRepository.findOne(idUser).isCzyAdmin()) {
                isAdmin = true;
            }
        } catch (Exception ex) {
            isAdmin = false;
        }
        return isAdmin;
    }

    public List<PokojeDto> getListOfRooms() {
        List<PokojeDto> listOfRoomsDto = new ArrayList<>();
        List<Pokoje> listOfRooms = (List<Pokoje>) this.pokojeRepository.findAll();
        for (Pokoje room : listOfRooms) {
            listOfRoomsDto.add(this.pokojeConverter.convertToDto(room));
        }
        return listOfRoomsDto;
    }

    public List<PokojeZdjeciaDto> getListRoomsPhoto() {
        List<PokojeZdjeciaDto> listOfRoomsPhotoDto = new ArrayList<>();
        List<PokojeZdjecia> listOfRoomsPhoto = (List<PokojeZdjecia>) this.pokojeZdjeciaRepository.findAll();
        for (PokojeZdjecia roomPhoto : listOfRoomsPhoto) {
            listOfRoomsPhotoDto.add(this.pokojeZdjeciaConverter.convertToDto(roomPhoto));
        }
        return listOfRoomsPhotoDto;
    }

    public List<String> getListOfRoomPhotos(Long id, List<PokojeZdjeciaDto> pokojeZdjeciaDto) {
        List<String> listOfRoomPhotos = new ArrayList<>();
        for (PokojeZdjeciaDto roomPhoto : pokojeZdjeciaDto) {
            if (roomPhoto.getIdPokoju() == id) {
                listOfRoomPhotos.add(roomPhoto.getZdjecie());
            }
        }
        return listOfRoomPhotos;
    }

    public int getRoomNumber(Long idPokoju) {
        int nrPokoju = pokojeRepository.findOne(idPokoju).getNumer();
        return nrPokoju;
    }

    public PokojeDto getRoom(Long idPokoju) {
        PokojeDto room = this.pokojeConverter.convertToDto(this.pokojeRepository.findOne(idPokoju));
        return room;
    }

    public void roomAccessibility(Long idPokoju, Boolean access) {
        this.pokojeRepository.findOne(idPokoju).setNiedostepny(access);
    }

    public Long idDocType(String docType) {
        return this.slTypDokumentuRepository.findSLTypDokumentuByNazwa(docType).getId();
    }

    public void newCustomer(KlienciDto klienciDto) {
        this.klienciRepository.save(this.klienciConverter.convertToEntity(klienciDto));
    }

    public Long getIdCustomer(String docNmb) {
        return this.klienciRepository.findKlienciByNrDokumentu(docNmb).getId();
    }

    public void newReservation(PokojeRezerwacjeDto pokojeRezerwacjeDto) {
        this.pokojeRezerwacjeRepository.save(this.pokojeRezerwacjeConverter.convertToEntity(pokojeRezerwacjeDto));
    }

    public void changeRoomAvailable(PokojeDto pokojeDto) {
        this.pokojeRepository.save(this.pokojeConverter.convertToEntity(pokojeDto));
    }

    public List<String> getListDateTo(Long idPokoju) {
        List<String> lista = new ArrayList<>();
        for (PokojeRezerwacje pokojeRezerwacje : this.pokojeRezerwacjeRepository.findAll()) {
            if (pokojeRezerwacje.getIdPokoju() == idPokoju) {
                lista.add(pokojeRezerwacje.getDataDo());
            }
        }
        return lista;
    }
    public List<String> getListDateFrom(Long idPokoju) {
        List<String> lista = new ArrayList<>();
        for (PokojeRezerwacje pokojeRezerwacje : this.pokojeRezerwacjeRepository.findAll()) {
            if (pokojeRezerwacje.getIdPokoju() == idPokoju) {
                lista.add(pokojeRezerwacje.getDataOd());
            }
        }
        return lista;
    }
}
