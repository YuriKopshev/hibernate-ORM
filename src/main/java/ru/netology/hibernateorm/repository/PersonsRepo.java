package ru.netology.hibernateorm.repository;

import org.springframework.stereotype.Repository;
import ru.netology.hibernateorm.model.Persons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonsRepo {

    @PersistenceContext
    EntityManager manager;

    public List<Persons> getPersonsByCity(String city) {

        return (List<Persons>) manager.createQuery("select p from Persons p where p.city_of_living =:city").setParameter("city", city).getResultList();
    }
}
