package org.jnosql.demo.se;

import com.github.javafaker.Faker;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.document.DocumentTemplate;
import org.eclipse.jnosql.mapping.document.JNoSQLDocumentTemplate;

public class App2 {

    public static void main(String[] args) {

        Faker faker = new Faker();
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            JNoSQLDocumentTemplate template = container.select(JNoSQLDocumentTemplate.class).get();
            for (int index = 0; index < 100; index++) {
                Pokemon pokemon = Pokemon.of(faker);
                template.insert(pokemon);
            }
            template.query("select * from Pokemon").forEach(System.out::println);

            template.prepare("select * from Pokemon where name = @name")
                    .bind("name", "Pikachu")
                    .result()
                    .forEach(System.out::println);

        }


    }
}
