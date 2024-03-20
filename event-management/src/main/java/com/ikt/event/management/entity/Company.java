package com.ikt.event.management.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Company extends BaseEntity{

    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String email;

    public Company(String companyName, String companyEmail) {
        this.name = companyName;
        this.email = companyEmail;
    }
}
