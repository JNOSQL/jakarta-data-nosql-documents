package org.jnosql.demo.se;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.time.Year;

@Entity
public record Book(@Id String id, @Column("title") String title,
                   @Column("edition") int edition,
                   @Column("year") Year year) {

    Book newEdition(String id, Year year) {
        return new Book(id, this.title, edition+1, year);
    }
}
