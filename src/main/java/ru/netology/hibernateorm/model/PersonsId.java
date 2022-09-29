package ru.netology.hibernateorm.model;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class PersonsId implements Serializable {
    private String name;

    private String surname;

    private int age;

}
