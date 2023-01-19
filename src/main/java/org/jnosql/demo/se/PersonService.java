package org.jnosql.demo.se;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.nosql.Template;

@ApplicationScoped
public class PersonService {

    @Inject
    private Template template;


}
