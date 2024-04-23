package com.ikt.event.management.repository.views;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventDto {
    String name;
    String venue;
    LocalDate date;
    String eventType;
    Integer budget;
    Integer companyId;
    Integer coordinatorId;
}
