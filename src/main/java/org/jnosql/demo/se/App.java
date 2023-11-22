package org.jnosql.demo.se;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.PreparedStatement;

import net.datafaker.Faker;
import org.eclipse.jnosql.mapping.document.JNoSQLDocumentTemplate;


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
