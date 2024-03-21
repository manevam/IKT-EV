package com.ikt.event.management.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attendance extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    Role attendedAsRole;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    User personAttended;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    Event eventAttended;

}
