package org.jnosql.demo.se;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.Template;

import java.util.Optional;

public class App {

    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            Person person = new Person("otaviojava", "Otavio", "Salvador");
            Template template = container.select(Template.class).get();
            template.insert(person);
            Optional<Person> otaviojava = template.find(Person.class, "otaviojava");
            System.out.println("the result " + otaviojava);

        }
    }
}
