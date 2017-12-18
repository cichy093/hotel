package com.pz.DataBase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SLTypyPokoiRepository extends CrudRepository<SLTypyPokoi, Long> {
    SLTypyPokoi findSLTypyPokoiByNazwa(String nazwa);
}
