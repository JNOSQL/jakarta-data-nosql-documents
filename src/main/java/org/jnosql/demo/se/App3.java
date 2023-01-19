package org.jnosql.demo.se;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.document.DocumentTemplate;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public class App3 {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            Book effective = new Book("effective-java-1","Effective Java","Java", Year.of(2005), 1);
            DocumentTemplate template = container.select(DocumentTemplate.class).get();

            Optional<Book> book = template.find(Book.class, "effective-java-1");
            System.out.println("People from Salvador: " + book);
        }
    }
}
