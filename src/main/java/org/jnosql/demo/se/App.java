package org.jnosql.demo.se;

import com.github.javafaker.Faker;
import com.github.javafaker.HowIMetYourMother;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.Template;
import jakarta.nosql.document.DocumentTemplate;

import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {

        Faker faker = new Faker();
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            DocumentTemplate template = container.select(DocumentTemplate.class).get();
            for (int index = 0; index < 100; index++) {
                Pokemon pokemon = Pokemon.of(faker);
                template.insert(pokemon);
            }
            template.select(Pokemon.class).where("location")
                    .eq("Canalave City").stream().forEach(System.out::println);
        }


    }
}
