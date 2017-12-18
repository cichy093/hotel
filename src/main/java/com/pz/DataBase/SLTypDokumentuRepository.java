package com.pz.DataBase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SLTypDokumentuRepository extends CrudRepository<SLTypDokumentu, Long> {
    SLTypDokumentu findSLTypDokumentuByNazwa(String nazwa);
}
