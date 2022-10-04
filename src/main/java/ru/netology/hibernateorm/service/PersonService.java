package ru.netology.hibernateorm.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.netology.hibernateorm.model.Persons;
import ru.netology.hibernateorm.repository.PersonsRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonsRepository repo;


    public PersonService(PersonsRepository repo) {
        this.repo = repo;
    }

    public List<Persons> getPersonsByCityOfLiving(String city) {
        return repo.findByCity(city);
    }

    public Persons getPersonsByNameAndSurname(String name, String surname) {
        return repo.findPersonsById_NameAndId_Surname(name, surname).orElseThrow(()->
                new EntityNotFoundException("Persons with" + name + " and" + surname + " not found!"));

    }

//    public List<Persons> getPersonsByAgeLessThan(int age) {
//        return repo.findAllByIdLessThanId_AgeOrderBy(age);
//    }
    //с эти методом сборка падает

    public List<Persons> getPersonsByAge(int age) {
        return repo.findAllPersonsWhereAgeLess(age, Sort.by("age"));
    }
    //c этим падает с 500 при запросe вот стакой формулировкой:
    //org.hibernate.QueryException: could not resolve property: age of: ru.netology.hibernateorm.model.Persons

}
