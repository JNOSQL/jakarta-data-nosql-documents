package org.jnosql.demo.se;

import com.github.javafaker.Faker;
import com.github.javafaker.HowIMetYourMother;
import com.github.javafaker.Pokemon;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.Template;

import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {

        Faker faker = new Faker();
        for (int index = 0; index < 100; index++) {
            Pokemon pokemon = faker.pokemon();

        }

    }
}
