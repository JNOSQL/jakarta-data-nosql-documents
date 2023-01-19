package org.jnosql.demo.se;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.time.Year;

@Entity
public record Book(@Id String id,
                   @Column("title") String title,
                   @Column("category") String category,
                   @Column("year") Year year,
                   @Column("edition") int edition) {
}
