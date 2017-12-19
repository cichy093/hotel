package com.pz.DataBase;

import org.springframework.data.repository.CrudRepository;


public interface UzytkownicyRepository extends CrudRepository<Uzytkownicy, Long> {

    Uzytkownicy findUzytkownicyByNazwaUzytkownikaAndHaslo(String login, String haslo);
}
