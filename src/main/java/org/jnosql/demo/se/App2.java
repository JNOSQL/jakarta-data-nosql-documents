package org.jnosql.demo.se;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

import java.util.List;

public class App2 {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            Person otavio = new Person("otaviojava", "Otavio", "Salvador");
            Person poliana = new Person("poliana", "Poliana", "Salvador");
            PersonRepository repository = container.select(PersonRepository.class).get();
            repository.saveAll(List.of(otavio, poliana));

            List<Person> salvador = repository.findByCityOrderByNameDesc("Salvador");
            System.out.println("People from Salvador: " + salvador);
        }
    }
}
