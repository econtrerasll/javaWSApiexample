package com.claro.resttest.Repository;

import com.claro.resttest.Entities.Celular;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelularRepository extends CrudRepository<Celular, Long> {
}
