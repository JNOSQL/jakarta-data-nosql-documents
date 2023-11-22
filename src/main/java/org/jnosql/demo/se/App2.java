package org.jnosql.demo.se;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import net.datafaker.Faker;
import org.eclipse.jnosql.mapping.DatabaseQualifier;

public class App2 {

    public static void main(String[] args) {

        Faker faker = new Faker();
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            PokemonRepository repository = container.
                    select(PokemonRepository.class, DatabaseQualifier.ofDocument())
                    .get();

            for (int index = 0; index < 100; index++) {
                Pokemon pokemon = Pokemon.of(faker);
                repository.save(pokemon);
            }

            repository.findByName("Pikachu").forEach(System.out::println);


        }


    }
}
