package com.pz.DataBase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KlienciRepository extends CrudRepository<Klienci, Long> {

    Klienci findKlienciByNrDokumentu(String numerDokumentu);
}
