package com.ikt.event.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Person extends BaseEntity{
    @Column(nullable = false)
    @Getter
    String name;
    @Column(nullable = false)
    @Getter
    String email;
    @Getter
    String phone_number;

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company;

    @ManyToMany
    @JoinTable(
            name = "has_role",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> rolesPersonHas;

    public Person(String personName, String personEmail, String phoneNumber) {
        rolesPersonHas = new ArrayList<>();
        this.name = personName;
        this.email = personEmail;
        this.phone_number = phoneNumber;
    }
}
