package com.ikt.event.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "_user")
public class User extends BaseEntity {
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
    @Enumerated(EnumType.STRING)
    Role role;
    String username;
    String password;

    public User(String userName, String userEmail, String phoneNumber, Role role) {
        this.role = role;
        this.name = userName;
        this.email = userEmail;
        this.phone_number = phoneNumber;
    }
}
