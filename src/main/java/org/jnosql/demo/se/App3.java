package org.jnosql.demo.se;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.document.DocumentTemplate;

import java.util.List;
import java.util.Optional;

public class App3 {

    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

           Person mary = new Person("mary", "Mary", "Chigaco");
            Person otavio = new Person("otaviojava", "Otavio", "Salvador");
            Person alberto = new Person("alberto", "Alberto", "Salvador");
            PersonRepository repository = container.select(PersonRepository.class).get();

            repository.saveAll(List.of(mary, otavio, alberto));

            var people = repository.query("Salvador");

            System.out.println("The result is: " + people);
            Optional<Person> person = repository.findById("otaviojava");
            person.ifPresent(System.out::println);

        }
    }
}
