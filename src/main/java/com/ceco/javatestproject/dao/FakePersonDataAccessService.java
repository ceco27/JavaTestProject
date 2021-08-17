package com.ceco.javatestproject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ceco.javatestproject.model.Person;

import org.springframework.stereotype.Repository;


@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    @Override
    public int deletePersonById(UUID id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        // TODO Auto-generated method stub
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        // TODO Auto-generated method stub
        return 0;
    }

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName(), person.getAge()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    

}
