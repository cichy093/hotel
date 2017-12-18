package com.pz.DataBase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PokojeZdjeciaRepository extends CrudRepository<PokojeZdjecia, Long> {
}
