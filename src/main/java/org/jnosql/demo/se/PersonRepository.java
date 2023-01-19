package org.jnosql.demo.se;

import jakarta.data.repository.PageableRepository;
import jakarta.data.repository.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends PageableRepository<Person, String> {

    List<Person> findByCityOrderByNameDesc(String city);
}
