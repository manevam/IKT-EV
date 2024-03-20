package com.ikt.event.management.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@Getter
public class Role extends BaseEntity{
    String description;

    @Column(name = "role_type")
    String roleType;

    @ManyToMany(mappedBy = "rolesPersonHas")
    List<Person> peopleWithThisRole;

    public Role(String description, String type) {
        peopleWithThisRole = new ArrayList<>();
        this.description = description;
        this.roleType = type;
    }
}
