package com.ceco.javatestproject.service;

import java.util.List;
import java.util.UUID;

import com.ceco.javatestproject.dao.PersonDao;
import com.ceco.javatestproject.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("oracledb") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Person getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson) {
        return personDao.updatePersonById(id, newPerson);
    }

    public void dropTable() {
        personDao.dropTable();
    }
}
