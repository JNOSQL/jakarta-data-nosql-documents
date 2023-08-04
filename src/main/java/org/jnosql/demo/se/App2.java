package org.jnosql.demo.se;

import com.github.javafaker.Faker;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.PreparedStatement;
import org.eclipse.jnosql.mapping.DatabaseQualifier;
import org.eclipse.jnosql.mapping.document.JNoSQLDocumentTemplate;

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
