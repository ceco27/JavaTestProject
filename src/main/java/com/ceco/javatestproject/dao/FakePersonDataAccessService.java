package com.ceco.javatestproject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ceco.javatestproject.model.Person;

public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName(), person.getAge()));
        return 1;
    }
}
