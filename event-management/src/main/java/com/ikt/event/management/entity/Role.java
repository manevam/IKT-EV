package com.ikt.event.management.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Role extends BaseEntity{
    String description;

    @Column(name = "role_type")
    String roleType;

    @ManyToMany(mappedBy = "rolesUserHas")
    List<User> peopleWithThisRole;
}
