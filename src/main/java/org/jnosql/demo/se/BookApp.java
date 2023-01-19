package org.jnosql.demo.se;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.Template;
import jakarta.nosql.document.DocumentTemplate;

import java.time.Year;
import java.util.List;

public class BookApp {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            Template template = container.select(DocumentTemplate.class).get();
            Book effectiveJava = new Book("effective-java-1","Effective Java", "Java",
                    Year.of(2018), 3);

            template.insert(effectiveJava);

            List<Book> books = template.select(Book.class).where("id").eq("effective-java-1").result();
            books.forEach(System.out::println);
        }
    }
}
