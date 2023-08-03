package org.jnosql.demo.se;

import jakarta.data.repository.PageableRepository;
import jakarta.data.repository.Repository;

@Repository
public interface PokemonRepository extends PageableRepository<Pokemon, String> {
}
