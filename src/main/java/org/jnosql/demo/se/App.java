package org.jnosql.demo.se;

import com.github.javafaker.Faker;
import com.github.javafaker.HowIMetYourMother;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.PreparedStatement;
import jakarta.nosql.Template;
import jakarta.nosql.document.DocumentTemplate;
import org.eclipse.jnosql.mapping.document.JNoSQLDocumentTemplate;

import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {

        Faker faker = new Faker();
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            JNoSQLDocumentTemplate template = container.select(JNoSQLDocumentTemplate.class).get();

            for (int index = 0; index < 100; index++) {
                Pokemon pokemon = Pokemon.of(faker);
                template.insert(pokemon);
            }

            PreparedStatement prepare = template.prepare("select * from Pokemon where name = @name");
            prepare.bind("name", "Pikachu");
            prepare.result().forEach(System.out::println);


        }


    }
}
