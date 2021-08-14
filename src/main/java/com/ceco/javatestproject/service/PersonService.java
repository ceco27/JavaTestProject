package com.ceco.javatestproject.service;

import com.ceco.javatestproject.dao.PersonDao;
import com.ceco.javatestproject.model.Person;

public class PersonService {
    
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

}
