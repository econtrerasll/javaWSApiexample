package com.claro.resttest.Repository;

import com.claro.resttest.Entities.Router;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouterRepository extends CrudRepository<Router,Long> {
}
