package com.pz.DataBase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PokojeRepository extends CrudRepository<Pokoje, Long> {
    Pokoje findPokojeByNumer(int numer);
}
