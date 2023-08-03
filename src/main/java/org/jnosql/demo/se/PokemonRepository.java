package org.jnosql.demo.se;

import jakarta.data.repository.PageableRepository;
import jakarta.data.repository.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends PageableRepository<Pokemon, String> {

    List<Pokemon> findByName(String name);
}
