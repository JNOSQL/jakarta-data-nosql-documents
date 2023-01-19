package org.jnosql.demo.se;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.Template;

import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Person mary = new Person("mary", "Mary", "Chigaco");
            Person otavio = new Person("otaviojava", "Otavio", "Salvador");
            Person alberto = new Person("alberto", "Alberto", "Salvador");
            Template template = container.select(Template.class).get();

            template.insert(List.of(mary, otavio, alberto));

            List<Person> people = template.select(Person.class)
                    .where("city").eq("Salvador")
                    .orderBy("name").desc().result();

            System.out.println("The result is: " + people);
            Optional<Person> person = template.find(Person.class, "otaviojava");
            person.ifPresent(System.out::println);
            template.delete(Person.class).where("city").eq("Salvador").execute();

        }
    }
}
