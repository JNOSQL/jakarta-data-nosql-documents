package org.jnosql.demo.se;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Param;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {

    @Query("select * from Person where city = @city order by name")
    List<Person> query(@Param("city") String city);
}
