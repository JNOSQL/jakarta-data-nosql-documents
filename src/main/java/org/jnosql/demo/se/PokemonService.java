package org.jnosql.demo.se;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Qualifier;
import org.eclipse.jnosql.mapping.Database;
import org.eclipse.jnosql.mapping.DatabaseType;

@ApplicationScoped
public class PokemonService {


    @Inject
    @Database(value = DatabaseType.DOCUMENT)
    private PokemonRepository repository;
}
