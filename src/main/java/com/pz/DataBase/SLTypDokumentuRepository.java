package com.pz.DataBase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marcin on 05.12.2017.
 */
@Repository
public interface SLTypDokumentuRepository extends CrudRepository<SLTypDokumentu, Long> {

    SLTypDokumentu findSLTypDokumentuByNazwa(String nazwa);
}
