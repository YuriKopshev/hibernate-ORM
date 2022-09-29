package ru.netology.hibernateorm.model;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "PERSONS")
public class Persons {

    @EmbeddedId
    private PersonsId id;

    private String phone_number;

    private String city_of_living;
}
