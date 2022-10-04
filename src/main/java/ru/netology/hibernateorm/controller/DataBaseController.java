package ru.netology.hibernateorm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernateorm.model.Persons;
import ru.netology.hibernateorm.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class DataBaseController {

    private final PersonService service;

    public DataBaseController(PersonService service) {
        this.service = service;
    }


    @GetMapping("persons/by-city")
    private List<Persons> getPersons(@RequestParam String city) {
        return service.getPersonsByCityOfLiving(city);
    }

    @GetMapping("persons/by-name-surname")
    private Persons getPersonsByNameSurname(@RequestParam String name, @RequestParam String surname){
        return service.getPersonsByNameAndSurname(name,surname);
    }

    @GetMapping("persons/by-age")
    private List<Persons> getPersonsByAge(@RequestParam String age) {
        return service.getPersonsByAge(Integer.parseInt(age));
    }
}
