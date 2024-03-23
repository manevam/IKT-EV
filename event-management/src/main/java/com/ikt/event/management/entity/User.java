package com.ikt.event.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "_user")
public class User extends BaseEntity{
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
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> rolesUserHas;
}
