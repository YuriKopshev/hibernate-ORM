package ru.netology.hibernateorm.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.hibernateorm.model.Persons;
import ru.netology.hibernateorm.model.PersonsId;
import java.util.List;
import java.util.Optional;


@Repository
public interface PersonsRepository extends JpaRepository<Persons, PersonsId> {

    List<Persons>findByCity(String city);

    Optional<Persons>findPersonsById_NameAndId_Surname(String name,String surname);

    List<Persons> findByIdAgeLessThanOrderByIdAge(int age);

}
