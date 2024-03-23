package com.ikt.event.management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Company extends BaseEntity{

    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String email;

}
