package org.jnosql.demo.se;

import com.github.javafaker.Faker;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.UUID;

@Entity
public record Pokemon(@Id String id, @Column String name,@Column String location) {


    public static Pokemon of(Faker faker){
        var pokemon = faker.pokemon();
        return new Pokemon(UUID.randomUUID().toString(), pokemon.name(), pokemon.location());
    }
}
