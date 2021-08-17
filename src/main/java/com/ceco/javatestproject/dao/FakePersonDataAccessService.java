/*package com.ceco.javatestproject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ceco.javatestproject.model.Person;

import org.springframework.stereotype.Repository;


@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    @Override
    public int dropTable() {
        // TODO Auto-generated method stub
        return 0;
    }

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id).map(p -> {
            int indexOfPersonToUpdate = DB.indexOf(p);
            if(indexOfPersonToUpdate >= 0) {
                DB.set(indexOfPersonToUpdate, new Person(id, update.getName(), update.getAge()));
                return 1;
            }
            return 0;
        })
        .orElse(0);
    }

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
*/