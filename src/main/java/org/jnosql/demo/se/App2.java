package org.jnosql.demo.se;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.document.DocumentTemplate;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public class App2 {

    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Book effectiveJava = new Book("effective-1", "Effective Java", 1, Year.of(2005));
            DocumentTemplate template = container.select(DocumentTemplate.class).get();

//            template.insert(effectiveJava);
            Book second = effectiveJava.newEdition("effective-2", Year.of(2015));
            Book third = second.newEdition("effecite-3", Year.of(2019));
//            template.insert(List.of(second, third));
//            Optional<Book> book = template.find(Book.class, "effective-1");
//            System.out.println("The book result is: " + book);
            List<Book> effectives = template.select(Book.class).where("title").eq("Effective Java")
                    .orderBy("edition").desc().limit(1).result();

            System.out.println("The effective books: " + effectives);

        }
    }
}
