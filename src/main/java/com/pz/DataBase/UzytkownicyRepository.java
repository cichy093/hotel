package com.pz.DataBase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UzytkownicyRepository extends CrudRepository<Uzytkownicy, Long> {

    Uzytkownicy findUzytkownicyByNazwaUzytkownikaAndHaslo(String login, String haslo);
}
