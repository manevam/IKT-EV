package com.ikt.event.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Event extends BaseEntity{
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String venue;
    @Column(name = "date")
    LocalDate date;
    @Column(nullable = false, name = "event_type")
    String eventType;
    @Column(nullable = false)
    Integer budget;

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company;

    @ManyToOne
    @JoinColumn(name = "coordinator_id")
    User coordinator;

}
