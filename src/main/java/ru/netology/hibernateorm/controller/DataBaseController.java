package ru.netology.hibernateorm.controller;

import jdk.jfr.Percentage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernateorm.model.Persons;
import ru.netology.hibernateorm.repository.PersonsRepo;

import java.util.List;

@RestController
@RequestMapping("/")
public class DataBaseController {

    private final PersonsRepo repo;

    public DataBaseController(PersonsRepo repo) {
        this.repo = repo;
    }

    @GetMapping("persons/by-city")
    public List<Persons> getPersons(@RequestParam String city) {
      return repo.getPersonsByCity(city);
    }
}
