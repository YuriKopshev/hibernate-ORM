package ru.netology.hibernateorm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernateorm.model.Persons;
import ru.netology.hibernateorm.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/")
public class DataBaseController {

    private final PersonService service;

    public DataBaseController(PersonService service) {
        this.service = service;
    }


    @GetMapping("/persons/by-city")
    private List<Persons> getPersons(@RequestParam String city) {
        return service.getPersonsByCityOfLiving(city);
    }
}
