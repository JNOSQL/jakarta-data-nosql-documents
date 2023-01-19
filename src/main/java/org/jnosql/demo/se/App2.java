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

            Book first = new Book("effective-1", "Effective Java", 1, Year.of(2005));
            DocumentTemplate template = container.select(DocumentTemplate.class).get();

            template.insert(first);
            Book second = first.newEdition("effective-2", Year.of(2015));

            Book third = second.newEdition("effecite-3", Year.of(2019));
            List<Book> books = template.select(Book.class).where("title").eq("Effective Java")
                    .orderBy("edition").desc().limit(1).result();

            System.out.println("The effective books: " + books);

        }
    }
}
