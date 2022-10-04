package ru.netology.hibernateorm.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Getter
@Setter
@ToString

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persons {

    @EmbeddedId
    private PersonsId id;

    private String phone_number;

    private String city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Persons persons = (Persons) o;
        return id != null && Objects.equals(id, persons.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
