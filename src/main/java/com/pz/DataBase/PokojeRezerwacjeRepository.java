package com.pz.DataBase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PokojeRezerwacjeRepository extends CrudRepository<PokojeRezerwacje, Long> {
    PokojeRezerwacje findPokojeRezerwacjeByIdPokoju(Long id);
}
