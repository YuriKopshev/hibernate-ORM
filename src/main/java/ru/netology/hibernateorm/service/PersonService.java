package ru.netology.hibernateorm.service;

import org.springframework.stereotype.Service;
import ru.netology.hibernateorm.model.Persons;
import ru.netology.hibernateorm.repository.PersonsRepository;

import java.util.List;

@Service
public class PersonService {

    private final PersonsRepository repo;


    public PersonService(PersonsRepository repo) {
        this.repo = repo;
    }

    public List<Persons>getPersonsByCityOfLiving(String city){
        return repo.findByCity(city);
    }

}
