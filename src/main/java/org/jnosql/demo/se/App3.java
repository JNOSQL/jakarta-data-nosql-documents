package org.jnosql.demo.se;

import com.github.javafaker.Faker;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import org.eclipse.jnosql.mapping.document.JNoSQLDocumentTemplate;

import java.util.List;

public class App3 {

    public static void main(String[] args) {

        Faker faker = new Faker();
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            PokemonRepository repository = container.select(PokemonRepository.class).get();
            for (int index = 0; index < 100; index++) {
                Pokemon pokemon = Pokemon.of(faker);
                repository.save(pokemon);
            }
            repository.findAll().forEach(System.out::println);

            List<Pokemon> pikachu = repository.findByName("Pikachu");

            System.out.println("query by name " +  pikachu);


        }


    }
}
