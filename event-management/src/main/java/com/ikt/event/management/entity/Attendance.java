package com.ikt.event.management.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attendance extends BaseEntity{
    @Enumerated(EnumType.STRING)
    Role role;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User personAttended;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    Event eventAttended;

}
